package com.W2Atesting.APItestingframework.SetUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.http.protocol.HttpService;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.w2a.APITestingFramework.utilities.ExcelReader;

import io.restassured.RestAssured;

public class BaseTest {
	
	
	private static final String SSLSecurityProtocol = null;
	public Properties config=new Properties();
	private FileInputStream fis;
	public static ExcelReader excel = new ExcelReader("C:\\Users\\debas\\RestAssuredFramework\\Excel\\TestData.xlsx");
	
	@BeforeTest
	public void setUp() {
		
		
		
		 try {
			fis=new FileInputStream(".\\src\\test\\resources\\com\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RestAssured.baseURI=config.getProperty("baseURI");
		RestAssured.basePath=config.getProperty("basePath");
		
		
	}
	@AfterSuite
	public void tearDown() {
		
	}

}
