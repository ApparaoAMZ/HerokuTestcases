package com.amazon.gdpr.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.gdpr.controller.GdprController;
import com.amazon.gdpr.model.gdpr.input.AnonymizeDetails;
import com.amazon.gdpr.model.gdpr.output.RunAnonymizeMapping;
import com.amazon.gdpr.model.gdpr.output.RunModuleMgmt;
import com.amazon.gdpr.model.gdpr.output.RunSummaryMgmt;
import com.amazon.gdpr.processor.AnonymizationProcessor;
import com.amazon.gdpr.processor.BackupTableProcessor;
import com.amazon.gdpr.processor.GDPRDataProcessor;
import com.amazon.gdpr.processor.SummaryDataProcessor;
import com.amazon.gdpr.util.GlobalConstants;

/****************************************************************************************
 * This Service performs the Initialization activity on the Heroku GDPR  
 * This will be invoked by the GDPRController
 ****************************************************************************************/
@Service
public class InitService {
	
	public static String MODULE_INITIALIZATION = GlobalConstants.MODULE_INITIALIZATION;
	public static String STATUS_SUCCESS = GlobalConstants.STATUS_SUCCESS;
	
	public List<RunAnonymizeMapping> runAnonymizeMappingList=null;
	public Map<String, RunSummaryMgmt> runSummaryMgmtMap=null;
	
	@Autowired
	AnonymizationProcessor anonymizationProcessor;
		
	/**
	 * The initialization activities are performed. Verification of all the basic steps required for the project
	 * @param runId
	 * @return
	 */
	public String initialize(int runId) {
		//String startInitServiceDateTime = new SimpleDateFormat(GDPRStaticData.DATE_FORMAT)
		//.format(Calendar.getInstance().getTime());
		Date  startInitServiceDate = new Date();
		
		Boolean initializationStatus = false;		
		List<AnonymizeDetails> activeAnonymizeDtlsList = anonymizationProcessor.fetchActiveAnonymizationDetails();
		
		if(activeAnonymizeDtlsList != null && activeAnonymizeDtlsList.size() > 0 )			
			initializationStatus = anonymizationProcessor.loadRunAnonymization(runId, activeAnonymizeDtlsList);
		else
			return "No anonymization data to depersonalize.";		
		if(initializationStatus){
			BackupTableProcessor bkpupTableProcessor = new BackupTableProcessor();			
			initializationStatus = bkpupTableProcessor.processBkpupTable(runId, activeAnonymizeDtlsList);
		}else
			return "Anonymization Processing issue.";
		if(initializationStatus){
			GDPRDataProcessor gdprDataProcessor = new GDPRDataProcessor();
			initializationStatus = gdprDataProcessor.reOrganizeGDPRData(runId);			
			//Load ModuleMgmt
		}else
			return "Backup Table Processor had an issue";			
		if(initializationStatus){
			SummaryDataProcessor summaryDataProcessor = new SummaryDataProcessor();
			runSummaryMgmtMap = summaryDataProcessor.processSummaryData(runId);			
		}else
			return "GDPR Data reorganize had an issue";
		if(runSummaryMgmtMap == null)
			return "Summary Management Table loading had an issue";
		else{
			//String endInitServiceDateTime = 
			//new SimpleDateFormat(GDPRStaticData.DATE_FORMAT).format(Calendar.getInstance().getTime());
			Date  endInitServiceDate = new Date();
			RunModuleMgmt runModuleMgmt = new RunModuleMgmt(runId, MODULE_INITIALIZATION, STATUS_SUCCESS, 
															startInitServiceDate, endInitServiceDate, "");
		}
		return STATUS_SUCCESS;
	}
}