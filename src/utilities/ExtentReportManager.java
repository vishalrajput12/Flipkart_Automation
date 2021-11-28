package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {
	
	public static ExtentReports report;
	
	public static ExtentReports getReportInstance() {
		
		if(report == null) {
			
			String reportName = DateUtils.getTimeStamp() + ".html";
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\" + reportName);
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
			
			report.setSystemInfo("OS", "Windows");
			
			htmlReporter.config().setReportName("Flipkart : Category : Bluetooth Headphones");
			htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		}
		
		return report;
	}

}
