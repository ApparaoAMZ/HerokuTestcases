package com.amazon.gdpr.processor;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazon.gdpr.controller.GdprController;
import com.amazon.gdpr.model.gdpr.input.AnonymizeDetails;
import com.amazon.gdpr.processor.GDPRDataProcessor;

public class GDPRDataProcessorTest {
	@Autowired
	GdprController gdprController; 
	@Autowired
	private GDPRDataProcessor gDPRDataProcessor;
	
	int runId = 0;
	List<AnonymizeDetails> activeAnonymizeDtlsList=null;

	@Test
	public void reOrganizeGDPRDataTest() {
		runId= gdprController.initiateRun("Test Run");
		boolean gdprDataProcessStatus=gDPRDataProcessor.reOrganizeGDPRData(runId);
		assertTrue(gdprDataProcessStatus);
		
	}
}
