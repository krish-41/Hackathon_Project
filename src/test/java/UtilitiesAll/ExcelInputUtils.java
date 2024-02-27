package UtilitiesAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelInputUtils {

private static String path;
public static FileInputStream fi;
public static XSSFWorkbook workbook;
public static XSSFSheet sheet;
public XSSFRow row;
	
//constructor for path
public ExcelInputUtils(String path) {
	// TODO Auto-generated constructor stub
	this.path=path;
}

//To get total row no.
public int getRowCount(String sheetName) throws IOException 
{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetName);
	int rowcount=sheet.getLastRowNum();
	workbook.close();
	fi.close();
	return rowcount;		
}

//To get total column no.
public int getCellCount(String sheetName,int rownum) throws IOException
{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetName);
	row=sheet.getRow(rownum);
	int cellcount=row.getLastCellNum();
	workbook.close();
	fi.close();
	return cellcount;
}



// Test case 1 for random city and speciality
   public static String[] City() throws IOException{
	String[] Mydata2=new String[5];
	FileInputStream filepath =new FileInputStream(".//ProjectInputData//HackathonProjectData.xlsx");
	workbook=new XSSFWorkbook(filepath);
	sheet= workbook.getSheet("city And Speciality");
	
	int j =new Random().nextInt(1,5);
	int i =new Random().nextInt(1,5);
	String city_name=sheet.getRow(j).getCell(0).toString();
	String speciality=sheet.getRow(i).getCell(1).toString();
	Mydata2[0]=city_name;
	Mydata2[1]=speciality;
	filepath.close();
	workbook.close();
	return Mydata2;
}

// Test case 3 For Invalid data
	public static List<String> InvalidData() throws IOException{
		 List<String>Mydata=new ArrayList<String>();
		FileInputStream filepath =new FileInputStream(".//ProjectInputData//HackathonProjectData.xlsx");
		//fi =new FileInputStream(path);
		workbook=new XSSFWorkbook(filepath);
		sheet= workbook.getSheet("InputData");
		for (int i=1;i<=4;i++) {
			String cellData=sheet.getRow(i).getCell(0).toString();
			Mydata.add(cellData);
		}
		filepath.close();
		workbook.close();
		return Mydata;
	}
	
	public static String[] InvalidDataProvider() throws IOException{
		List<String>Mydata3=new ArrayList<String>();
		FileInputStream filepath =new FileInputStream(".//ProjectInputData//HackathonProjectData.xlsx");
		//fi =new FileInputStream(path);
		workbook=new XSSFWorkbook(filepath);
		sheet= workbook.getSheet("InputData");
		for (int i=1;i<=4;i++) {
			String cellData=sheet.getRow(i).getCell(0).toString();
			Mydata3.add(cellData);
		}
		String[] data = new String[Mydata3.size()];
		int ind = 0;
		for(String s : Mydata3) {
			data[ind++] = s;
		}
		filepath.close();
		workbook.close();
		return data;
	}
	
	
	
//  Test Case 3 for valid data
	public static List<String> ValidData() throws IOException{
		List<String>Mydata1=new ArrayList<String>();
		FileInputStream filepath =new FileInputStream(".//ProjectInputData//HackathonProjectData.xlsx");
		//fi =new FileInputStream(path);
		workbook=new XSSFWorkbook(filepath);
		sheet= workbook.getSheet("InputData");
		for (int i=1;i<=4;i++) {
			DataFormatter format = new DataFormatter();
			
			String cellData=format.formatCellValue(sheet.getRow(i).getCell(1));
			Mydata1.add(cellData);
		}
		filepath.close();
		workbook.close();
		return Mydata1;
	}
}
