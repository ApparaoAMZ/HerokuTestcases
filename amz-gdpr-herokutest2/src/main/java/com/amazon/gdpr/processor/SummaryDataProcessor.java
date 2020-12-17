package com.amazon.gdpr.processor;

import java.util.HashMap;
import java.util.Map;

import com.amazon.gdpr.model.gdpr.output.RunSummaryMgmt;

public class SummaryDataProcessor {
	
	Map<String, RunSummaryMgmt> runSummaryMgmtMap = null;
	
	public Map<String, RunSummaryMgmt> processSummaryData(int runId){
		//Fetch RunAnonymizeMapping, AnonymizeDetails, ImpactTable table data
		//Navigate through the data and load the fields - 
		//Category 	Region	Country Code	Impact Table Id	Backup Query	Depersonalization Query in RunSummaryMgmt Table
		runSummaryMgmtMap = new HashMap<String, RunSummaryMgmt>();
		return runSummaryMgmtMap;
	}
	
	public Map<String, RunSummaryMgmt> processSummaryData(Map<String, RunSummaryMgmt> runSmryMgmtMap){
		//Update the backup row count
		runSummaryMgmtMap = new HashMap<String, RunSummaryMgmt>();
		return runSummaryMgmtMap;
	}
}
