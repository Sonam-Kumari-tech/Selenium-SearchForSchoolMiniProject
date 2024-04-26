package search;

import java.io.IOException;

import excelUtils.ExcelUtils;


public class SearchForSchool extends SearchFunctions{

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		SearchForSchool auto=new SearchForSchool(); //Creating an object "auto" for automation
		auto.setUp();                                 //Driver Setup
		String[] data=ExcelUtils.readData();          //Reading excel
		auto.selectSchool();                         //Selecting School
		auto.selectCourseType(data[0]);                   //Select "CBSE"
		auto.selectCity(data[1]);                     //Select "Pune"
		auto.searchButton();                          //Clicking Search Button
		auto.writeData();                             //Writing the school list
		auto.getScreenShot();
		auto.closeBrowser();                          //Closing the Browser

		
		

	}

}
