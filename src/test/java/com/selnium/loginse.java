package com.selnium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class loginse {
	
	static WebDriver driver;
	 
	private void browser() {
		WebDriver driver =   new ChromeDriver();
         driver.get("https://demo.openmrs.org/openmrs/login.htm");
         
     //   login page
         
         driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Admin");
         driver.findElement(By.id("password")).sendKeys("Admin123");
         driver.findElement(By.xpath("//li[@id='Inpatient Ward']")).click();
         driver.findElement(By.xpath("//input[@id='loginButton']")).click();
         
      // Register page
         
         driver.findElement(By.xpath("//a[contains(@id,'referenceapplication-registra')]")).click();
         driver.findElement(By.name("givenName")).sendKeys("satish");
         driver.findElement(By.name("familyName")).sendKeys("s");
         driver.findElement(By.xpath("//span[text()='Gender']")).click();
         driver.findElement(By.xpath("//option[text()='Male']")).click();
         driver.findElement(By.xpath("//span[text()='Birthdate']")).click();
         driver.findElement(By.xpath("//input[@name='birthdateDay']")).sendKeys("14");
         WebElement month = driver.findElement(By.xpath("//select[@id='birthdateMonth-field']"));
         Select select = new Select(month);
         select.selectByIndex(8);
         driver.findElement(By.name("birthdateYear")).sendKeys("2001");
         driver.findElement(By.xpath("//span[text()='Address']")).click();
         driver.findElement(By.id("address1")).sendKeys("No.10 greens tech");
         driver.findElement(By.id("address2")).sendKeys("Vadapalani");
         driver.findElement(By.id("cityVillage")).sendKeys("chennai");
         driver.findElement(By.id("stateProvince")).sendKeys("Tamil nadu");
         driver.findElement(By.id("country")).sendKeys("india");
         driver.findElement(By.id("postalCode")).sendKeys("600099");	
         driver.findElement(By.xpath("//span[text()='Phone Number']")).click();
         driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9884982133");
         driver.findElement(By.xpath("//span[text()='Relatives']")).click();
         WebElement relatives = driver.findElement(By.xpath("//select[@id=\"relationship_type\"]"));
         Select select1 = new Select(relatives);
         select1.selectByIndex(8);
         driver.findElement(By.xpath("//input[contains(@class,'person-typeahead')]")).sendKeys("vicky");
         driver.findElement(By.xpath("//span[@id='confirmation_label']")).click();
         driver.findElement(By.xpath("//input[@id='submit']")).click();
           
            
	}
  

   
   public static void main(String[] args) {
	loginse lp = new loginse();
	       lp.browser();
	      
	
}
   
   
}
