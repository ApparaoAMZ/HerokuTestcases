package com.amazon.gdpr.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazon.gdpr.controller.GdprController;

public class InitServiceTest {
	
	@Autowired
	GdprController gdprController; 
	@Autowired
	private InitService initService;
	int runId = 0;
	@Test
	public void initializeTest() {
		
		runId= gdprController.initiateRun("Test Run");
		String test=initService.initialize(runId);
		
		
	}

}
