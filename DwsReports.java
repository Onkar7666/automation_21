package Listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DwsReports implements ITestListener {

	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		
		String name = result.getMethod().getMethodName();
		test = report.createTest(name);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.PASS, "onTestSuccess");
		test.log(Status.PASS,name+"is Success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.INFO, "onThe failure");
		test.log(Status.FAIL,name+"is failure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		String name = result.getMethod().getMethodName();
		test.log(Status.INFO, "onTheskippes");
		test.log(Status.SKIP,name+"is Skip");
	}


	@Override
	public void onStart(ITestContext context) {
		
		spark = new ExtentSparkReporter(".\\src\\main\\resources\\TestCase2.html");
		spark.config().setDocumentTitle("addidas nike puma");
		spark.config().setReportName("onkar");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.setSystemInfo("os", "linux");
		report.setSystemInfo("browser", "chrome-101");
		
		report.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
	}

	
	
}
