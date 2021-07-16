package com.w2a.APITestingFramework.utilities;

import org.testng.annotations.DataProvider;

import com.W2Atesting.APItestingframework.SetUp.BaseTest;

public class DataUtilitiesForProject extends BaseTest {
	
	@DataProvider(name="getData")
	public Object[] getData() {
		
		String sheetName= "validateCreateCustomerApi";
		
		int rows= excel.getRowCount(sheetName);
		int cols= excel.getColumnCount(sheetName);
		
		System.out.println("Rows are" +rows);//r-2
		System.out.println("Cols are" +cols);//col-3
		
		Object[][]data = new Object[rows-1][cols];
		excel.getCellData(sheetName, cols, rows);
		
		for(int rowNum=2; rowNum<=rows;rowNum++) {
			
			for(int colNum=0;colNum<cols;colNum++) {
				data[rowNum-2][colNum] =excel.getCellData(sheetName, colNum, rowNum);
				
			}
		}
		
		return data;
		
	}

}
