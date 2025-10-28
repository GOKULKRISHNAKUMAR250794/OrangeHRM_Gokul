package generic_utility;

public interface FrameWorkConstant {
	JavaUtility javautility=new JavaUtility();
String excelFilePath="./src/test/resources/TestData/AddEmployee.xlsx";
String propertyFilePath="./src/test/resources/TestData/orangeHRMData.properties";
String screenshotPath="./screenshots/"+javautility.getLocalDate()+".png";
String reportsPath="./reports/"+javautility.getLocalDateTime()+".html";
}
