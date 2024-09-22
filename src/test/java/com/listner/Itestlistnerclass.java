package com.listner;

import java.io.IOException;


import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.CustomAttribute;
import org.testng.internal.annotations.ITest;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.base_class_omrs.*;

public class Itestlistnerclass extends Base_class implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		try {
			Extentreport_Test.extenttest.pass(result.getMethod() + ":" + "Test pass", MediaEntityBuilder.createScreenCaptureFromPath(takescreen()).build());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
	   try {
		Extentreport_Test.extenttest.fail(result.getMethod() +":" + "Test fail", MediaEntityBuilder.createScreenCaptureFromPath(takescreen()).build());
	} catch (IOException e) {
		
		e.printStackTrace();
	}	
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	 	
	
	
}
