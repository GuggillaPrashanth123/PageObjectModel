package commonFunctions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage {
@FindBy(xpath = "(//a[contains(text(),'Customers')])[2]")
WebElement ObjCustomerLink;
@FindBy(xpath = "(//span[contains(@data-caption,'Add')])[1]")
WebElement ObjAddIcon;
@FindBy(name = "x_Customer_Number")
WebElement ObjCustomerNum;
@FindBy(name = "x_Customer_Name")
WebElement ObjCustomerName;
@FindBy(name = "x_Address")
WebElement ObjAddress;
@FindBy(name = "x_City")
WebElement ObjCity;
@FindBy(name = "x_Country")
WebElement ObjCountry;
@FindBy(name = "x_Contact_Person")
WebElement ObjContactPerson;
@FindBy(name = "x_Phone_Number")
WebElement ObjPhoneNumber;
@FindBy(name = "x__Email")
WebElement ObjEmail;
@FindBy(name = "x_Mobile_Number")
WebElement ObjMobileNumber;
@FindBy(name = "x_Notes")
WebElement ObjNotes;
@FindBy(xpath = "//button[@id='btnAction']")
WebElement ObjClickAddBtn;
@FindBy(xpath = "//button[normalize-space()='OK!']")
WebElement ObjConfirmOkBtn;
@FindBy(xpath = "(//button[contains(text(),'OK')])[6]")
WebElement ObjAlertOkBtn;
@FindBy(xpath = "//button[@data-caption='Search Panel']")
WebElement ObjSearchPanel;
@FindBy(xpath = "//input[@id='psearch']")
WebElement ObjSearchTextbox;
@FindBy(xpath = "//button[@id='btnsubmit']")
WebElement ObjSearchBtn;
@FindBy(xpath = "//table[@class= 'table ewTable']/tbody/tr[1]/td[5]/div/span/span")
WebElement webtable;
public boolean add_customer(String customername , String address ,String city ,String country,String contactperson,String phonenumber,String email,String mobilenumber,String notes) throws Throwable
{
	ObjCustomerLink.click();
	ObjAddIcon.click();
	String Exp_Num = ObjCustomerNum.getAttribute("value");
	ObjCustomerName.sendKeys(customername);
	ObjAddress.sendKeys(address);
	ObjCity.sendKeys(city);
	ObjCountry.sendKeys(country);
	ObjContactPerson.sendKeys(contactperson);
	ObjPhoneNumber.sendKeys(phonenumber);
	ObjEmail.sendKeys(email);
	ObjMobileNumber.sendKeys(mobilenumber);
	ObjNotes.sendKeys(notes);
	ObjClickAddBtn.sendKeys(Keys.ENTER);
	ObjConfirmOkBtn.click();
	Thread.sleep(2000);
	ObjAlertOkBtn.click();
	Thread.sleep(2000);
	if(!ObjSearchTextbox.isDisplayed())
		ObjSearchPanel.click();
	ObjSearchTextbox.clear();
	ObjSearchTextbox.sendKeys(Exp_Num);
	ObjSearchBtn.click();
	Thread.sleep(2000);
	String Act_Num =webtable.getText();
	Thread.sleep(2000);
	if(Act_Num.equals(Exp_Num))
	{
		Reporter.log("customer number matching::"+Exp_Num+"  "+Act_Num , true);
		return true;
	}
	else
	{
		Reporter.log("customer number not  matching::"+Exp_Num+"  "+Act_Num , true);
		return true;
	}
}

}

















