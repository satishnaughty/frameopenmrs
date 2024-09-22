package com.runneropenmrs;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.util.Assert;
import com.listner.Extentreport_Test;
import com.listner.Itestlistnerclass;




@Listeners(Itestlistnerclass.class)
public class runner extends com.base_class_omrs.Base_class {
	
	
	
	
	
	@BeforeTest
	public static void setup() {
		
		Browerlauch(com.properties.frm.getIsntancefrm().getInstanceconfigurationreader().getbrowser());
		Extentreport_Test.extenttest = extentreports.createTest("login" +" : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("login sucessfully");
		com.pom_openmrs.openmrsloginpagee mrs = new com.pom_openmrs.openmrsloginpagee();
		org.testng.Assert.assertTrue(mrs.vaildlogin(Extentreport_Test.extenttest));
	}
	
	@Test
	public static void loginpage() {
		Extentreport_Test.extenttest = extentreports.createTest("login" +" : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("login sucessfully");
		com.pom_openmrs.openmrsloginpagee mrs = new com.pom_openmrs.openmrsloginpagee();
		org.testng.Assert.assertTrue(mrs.vaildlogin(Extentreport_Test.extenttest));
	}
	@BeforeSuite
	public void extendstatup() {
		extentReportStart("C:\\Users\\Naughtx\\eclipse-workspace\\New folder\\Frameomrs\\Report");
	}
	@AfterSuite
    private void extentendup() throws IOException {
       extentReportsTearDown("C:\\Users\\Naughtx\\eclipse-workspace\\New folder\\Frameomrs\\Report\\index.html");
	}	

}
