package com.amazon.gdpr.util;

/****************************************************************************************
 * This Class contains all the Queries that is required through out the project 
 ****************************************************************************************/
public class SqlQueriesConstant {
	
	public static String RUNMGMT_LAST_RUN 	= "SELECT RUN_ID, RUN_STATUS FROM GDPR.RUNMGMT ORDER BY RUN_ID DESC LIMIT 1";
	public static String RUNMGMT_INSERT_RUN = "INSERT INTO GDPR.RUNMGMT(RUN_ID, RUN_NAME, RUN_STATUS, RUN_START_DATE_TIME) VALUES("
			+ "(SELECT RUN_ID+1 FROM GDPR.RUNMGMT ORDER BY RUN_ID DESC LIMIT 1), ?, ?, CURRENT_TIMESTAMP)";
	
	public static String RUNMGMT_INSERT_QRY	= "INSERT INTO GDPR.RUNMGMT(RUN_NAME, RUN_STATUS) "
								+ "VALUES(?, ?) ON DUPLICATE KEY UPDATE RUN_NAME=VALUES(RUN_NAME), "
								+ "RUN_ID=LAST_INSERT_ID(RUN_ID)";
}
