package com.amazon.gdpr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazon.gdpr.controller.GdprController;
import com.amazon.gdpr.util.GlobalConstants;

/****************************************************************************************
 * This is the Spring Boot Servlet Initializer class for GDPR Application web
 * This will be initiated during application deployment in Heroku
 ****************************************************************************************/
@SpringBootApplication
public class GdprCmdLineApplication {// implements CommandLineRunner {
	
	private static String CURRENT_CLASS		 		= GlobalConstants.CLS_GDPRCMDLINEAPPLICATION;
	
	@Autowired
	GdprController gdprController;
	
	
	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	/*@Override
	public void run(String... args) {
		String CURRENT_METHOD = "run";
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+":: Inside method");
		
		gdprController.herokuDepersonalization("Test Run");
	}*/
	
	public void gdprCmdLineInitiate() {
		gdprController.herokuDepersonalization("Test Run");
	}
	
	/**
	 * This is the class initiated during command line runtime
	 * @param args
	 */
	public static void main(String[] args) {
		String CURRENT_METHOD = "main";		
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+":: Inside method");
		SpringApplication.run(GdprCmdLineApplication.class, args);
		new GdprCmdLineApplication().gdprCmdLineInitiate();
	}
}
