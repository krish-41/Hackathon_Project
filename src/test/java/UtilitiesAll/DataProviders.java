package UtilitiesAll;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
@DataProvider(name="invalid_data_provider")
	public static String[][] dataproviderValid() throws IOException{
	String path=".//ProjectInputData//HackathonProjectData.xlsx";
	ExcelInputUtils EXI=new ExcelInputUtils(path);
	int rowno=EXI.getRowCount("InputData");
	int columnno=EXI.getCellCount("InputData",0);
	String[][]DataProvider_data=new String[1][columnno];	
		
			DataProvider_data[0] = EXI.InvalidDataProvider();  //1,0

	return DataProvider_data;
	
	}
}
