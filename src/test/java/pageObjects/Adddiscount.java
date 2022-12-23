package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class Adddiscount {

	public WebDriver Idriver;

	WaitHelper waithelper;

	public Adddiscount(WebDriver rdriver) {
		Idriver = rdriver;
		PageFactory.initElements(Idriver, this);
		waithelper = new WaitHelper(Idriver);

	}

	@FindBy(xpath = "//a[@class='nav-link']/i[@class='nav-icon fas fa-tags']")
	WebElement Promotions;

	By Discounts = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[5]/ul/li[1]/a");

	// @FindBy(xpath = "//li[@class='nav-item']/a[@class='nav-link active']")
	// WebElement Discounts;

	By Addnew = By.xpath("/html/body/div[3]/div[1]/div/div/a");

	// @FindBy(xpath = "//div[@class='float-right']")
	// WebElement Addnew;

	@FindBy(xpath = "//input[@id='Name']")
	WebElement Name;

	@FindBy(xpath = "//select[@name='DiscountTypeId']")
	WebElement Discounttype;
	
	@FindBy(xpath = "//select[@id='DiscountTypeId']/option")
	List<WebElement> Discounttypess;
	

	@FindBy(xpath = "//option[text()='Assigned to order total']")
	WebElement ordertotal;

	@FindBy(xpath = "//option[text()='Assigned to products']")
	WebElement products;

	@FindBy(xpath = "//option[text()='Assigned to categories']")
	WebElement categories;

	@FindBy(xpath = "//option[text()='Assigned to manufacturers']")
	WebElement manufactures;

	@FindBy(xpath = "//option[text()='Assigned to shipping']")
	WebElement shipping;

	@FindBy(xpath = "//input[@id='UsePercentage']")
	WebElement Percentage;

	@FindBy(xpath = "//div[@id='pnlDiscountPercentage']//input[@aria-disabled='false' and @class='k-formatted-value k-input']")
	WebElement Discount_Percentage;

	@FindBy(xpath = "//button[@name='save']")
	WebElement save_button;

	public void Promotions_menu() {
		Promotions.click();
		waithelper.WaitForElement(Promotions, 15);
	}

	public void Discounts_menu() throws InterruptedException {
		Thread.sleep(20);
		Idriver.findElement(Discounts).click();
	}

	public void Add_new() throws InterruptedException {
		Thread.sleep(20);
		Idriver.findElement(Addnew).click();
	}

	public void name() {
		Name.sendKeys("suman");
	}

	public void Discount_type() {
		if (!Discounttype.equals("Assigned to order total"))
			Discounttype.clear();
		Discounttype.click();
	}

	public String Discounttype_vlaue(String value) {
		
		for(WebElement drp : Discounttypess)
		{
			if(drp.getText().equals(value))
			{
				drp.click();
			}
		}
		return value;
		

		/*if (value.equals("Assigned to order total")) {
			ordertotal.click();
		}

		else if (value.equals("Assigned to products")) {
			products.click();
		}

		else if (value.equals("Assigned to categories")) {
			categories.click();

		} else if (value.equals("Assigned to shipping")) {
			shipping.click();
		}

	}*/
	}

	public void Percentagecheckbox() {
		Percentage.click();
	}

	public void Dispercentage() {
		Discount_Percentage.sendKeys("50");

	}

	public void clickonsave() {
		save_button.click();
	}

}
