package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class MyTestNGListener extends BaseTest implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
		
		test.log(Status.INFO, result.getMethod().getMethodName()+"  is started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.addScreenCaptureFromPath(UtilKit.getScreenshot());
		test.log(Status.PASS, result.getMethod().getMethodName()+"  is Passed");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
//		test.addScreenCaptureFromPath(UtilKit.getScreenShot());
//		test.log(Status.FAIL, result.getMethod().getMethodName()+"  is failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	
	

}
