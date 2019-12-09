package Com.E2M.GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
 
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
 

public class fileutil {
 		
		 String filepath="./Data/commondata.properties";
		 String excelpath="./Data/testdata.xlsx";
		 
		 public Properties getpropertiesfileobject() throws IOException
		 {
			 FileInputStream fis=new FileInputStream(filepath);
			 Properties pobj=new Properties();
			 pobj.load(fis);
			 
			 return pobj;
			 
		 }
		 
public String getexcelData(String sheetname,int rownum,int celnum) throws Throwable   
{
	FileInputStream fis=new FileInputStream(excelpath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetname);
	String data=sh.getRow(rownum).getCell(celnum).getStringCellValue();
	wb.close();
	
	return data;
	
}
 
}

	

 
