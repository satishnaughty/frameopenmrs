package com.pom_openmrs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class openmrsloginpagee extends com.base_class_omrs.Base_class implements openmrsloginpageinterface{
	
	     static WebDriver driver;
	
	@FindBy (xpath = "username_id")
	  private WebElement username;
	  
	@FindBy (id = "password")
	 private WebElement password;
	
	@FindBy (xpath = "inptientward")
	private WebElement clickpatient;
	
	@FindBy(xpath = "log_in")
	private WebElement loginbtn;
	
	
	public openmrsloginpagee () {
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean vaildlogin(ExtentTest extentTest) {
		
		try {
			urllauch(com.properties.frm.getIsntancefrm().getInstanceconfigurationreader().geturl());
			datapassing(driver,username,com.properties.frm.getIsntancefrm().getInstanceconfigurationreader().getusername());
			datapassing(driver,password, com.properties.frm.getIsntancefrm().getInstanceconfigurationreader().getpassword());
			clickbtn(clickpatient);
			clickbtn(loginbtn);
			extentTest.log(Status.PASS, "fail");
						
			
		} catch (AssertionError e) {
			
			extentTest.log(Status.FAIL, "login failed");
			return false;
		}
		
		return true;
		
		
	}
	
	

	
	
	

}
