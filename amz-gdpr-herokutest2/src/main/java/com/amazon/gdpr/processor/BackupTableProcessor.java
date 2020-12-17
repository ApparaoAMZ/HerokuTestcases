package com.amazon.gdpr.processor;

import java.util.List;

import com.amazon.gdpr.model.gdpr.input.AnonymizeDetails;

public class BackupTableProcessor {
	
	public Boolean processBkpupTable(int runId, List<AnonymizeDetails> activeAnonymizeDtlsList){
		Boolean bkpupTblProcessStatus = false;
		
		if(refreshBackupTables()){
			bkpupTblProcessStatus = bkpupTableCheck(activeAnonymizeDtlsList);			
		}
		if(! bkpupTblProcessStatus){
			//load ModuleMgmt
			//load ErrorMgmt
		}
		return bkpupTblProcessStatus;
	}
	
	/*
	 * Refresh Backup Tables
	 */
	public Boolean refreshBackupTables(){
		Boolean refreshBkpupTableStatus = false;
		//Fetch the Backup Table name from ImpactTable and truncate the tables
		return refreshBkpupTableStatus;
	}
	
	public Boolean bkpupTableCheck(List<AnonymizeDetails> activeAnonymizeDtlsList){
		Boolean bkpupTableCheckStatus = false;
		//Fetch the Backup Table name from ImpactTable and truncate the tables
		return bkpupTableCheckStatus;
	}	
	
}