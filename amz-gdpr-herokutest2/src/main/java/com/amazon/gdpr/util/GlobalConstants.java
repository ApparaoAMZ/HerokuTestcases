package com.amazon.gdpr.util;

/****************************************************************************************
 * This Class contains all the constants that is required through out the project 
 ****************************************************************************************/
public class GlobalConstants {

	//Status
	public static String STATUS_INPROGRESS 		= "Inprogress";
	public static String STATUS_SUCCESS 		= "Success";	
	public static String STATUS_FAILURE 		= "Failure";
	
	// Modules 
	public static String MODULE_INITIALIZATION 		= "Initialization Module";
	public static String MODULE_DATABACKUP 			= "DataBackup Module";
	public static String MODULE_DEPERSONALIZATION 	= "Depersonalization Module";	
	public static String MODULE_DATAREFRESH 		= "DataRefresh Module";		
	
	//Exception Categories
	public static String EXCEPTION_GENERAL 		= "General Exception";
	public static String EXCEPTION_SQLEXCEPTION = "SQL Exception";
	public static String EXCEPTION_URIEXCEPTION = "URI Exception";
	
	public static String EMPTY_STRING 	= "";
	
	public static String CLS_GDPRAPPLICATION		= "GDPRApplication";
	public static String CLS_GDPRCMDLINEAPPLICATION = "GdprCmdLineApplication";
	public static String CLS_GDPRCONTROLLER 		= "GdprController";
	public static String CLS_RUNMGMTPROCESSOR 		= "RunMgmtProcessor";
	public static String CLS_DATABASECONFIG			= "DatabaseConfig";
	public static String CLS_RUNMGMTDAOIMPL			= "RunMgmtDaoImpl";
	public static String CLS_RUNMGMTROWMAPPER		= "RunMgmtRowMapper";
	
	public static String COL_RUN_ID					= "RUN_ID";	
	
	public static String DATE_FORMAT 			= "yyyy-MM-dd_HH:mm:ss";
}