package Common_Methods;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public  class Extent_report {
	
	public static ExtentReports getReport() 
	{
		String path=System.getProperty("user.dir")+"//reports//latestreport.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Amazon automation Test");
		reporter.config().setDocumentTitle("Amazon Test Results");
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Ayaz Ahmad");
		
		return extent;
		
		
		
		
		
		
		
	}

}
