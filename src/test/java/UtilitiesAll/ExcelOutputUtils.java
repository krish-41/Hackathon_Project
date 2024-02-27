package UtilitiesAll;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import PageObjectClass.HomePage;
import PageObjectClass.SurgeryPage;

public class ExcelOutputUtils {
	public static void ExcelOutputData() throws IOException 
	{
	 LinkedHashMap<String,String>Doc_data=HomePage.DocName;
	 FileOutputStream filepath =new FileOutputStream(".//FileOutputData//Fileoutput.xlsx");
     XSSFWorkbook workbook=new XSSFWorkbook();
     XSSFSheet sheet1=workbook.createSheet("Doctors_Description");
     XSSFRow row=sheet1.createRow(0);
     row.createCell(0).setCellValue("Doctor Name");
     row.createCell(1).setCellValue("Doctor Description");
     int row1=1;
     for(Entry<String,String>allentry:Doc_data.entrySet())
     {
    	 XSSFRow Row =sheet1.createRow(row1++); 
         Row.createCell(0).setCellValue(allentry.getKey()); 
         Row.createCell(1).setCellValue(allentry.getValue()); 
     }
     
     workbook.write(filepath);
     filepath.close();
     workbook.close();
     
	}
	
	public static void ExcelOutputData1() throws IOException 
	{
	 List<String>SurgeryData=SurgeryPage.Allsurgeries;
	 FileOutputStream filepath =new FileOutputStream(".//FileOutputData//Fileoutput1.xlsx");
     XSSFWorkbook workbook=new XSSFWorkbook();
     XSSFSheet sheet1=workbook.createSheet("All surgeries list");
     XSSFRow row=sheet1.createRow(0);
     row.createCell(0).setCellValue("List of All Surgeries Available");
     for(int i=0;i<SurgeryData.size();i++)
     {
    	 sheet1.createRow(i+1).createCell(0).setCellValue(SurgeryData.get(i));
     }
     
     workbook.write(filepath);
     filepath.close();
     workbook.close();
     
	}
}
