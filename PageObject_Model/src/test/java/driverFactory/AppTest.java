package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.CustomerPage;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil
{
String inputpath = "./FileInput/CustomerData.xlsx";
String outputpath ="./FileOutput/CustomerResults.xlsx";
ExtentReports report;
ExtentTest logger;
@Test
public void starttest() throws Throwable
{
report = new ExtentReports("./target/Reports/Customers.html");
CustomerPage cus = PageFactory.initElements(driver, CustomerPage.class);
ExcelFileUtil xl = new ExcelFileUtil(inputpath);
int rc = xl.rowcount("Customer");
Reporter.log("no of rows::"+rc,true);
for(int i=1;i<=rc;i++)
{
	logger = report.startTest("Customer");
	logger.assignAuthor("prashanth");
	String customername = xl.getcelldata("Customer", i, 0);
	String address = xl.getcelldata("Customer", i, 1);
	String city = xl.getcelldata("Customer", i, 2);
	String country = xl.getcelldata("Customer", i, 3);
	String contactperson = xl.getcelldata("Customer", i, 4);
	String phonenumber = xl.getcelldata("Customer", i, 5);
	String email = xl.getcelldata("Customer", i, 6);
	String mobilenumber = xl.getcelldata("Customer", i, 7);
	String notes = xl.getcelldata("Customer", i, 8);
	logger.log(LogStatus.INFO, customername+"  "+address+" "+city+" "+country+" "+contactperson+" "+phonenumber+" "+email+" "+mobilenumber+" "+notes);
boolean res = cus.add_customer(customername, address, city, country, contactperson, phonenumber, email, mobilenumber, notes);
 if(res)
 {
	 xl.setcelldata("Customer", i, 9, "pass", outputpath);
	 logger.log(LogStatus.PASS, "customer add sucess");
	 }
 else
 {
	 xl.setcelldata("Customer", i, 9, "fail", outputpath);
	 logger.log(LogStatus.FAIL, "customer add sucess"); 
 }
 report.endTest(logger);
 report.flush();
}
}
}
