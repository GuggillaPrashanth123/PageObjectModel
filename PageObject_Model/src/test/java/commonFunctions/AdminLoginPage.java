package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
	@FindBy(xpath = "//button[@id='btnreset']")
	WebElement ObjResetBtn;
	@FindBy(name = "username")
	WebElement ObjUser;
	@FindBy(name = "password")
	WebElement ObjPass;
	@FindBy(xpath = "//button[@id='btnsubmit']")
	WebElement ObjLoginBtn;
	public void adminLogin(String user, String pass)
	{
	ObjResetBtn.click();
	ObjUser.sendKeys(user);
	ObjPass.sendKeys(pass);
	ObjLoginBtn.click();
	}
	

}
