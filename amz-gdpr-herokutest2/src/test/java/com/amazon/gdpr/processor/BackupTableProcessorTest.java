package com.amazon.gdpr.processor;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import com.amazon.gdpr.controller.GdprController;
import com.amazon.gdpr.model.gdpr.input.AnonymizeDetails;
import com.amazon.gdpr.processor.BackupTableProcessor;

@SpringBootTest
public class BackupTableProcessorTest {

	
	@Autowired
	GdprController gdprController; 
	@Autowired
	private BackupTableProcessor backupTableProcessor;
	int runId = 0;
	List<AnonymizeDetails> activeAnonymizeDtlsList=null;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void backupTableTest() {
		runId= gdprController.initiateRun("Test Run");
		boolean backupStaus=backupTableProcessor.processBkpupTable(runId,activeAnonymizeDtlsList);
		assertTrue(backupStaus);
		
	}
	
	@Test
	public void backupTableCheckTest() {
		Boolean bkpupTblProcessStatus = false;
		bkpupTblProcessStatus = backupTableProcessor.bkpupTableCheck(activeAnonymizeDtlsList);
		assertTrue(bkpupTblProcessStatus);
		
	}
	
	@Test
	public void test() {
		System.out.println("Test1");
		int fg=6;
		assertEquals(6, fg);
	}

}
