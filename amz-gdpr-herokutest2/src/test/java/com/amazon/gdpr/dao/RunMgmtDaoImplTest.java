package com.amazon.gdpr.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazon.gdpr.controller.GdprController;
import com.amazon.gdpr.dao.RunMgmtDaoImpl;
import com.amazon.gdpr.model.gdpr.output.RunMgmt;


public class RunMgmtDaoImplTest {

	@Autowired
	GdprController gdprController; 
	@Autowired
	private RunMgmtDaoImpl runMgmtDaoImpl;
	
	RunMgmt runMgmt=null;

	@Test
	public void fetchLastRunDetailTest() {
		
		runMgmt=runMgmtDaoImpl.fetchLastRunDetail();
		
	}
	
	@Test
	public void initiateNewRunTest() {
		
		runMgmtDaoImpl.initiateNewRun("Test Run");
		
	}
	@Test
	public void insertRunMgmtTest() {
		
		int runId= runMgmtDaoImpl.insertRunMgmt("Test Run");
		
	}
	@Test
	public void initiateCurrentRunTest() {
		
		int runId= runMgmtDaoImpl.initiateCurrentRun("Test Run");
		
	}
}
