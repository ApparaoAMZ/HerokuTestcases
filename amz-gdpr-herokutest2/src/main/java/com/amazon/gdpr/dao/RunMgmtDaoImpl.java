package com.amazon.gdpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amazon.gdpr.model.gdpr.output.RunMgmt;
import com.amazon.gdpr.util.GlobalConstants;
import com.amazon.gdpr.util.SqlQueriesConstant;

/****************************************************************************************
 * The DAOImpl file fetches the JDBCTemplate created in the DatabaseConfig and 
 * Connects with the schema to fetch the RunMgmt table rows 
 ****************************************************************************************/
@Transactional
@Repository
public class RunMgmtDaoImpl {
	
	private static String CURRENT_CLASS		 		= GlobalConstants.CLS_RUNMGMTDAOIMPL;
	private static String RUNMGMT_LAST_RUN 			= SqlQueriesConstant.RUNMGMT_LAST_RUN;
	private static String RUNMGMT_INSERT_QRY		= SqlQueriesConstant.RUNMGMT_INSERT_QRY;
	private static String RUNMGMT_INSERT_RUN		= SqlQueriesConstant.RUNMGMT_INSERT_RUN;		
	
	@Autowired
	@Qualifier("gdprJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	 
	/**
	 * Fetches the last run detail from the RunMgmt table
	 * @return RunMgmt 
	 */
	public RunMgmt fetchLastRunDetail(){
		String CURRENT_METHOD = "fetchLastRunDetail";		
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+":: Inside method");
		
		RunMgmt runMgmt = null;		
		@SuppressWarnings("unchecked")
		List<RunMgmt> lstLastRunMgmt = jdbcTemplate.query(RUNMGMT_LAST_RUN, new RunMgmtRowMapper());		
		if(lstLastRunMgmt != null && lstLastRunMgmt.size() > 0){
			runMgmt = lstLastRunMgmt.get(0);			
		}
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+" :: Fetch Last Run Detail : "+runMgmt.getRunId());
		return runMgmt;
	}
	
	public void initiateNewRun(String runName) {
		String CURRENT_METHOD = "initiateNewRun";		
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+":: Inside method");
		
		jdbcTemplate.update(RUNMGMT_INSERT_RUN, new Object[]{runName, GlobalConstants.STATUS_INPROGRESS});	
		
	}
	
	public int insertRunMgmt(String runName) {
		String CURRENT_METHOD = "insertRunMgmt";		
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+":: Inside method");
		int runId = 0;
		
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(RUNMGMT_INSERT_RUN, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1,runName);
		    	ps.setString(2,GlobalConstants.STATUS_INPROGRESS);
				return ps;
			}
		}, holder);
		runId = holder.getKey().intValue();
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+" :: New Run Initiated : Run ID " +runId);
		return runId;
	}

	public int initiateCurrentRun(String runName) {
		String CURRENT_METHOD = "initiateCurrentRun";		
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+":: Inside method");
		int runId = 0;
				
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(conn -> {
			PreparedStatement ps = conn.prepareStatement(RUNMGMT_INSERT_QRY, new String[] {"RUN_ID"});
			ps.setString(1,runName);
		    ps.setString(2,GlobalConstants.STATUS_INPROGRESS);
		    return ps;
		}, holder);
		    
		runId = holder.getKey().intValue();
		return runId;		
	}
	
	/****************************************************************************************
	 * This rowMapper converts the row data from RunMgmt table to RunMgmt Object 
	 ****************************************************************************************/
	@SuppressWarnings("rawtypes")
	class RunMgmtRowMapper implements RowMapper{		
		private String CURRENT_CLASS		 		= GlobalConstants.CLS_RUNMGMTROWMAPPER;
		
		/* 
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		@Override
		public RunMgmt mapRow(ResultSet rs, int rowNum) throws SQLException {
			String CURRENT_METHOD = "mapRow";		
			System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+":: Inside method");
			
			RunMgmt runMgmt = new RunMgmt(rs.getInt("RUN_ID"), rs.getString("RUN_STATUS"));
			return runMgmt;
		}
	}
		
}