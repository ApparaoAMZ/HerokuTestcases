package com.amazon.gdpr.processor;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazon.gdpr.controller.GdprController;
import com.amazon.gdpr.model.gdpr.output.RunSummaryMgmt;



public class SummaryDataProcessorTest {

	
	@Autowired
	GdprController gdprController; 
	@Autowired
	private SummaryDataProcessor summaryDataProcessor;
	Map<String, RunSummaryMgmt> runSummaryMgmtMap = null;
	int runId = 0;
	@Test
	public void processSummaryDataTest() {
		runId= gdprController.initiateRun("Test Run");
		runSummaryMgmtMap=summaryDataProcessor.processSummaryData(runId);
		
		
	}
	@Test
	public void runSummaryMgmtMapTest() {
		
		runSummaryMgmtMap=summaryDataProcessor.processSummaryData(runSummaryMgmtMap);
		
		
	}
}
