package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
public String readDataFromPropertyFile(String key) throws IOException {
	FileInputStream fis=new FileInputStream(FrameWorkConstant.propertyFilePath);
	Properties  pro=new Properties();
	pro.load(fis);
	String value=pro.getProperty(key);
	return value;
}
public String readDataFromExcelFile(String sheetName, int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(FrameWorkConstant.excelFilePath);
	Workbook workbook=WorkbookFactory.create(fis);
	String value=workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	return value;
}
}
