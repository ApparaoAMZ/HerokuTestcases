package com.amazon.gdpr.processor;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.amazon.gdpr.controller.GdprController;
import com.amazon.gdpr.model.gdpr.input.AnonymizeDetails;

public class AnonymizationProcessorTest {

	@Autowired
	GdprController gdprController; 
	@Autowired
	private AnonymizationProcessor anonymizationProcessor;
	
	int runId = 0;
	List<AnonymizeDetails> activeAnonymizeDtlsList=null;
	
	@Test
	public void loadRunAnonymizationTest() {
		runId= gdprController.initiateRun("Test Run");
		boolean loadRunAnonymizationStatus=anonymizationProcessor.loadRunAnonymization(runId,activeAnonymizeDtlsList);
		assertTrue(loadRunAnonymizationStatus);
		
	}
	
	@Test
	public void fetchActiveAnonymizationDetailsTest() {
		runId= gdprController.initiateRun("Test Run");
		List<AnonymizeDetails> activeAnonymizeDtlsList = anonymizationProcessor.fetchActiveAnonymizationDetails();
		assertNotNull(activeAnonymizeDtlsList);
		
	}
}
