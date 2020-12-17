package com.amazon.gdpr.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amazon.gdpr.model.gdpr.output.RunSummaryMgmt;
import com.amazon.gdpr.processor.RunMgmtProcessor;
import com.amazon.gdpr.service.BackupService;
import com.amazon.gdpr.service.InitService;
import com.amazon.gdpr.util.GlobalConstants;

/****************************************************************************************
 * This controller in the main initiator. 
 * This will be invoked by the Heroku UI or the scheduler
 ****************************************************************************************/
@Controller
public class GdprController {

	private static String STATUS_SUCCESS 			= GlobalConstants.STATUS_SUCCESS;
	private static String STATUS_FAILURE 			= GlobalConstants.STATUS_FAILURE;
	private static String CURRENT_CLASS		 		= GlobalConstants.CLS_GDPRCONTROLLER;
	
	int runId = 0;
	Map<String, RunSummaryMgmt> runSummaryMgmtMap = null;
	
	@Autowired
	RunMgmtProcessor runMgmtProcessor;
	
	@Autowired
	BackupService bkpupService;
	
	/**
	 * The different modules involved are invoked one by one from this method
	 * @param runName - Input to maintain the run information
	 * @return String - The status of the run
	 */
	@RequestMapping("/depersonalization")
	public String herokuDepersonalization(String runName) {
		String CURRENT_METHOD = "herokuDepersonalization";		
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+" :: Inside method. ");
		
		runId = initiateRun(runName);
		String depersonalizationStatus = STATUS_FAILURE;
		if(runId > 0)
			depersonalizationStatus = initialize(runId);
		if(depersonalizationStatus.compareTo(STATUS_SUCCESS) ==0)
			runSummaryMgmtMap = backupInitialize(runId, runSummaryMgmtMap);
		if(runSummaryMgmtMap != null) {
			
		}
		
		return depersonalizationStatus;
	}
	
	/**
	 * This initiates the run. Establishes the run in the DB 
	 * @param runName - Input to maintain the run information
	 * @return int - The RunID that has to be maintained for the entire run
	 */
	public int initiateRun(String runName) {
		String CURRENT_METHOD = "initiateRun";
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+":: Inside method");
		runId =  runMgmtProcessor.initializeRun(runName);
		return runId;
	}
	
	/**
	 * Initialization Module initiated
	 * @param runId - All the activities will have the runId tagged
	 * @return String - The status of the Initialization Module
	 */
	public String initialize(int runId) {
		String CURRENT_METHOD = "initialize";
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+":: Inside method");
		
		InitService init = new InitService();
		String initializeStatus = init.initialize(runId);
		
		if("SUCCESS".compareTo(initializeStatus) == 0) {
			runSummaryMgmtMap = init.runSummaryMgmtMap;
		}
		return "";
	}
	
	
	/**
	 * 
	 * @param runId
	 * @param runSummaryMgmtMap
	 * @return
	 */
	public Map<String, RunSummaryMgmt> backupInitialize(int runId, Map<String, RunSummaryMgmt> runSummaryMgmtMap) {
		String CURRENT_METHOD = "backupInitialize";
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+":: Inside method");
				
		runSummaryMgmtMap = bkpupService.backupService(runId, runSummaryMgmtMap);
		return null;
	}
	
}