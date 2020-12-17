package com.amazon.gdpr.processor;

import static org.junit.Assert.*;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.amazon.gdpr.controller.GdprController;
import com.amazon.gdpr.model.gdpr.output.RunModuleMgmt;

public class ModuleMgmtProcessorTest {

	
	@Autowired
	GdprController gdprController; 
	@Autowired
	private ModuleMgmtProcessor moduleMgmtProcessor;
	
	int runId = 0;
	RunModuleMgmt runModuleMgmt=null;
	
	@Test
	public void updateModuleTest() {
		
		boolean updatemodulestatus=moduleMgmtProcessor.updateModuleStatus(runModuleMgmt);
		assertTrue(updatemodulestatus);
		
	}
}
