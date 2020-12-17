package com.amazon.gdpr.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.amazon.gdpr.model.gdpr.input.AnonymizeDetails;
import com.amazon.gdpr.model.gdpr.output.RunAnonymizeMapping;

/* 
 * ETL action is performed on the Anonymization tracker details
 * Load the details in the AnonymizeMapping table 
 *  
 */
@Component
public class AnonymizationProcessor {
		
	/*
	 * Load active AnonymizeDetails table to RunAnonymizeMapping table  
	 */
	public Boolean loadRunAnonymization(int runId, List<AnonymizeDetails> activeAnonymizeDtlsList){
		Boolean loadRunAnonymizationStatus = false;		
		List<RunAnonymizeMapping> runAnonymizeMappingList = new ArrayList<RunAnonymizeMapping>();
		
		if(activeAnonymizeDtlsList.size() > 0){			
			//Load RunAnonymizeMapping and insert it into the table			
			loadRunAnonymizationStatus = true;
		}
		if(! loadRunAnonymizationStatus){
			//load ModuleMgmt
			//load ErrorMgmt
		}
		return loadRunAnonymizationStatus;
	}
	
	
	/*
	 * Fetch active AnonymizeDetails 
	 */
	public List<AnonymizeDetails> fetchActiveAnonymizationDetails(){
		List<AnonymizeDetails> activeAnonymizeDtls = null;
		return activeAnonymizeDtls;		
	}
	
	/*
	 * Load Anonymization Details
	 */
	public void loadAnonymizationDetails(){
		
	}

}