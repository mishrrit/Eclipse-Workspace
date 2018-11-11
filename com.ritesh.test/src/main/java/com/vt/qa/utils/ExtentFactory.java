package com.vt.qa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.relevantcodes.extentreports.ExtentReports;


public class ExtentFactory {
	
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String timestamp = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		String Logfile = "logfile"+timestamp+".html";
		String directory = "C:\\Users\\mishrrit\\eclipse-workspace\\com.ritesh.test\\ExtentReport\\"+Logfile;
		extent = new ExtentReports(directory, true);
		extent.addSystemInfo("Selenium Version","3.14");
		extent.addSystemInfo("OS Version", "Win");
		extent.addSystemInfo("Author","Ritesh");
		return extent;
						
	}

}
