package com.W2Stesting.APItestingframework.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		
		Properties config=new Properties();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\com\\properties\\Config.properties");
		config.load(fis);
		System.out.println(config.getProperty("baseURI"));
	}

}
