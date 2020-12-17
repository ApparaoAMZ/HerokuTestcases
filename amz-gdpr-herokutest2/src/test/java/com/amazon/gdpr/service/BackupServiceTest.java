package com.amazon.gdpr.service;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazon.gdpr.controller.GdprController;
import com.amazon.gdpr.model.gdpr.output.RunSummaryMgmt;


public class BackupServiceTest {

	@Autowired
	GdprController gdprController; 
	@Autowired
	private BackupService bkpService;
	int runId = 0;
	Map<String, RunSummaryMgmt> runSummaryMgmtMap = null;
	Map<String, Set<String>> mapParentIds =null;
	@Test
	public void backupServiceTest() {
		
		runId= gdprController.initiateRun("Test Run");
		runSummaryMgmtMap=bkpService.backupService(runId, runSummaryMgmtMap);
		
		
	}
	
	@Test
	public void fetchParentIdsTest() {
		
		mapParentIds=bkpService.fetchParentIds();
		
	}
	
	@Test
	public void performBackupTest() {
		
		runId= gdprController.initiateRun("Test Run");
		runSummaryMgmtMap=bkpService.performBackup(mapParentIds, runSummaryMgmtMap);
		
		
	}
	
}
