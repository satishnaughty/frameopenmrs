package com.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class configreader {

      FileInputStream fis;
       
	public Properties configfile() {
		
		File f = new File("C:\\Users\\Naughtx\\eclipse-workspace\\New folder\\Frameomrs\\src\\main\\java\\com\\properties\\Data.properties");
		
		try {
			 fis = new FileInputStream(f);
			
		} catch (FileNotFoundException e) {
		
		}
		
		Properties p = new Properties();
		
		try {
			
			p.load(fis);
			
		} catch (IOException e) {
			
		}
		
		return p;
		
	}
	
	public String getbrowser() {
		String browser = configfile().getProperty("brower");
		return browser;
		
	}
	
	
	 public String geturl() {
		 String url = configfile().getProperty("url");
		 return url;
		
		
	}
	
	 public String getusername() {
		 String username = configfile().getProperty("username");
		 
		return username;
		  
	 }
	 
	 public String getpassword() {
		 String password = configfile().getProperty("password");
		 
		 return password;
		 
	 }
	 
	 public String  gettitle() {
		 String tittle = configfile().getProperty("title");
		 
		return tittle;
		 	 
	 }
	 
	 
	 
}
