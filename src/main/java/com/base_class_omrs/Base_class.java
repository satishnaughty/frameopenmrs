package com.base_class_omrs;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_class {
	
	       public static WebDriver driver;
	       
	       public static ExtentReports extentreports; // class 
	       
	       public static File file;
		
		
		protected static WebDriver Browerlauch( String browsername) {
			
			try {
				if (browsername.equalsIgnoreCase("chrome")) {
					
					driver = new ChromeDriver();
					
				}else if (browsername.equalsIgnoreCase("edge")) {
					
					driver = new EdgeDriver();
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver.manage().window().maximize();
			return driver;
			
		    }	
		
		// 1. URL LAUCHING
		protected static void urllauch(String urlpassing) {
			
			driver.get(urlpassing);
		 }
		
		// 2. GET URL FROM WEB PAGE
	    protected static void getcurrenturl(WebDriver driver, String printurl ) {
				String printcurrentpageurl = driver.getCurrentUrl();
				System.out.println(printcurrentpageurl);

		 }
	    
		 // 3. SENDKEYS
		 protected static void datapassing(WebDriver driver,WebElement element,String data) {
		  element.sendKeys(data);
		 
		 }
		 
	     // 4. CLICK
	     protected static void clickbtn( WebElement element) {
	    	 element.click();
	     	 
		}
	     // 5. DROP DOWN
	    protected static void dropdown(WebDriver driver, WebElement element, String value, String options, int index) {
	    	Select select = new Select(element);
	    	 if (options.equalsIgnoreCase("value")) {
	    		 select.selectByValue(value);	
			}else if (options.equalsIgnoreCase("index")) {
				 select.selectByIndex(index);	
			}else if (options.equalsIgnoreCase("visibletext")) {
				 select.selectByVisibleText(value);
				
			}
		} 
		  // 6. IMPLICITYWAIT
	    protected static void implicitywait(WebDriver driver,WebElement element) {
	    	
	    	try {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				element.click();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    }
	      // 7. EXPLICITYWAIT
	    protected static void explicitywait(WebDriver driver,int time,WebElement element) {
	    	
	    	try {
				WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(time));
				exwait.until(ExpectedConditions.visibilityOf(element));
				element.click();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	       // 8. ACTIONS DRAG AND DROP
	    protected static void actionsdragdrop(WebDriver driver, WebElement element) {
	    	Actions action = new Actions(driver);
	    	action.dragAndDrop(element, element);
	    	
	    }
	    
	      //  ACTIONS CLICK
	    protected static void actionsclick(WebDriver driver, WebElement element) {
	    	Actions actions = new Actions(driver);
	    	actions.dragAndDrop(element, element);
	    	
	    }
	      // 9. NAvIGATE BACK
	    protected static void navigateback() {
	    	driver.navigate().back();
	    	
	    }
	    
	      // 10. NAvIGATION
	    protected static void navigationmethods(String navigationmetho, String navigationurl) {
	    	
	    	try {
				if (navigationmetho.equalsIgnoreCase("back")) {
					driver.navigate().back();	
				}
				
				if (navigationmetho.equalsIgnoreCase("forward")) {
					driver.navigate().forward();	
				}
				
				if (navigationmetho.equalsIgnoreCase("Refesh")) {
					driver.navigate().refresh();
                } 
			} catch (Exception e) {
				e.printStackTrace();
			}	
	    }	    	
	    	
	    	
	    	
	         public static void extentReportStart(String location) {
	    		 extentreports = new ExtentReports();
	    		 file = new File(location);
	    		 ExtentSparkReporter sparkreporter = new ExtentSparkReporter(file);
	    		 extentreports.attachReporter(sparkreporter);
	    		 extentreports.setSystemInfo("os", System.getProperty("os.name"));
	    		 extentreports.setSystemInfo("java version", System.getProperty("java.version"));
	    		
	    	}
	    	
	    	public static void extentReportsTearDown(String location1) throws IOException {
	    		
	    		extentreports.flush();
	    		file = new File(location1);
	    		Desktop.getDesktop().browse((file).toURI());
	    		
	    	}
	    	

			//takescreenshottakescreenshot
	    	protected static void takescreenshot(WebDriver driver, String element) throws IOException {
	    		TakesScreenshot ts = (TakesScreenshot) driver;
	    		File source = ts.getScreenshotAs(OutputType.FILE);
	    		File fref = new File("C:\\Users\\Naughtx\\eclipse-workspace\\New folder\\ipt.Testing\\target\\screenshot");
	    		org.openqa.selenium.io.FileHandler.copy(source, fref);
	
	    }
	    	
	    	protected String takescreen() throws IOException {
	    		TakesScreenshot ts = (TakesScreenshot) driver;
	    		String timestamp = new SimpleDateFormat("yyyyMMdd_mmss").format(new Date());
	    		File scrfile = ts.getScreenshotAs(OutputType.FILE);
	    		File destfile = new File("screenshot\\.png"+"_"+ timestamp+".png");
	    		FileUtils.copyFile(scrfile, destfile);
	    		return destfile.getAbsolutePath();
	    			
	    			
	    			
	    		
	    	}
	    	
	    	
	    	// isdisplayed
	    	protected static void diplayed(String xpath) {
	    		try {
					WebElement buttonName = driver.findElement(By.xpath("xpath"));
					boolean displayed = buttonName.isDisplayed();
					System.out.println("Requried Button is displayed");
				} catch (Exception e) {
					System.out.println("Requried Button is displayed");
				}
	    		
			}
	    	// isEnabled
	    	protected static void isEnabled(String xpath) {
	    		try {
					WebElement buttonName = driver.findElement(By.xpath("xp"));
					boolean enabled = buttonName.isEnabled();
				} catch (Exception e) {
					System.out.println("Requried Button is enabled");
				}
	    		
	    	}
	    	// isSelected
	    	protected static void isselected(String xpath) {
	    		
	    		try {
					WebElement buttonName = driver.findElement(By.xpath("xpath"));
					boolean selected = buttonName.isSelected();
				} catch (Exception e) {
					System.out.println("Requried Button is isSelected");
				}
	    	}
	    	protected static void gettitle(WebDriver driver) {
	    		String title = driver.getTitle();
	    		System.out.println(title);
	    	}
	    	
	    	protected static void Actions(WebElement element, String type, String Value) {
	    		Actions action = new Actions(driver);
	    		
	    		if(type.equalsIgnoreCase("contextclick")) {
	    			action.contextClick(element).build().perform();
	    			
	    		} else if(type.equalsIgnoreCase("doubleclick")) {
	    		    action.doubleClick(element).build().perform();
	    		
	    	    } else if(type.equalsIgnoreCase("draganddrop")) {
	    	    	action.dragAndDrop(element, element).build().perform();
	    	    	
	    	    } else if(type.equalsIgnoreCase("draganddropbyXY")) {
	    	    	int int1 = Integer.parseInt(Value);
	    	    	action.dragAndDropBy(element, int1, int1).build().perform();
	    	    	
	    	    } else if(type.equalsIgnoreCase("clickandhold")) {
	    	    	action.clickAndHold(element).build().perform();
	    	    }
	   }	
	    	 protected static void Keyboard(String type) throws AWTException {
	    		 Robot rob =  new Robot();
	    		 
	    		 if(type.equalsIgnoreCase("enterkey")) {
	    			 rob.keyPress(KeyEvent.VK_ENTER);
	    			 
	          }  else if(type.equalsIgnoreCase("pressdownkey")) {
	        	  rob.keyPress(KeyEvent.VK_DOWN);
	        	  
	          }  else if(type.equalsIgnoreCase("preekeyup")) {
	        	  rob.keyPress(KeyEvent.VK_UP);
	        	  
	          }  else if (type.equalsIgnoreCase("releaseenterkey")) {
	        	  rob.keyRelease(KeyEvent.VK_ENTER);
				
			  }  else if(type.equalsIgnoreCase("relasekeydown")) {
	    		  rob.keyRelease(KeyEvent.VK_DOWN);
				
			  }  else if (type.equalsIgnoreCase("releasekeyup")) {
				  rob.keyRelease(KeyEvent.VK_UP);
			  }
	    	 }
	    	  
	    	 protected void Validation(WebDriver actual, String expected) {
				Assert.assertEquals(actual.getTitle(),expected);

			}
	    	 
	    	 protected static void close(WebDriver driver) {
	    		 driver.close();
	    		 
	    	 }
	    	 
	    	 protected static void qiutbrowser() {
	    		 driver.quit();
	    	 }
	} 




	
	
	
	
	


