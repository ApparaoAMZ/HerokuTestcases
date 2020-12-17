package com.amazon.gdpr.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazon.gdpr.dao.RunMgmtDaoImpl;
import com.amazon.gdpr.model.gdpr.output.RunMgmt;
import com.amazon.gdpr.model.gdpr.output.RunModuleMgmt;
import com.amazon.gdpr.util.GlobalConstants;

/****************************************************************************************
 * This processor verifies the previous failure run / initiates a current run 
 * Any processing or updates related to the RunMgmt tables are performed here
 ****************************************************************************************/
@Component
public class RunMgmtProcessor {
		
	private static String CURRENT_CLASS		 		= GlobalConstants.CLS_RUNMGMTPROCESSOR;
	private static String STATUS_FAILURE			= GlobalConstants.STATUS_FAILURE;
	//private Boolean errorStatus = false;
	//private String erroMessage = null;
	
	@Autowired
	RunMgmtDaoImpl runMgmtDaoImpl;
	
	/**
	 * This method handled the initialization of the current run
	 * Takes a call whether the old failure run has to be proceeded on or a new run should be instantiated	 
	 * @param runName The description of the current run is being maintained
	 * @return The RunId is returned back to controller and this is passed on to all methods 
	 */
	public int initializeRun(String runName) {
		String CURRENT_METHOD = "initializeRun";		
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+" :: Inside method");
		
		//Fetch lastRunId if failed
		RunModuleMgmt module = oldRunVerification();
		int runId = 0;
		if(module == null)			
			runId = initiateNewRun(runName);
		return runId;
	}		
	
	/**
	 * The last failure run is fetched and verified if it needs to be proceeded on 
	 * @return Returns the last Failure entry of the RunModuleMgmt
	 */
	public RunModuleMgmt oldRunVerification() {
		String CURRENT_METHOD = "oldRunVerification";		
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+" :: Inside method");
				
		RunMgmt runMgmt = runMgmtDaoImpl.fetchLastRunDetail();
		if(runMgmt != null && STATUS_FAILURE.equalsIgnoreCase(runMgmt.getRunStatus()) ){
			System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+" :: Past Failure RunID : "+runMgmt.getRunId());
		}else {
			System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+" :: No past failure run available. ");
			return null;
		}
		return null;
	}
		
	/**
	 * A new run is initiated in this method. An entry is made in the RunMgmt table for this run
	 * @param runName The description of the current run is being maintained
	 * @return The RunId is returned back to controller and this is passed on to all methods
	 */
	public int initiateNewRun(String runName) {
		String CURRENT_METHOD = "initiateNewRun";		
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+" :: New run initiation in progress.");
		
		runMgmtDaoImpl.initiateNewRun(runName);
		return runMgmtDaoImpl.fetchLastRunDetail().getRunId();		
	}
}