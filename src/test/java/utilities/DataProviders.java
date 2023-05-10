package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// Create DataProviders class in utilities package to maintain data providers for data driven tests.
	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";			//taking Excel file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);					//creating an object for ExcelUtility
		
		int totalrows = xlutil.getRowCount("Sheet1");	
		int totalcols = xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];		//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)    //1                        //read the data from Excel & storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    					// i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //logindata[i-1][j] becz this data store in array sheet row start from 1
			}														   // and array is start from 0 if we simple mentioned [i][j] then it consider
		}															   // 1 row of array and 0 row of array is empty means its wastage of memory
																	   // to avoide thta we mentioned i-1 menas its start to store data from 0 of array
		return logindata; 			//returning two dimension array
				
	}

	// We can add more Data provider as per requirement in project
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
}
