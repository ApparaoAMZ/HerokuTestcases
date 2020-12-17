package com.amazon.gdpr.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GdprControllerTest {

	@Autowired
	GdprController gdprController; 
	int runId = 0;
	@Test
	public void herokuDepersonalizationTest() {
		String depersonalizationStatus= gdprController.herokuDepersonalization("Test Run");
		assertEquals("Success", depersonalizationStatus);
		
	}
	
	@Test
	public void initiateRunTest() {
		runId= gdprController.initiateRun("Test Run");
		
		
	}
	@Test
	public void initializeTest() {
		 String runName= gdprController.initialize(runId);
		
		
	}
	
}
