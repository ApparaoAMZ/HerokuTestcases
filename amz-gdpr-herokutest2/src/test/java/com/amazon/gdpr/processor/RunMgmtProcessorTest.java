package com.amazon.gdpr.processor;

import static org.junit.Assert.*;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazon.gdpr.controller.GdprController;

public class RunMgmtProcessorTest {
	@Autowired
	GdprController gdprController; 
	@Autowired
	private RunMgmtProcessor runMgmtProcessor;
	

	@Test
	public void initializeRunTest() {
		
		int runid=runMgmtProcessor.initializeRun("Test Run");
		System.out.println("runid"+runid);
		
	}
	@Test
	public void initiateNewRunTest() {
		
		int runid=runMgmtProcessor.initiateNewRun("Test Run");
		
		
	}

}
