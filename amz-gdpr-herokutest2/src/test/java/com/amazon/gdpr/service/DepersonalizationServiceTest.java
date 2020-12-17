package com.amazon.gdpr.service;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazon.gdpr.controller.GdprController;
import com.amazon.gdpr.model.gdpr.output.RunSummaryMgmt;

public class DepersonalizationServiceTest {

	
	@Autowired
	GdprController gdprController; 
	@Autowired
	private DepersonalizationService depersonalizationService;
	
	int runId = 0;
	Map<String, RunSummaryMgmt> runSummaryMgmtMap = null;
	Map<String, Set<String>> mapParentIds =null;
	@Test
	public void depersonalizeTest() {
		
		String test=depersonalizationService.depersonalize(runSummaryMgmtMap, runId);
		
	}
	
	
}
