package com.ecommerce.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ecommerce.pageObjects.DatepickerPage;
import com.github.dockerjava.api.model.Driver;

public class TC_DatePickerTest_002 extends BaseClass{
	
	String year = "2023";
	String month = "JAN";
	boolean dateFound = true;
	String selectedYear, selectedMonth, selectedDate;
	
	@Test(enabled = true, priority=1, alwaysRun = true)
	public void DataPickerTest() throws InterruptedException {
		
//		DatepickerPage datePickerPage = new DatepickerPage(driver);
//		datePickerPage.openDatePicker();
//		
//		while(datePickerPage.canGoToNextMonthAndYear()) {
//			
//			Thread.sleep(500);
//			
//			selectedYear = datePickerPage.getNextYear();
//			selectedMonth = datePickerPage.getNextMonth();
//			
//			System.out.println("Year --------- " + selectedYear + "Month --------- " + selectedMonth);
//			
//
//			if(selectedYear.equals(year) && selectedMonth.equals(month)) {
//				System.out.println("Month is --------------- " + selectedMonth);
//				
//				for(WebElement date: datePickerPage.getDates()) {
//					
//					if(date.getText().equals("15")) {
//						date.click();
//					}
//					
//				}
//				break;
//			}
//			datePickerPage.goToNextMonthAndYear(); 
//			
//		}
	}

}
