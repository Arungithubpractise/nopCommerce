package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class LoginPage {

	public WebDriver Idriver;
	WaitHelper waithelper;

	public LoginPage(WebDriver rdriver) {
		Idriver = rdriver;
		PageFactory.initElements(Idriver, this);
		waithelper = new WaitHelper(Idriver);
	}

	@FindBy(id = "Email")
	WebElement txtEmail;

	@FindBy(id = "Password")
	WebElement txtPassword;

	@FindBy(xpath = "//button")
	WebElement btnLogin;

	@FindBy(linkText = "Logout")
	WebElement lnkLogout;

	public void setUserName(String email) {
		waithelper.WaitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setPassword(String pwd) {
		waithelper.WaitForElement(txtPassword, 30);
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public void clickLogout() {
		lnkLogout.click();
	}

}
