package utils;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseTest;

public class ExtentManager extends BaseTest {
	
	
	public static ExtentReports getReports() {
		
		
		String reportsFolderPath= (System.getProperty("user.dir")+"\\reports");
		
		if(reports==null) {
			
			reports=new ExtentReports();
			
			String pattern="yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf= new SimpleDateFormat(pattern);
			
			String date=sdf.format(new Date());
			
			date=date.replace(":", "-");
			
			System.out.println(date);
			
			File reportsFile=new File(reportsFolderPath+"\\"+date+".html");
			
			ExtentSparkReporter reporter= new ExtentSparkReporter(reportsFile);
			
			reporter.config().setDocumentTitle("Adactin QA Regression Results");
			
			reporter.config().setReportName("Regression Reports");
			
//			
			reports.attachReporter(reporter);			
			
					
			
			
			
			
		}
		
		return reports;
		
	}

}
