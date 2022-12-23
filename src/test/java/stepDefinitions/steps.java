package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Addcustomerpage;
import pageObjects.Adddiscount;
import pageObjects.LoginPage;
import pageObjects.checkingorders;

public class steps extends BaseClass {

	@Before
	public void setup() throws IOException {

		logger = Logger.getLogger("nopComemrce");// added Logger
		PropertyConfigurator.configure("Log4j.properties"); // added logger

		Layout layout = new PatternLayout("%d  %c %m %n");
		Appender appender = new FileAppender(layout, "./log/Logging.log");
		BasicConfigurator.configure(appender);

		logger = Logger.getLogger(this.getClass().getName());
		configProp = new Properties();

		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);

		String br = configProp.getProperty("browser");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();

		}

		else if (br.equals("ie")) {

			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}
		logger.info("***launcing  browser****");
	}

	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() throws IOException {

		adddis = new Adddiscount(driver);

		lp = new LoginPage(driver);
	}

	@When("User opens the URL {string}")
	public void user_opens_the_URL(String url) {
		logger.info("***opening  url****");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("User enters the Email as {string} and password as {string}")
	public void user_enters_the_Email_as_and_password_as(String email, String password) throws InterruptedException {
		logger.info("***providing login  details****");
		lp.setUserName(email);
		Thread.sleep(10);
		lp.setPassword(password);
		Thread.sleep(10);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) throws InterruptedException {
		logger.info("***providing login  details****");
		lp.setUserName(email);
		Thread.sleep(10);
		lp.setPassword(password);
		Thread.sleep(10);
	}

	@Then("Close the browser")
	public void close_the_browser() {
		driver.quit();
	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
		logger.info("***started login ****");
		lp.clickLogin();
		Thread.sleep(10);

	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) throws InterruptedException {
		if (driver.getTitle().contains("Login was unsuccessful.")) {
			driver.close();
			logger.info("*** login  passed****");
			Assert.assertTrue(false);
		} else {
			logger.info("*** login  failed****");
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(20);

	}

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException {
		logger.info("*** click on logout  link****");
		Thread.sleep(10);
		lp.clickLogout();
		Thread.sleep(10);

	}

	// addcustomer starts here

	@Then("User can view Dashboad")
	public void user_can_view_Dashboad() {
		addcust = new Addcustomerpage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", getPageTitle());

	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() throws InterruptedException {

		addcust.clickOnCustomersMenu();

	}

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item() throws InterruptedException {
		Thread.sleep(10);
		addcust.lnkCustomers_menuitem();

	}

	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {
		addcust.clickOnAddnew();
		Thread.sleep(10);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", getPageTitle());

	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = randomString() + "@gmail.com";
		addcust.setEmail(email);
		addcust.setPassword("test123");
		addcust.setCustomerRoles("Guests");
		Thread.sleep(10);
		addcust.setManagerOfVendor("Vendor 2");
		addcust.setGender("Male");
		addcust.setFirstname("Pavan");
		addcust.setLasttname("kumar");
		addcust.setdob("7/05/1985");
		addcust.setCompanyName("busyQA");
		addcust.setAdmincontent("This is for Testing.....");

	}

	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException {
		addcust.clickonsave(null);
		Thread.sleep(10);

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));

	}

// Add discount starts here

	@When("user clicks on Promotions")
	public void user_clicks_on_Promotions() throws InterruptedException {
		adddis.Promotions_menu();
		Thread.sleep(20);

	}

	@When("user clicks on Discounts")
	public void user_clicks_on_Discounts() throws InterruptedException {
		Thread.sleep(30);
		adddis.Discounts_menu();

	}

	@When("user clicks on Add new button")
	public void user_clicks_on_Add_new_button() throws InterruptedException {
		Thread.sleep(30);
		adddis.Add_new();

	}

	@Then("Add a new discount page should be displayed")
	public void add_a_new_discount_page_should_be_displayed() {
		Assert.assertEquals("Add a new discount / nopCommerce administration", getPageTitle());

	}

	@When("user enter Discount type")
	public void user_enter_Discount_type() {
		adddis.Discounttype_vlaue("Assigned to shipping");
	}

	@When("user enter Discount info")
	public void user_enter_Discount_info() {
		adddis.name();
		adddis.Percentagecheckbox();
		adddis.Dispercentage();

	}

	@When("click on save button")
	public void click_on_save_button() {

		adddis.clickonsave();
	}

	@Then("The new discount has been added successfully message should be displayed")
	public void the_new_discount_has_been_added_successfully_message_should_be_displayed() {

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']"))
				.getText().contains("The new discount has been added successfully"));

	}

	// checking orders methods

	@Then("Page Title should be be displayed as {string}")
	public void page_Title_should_be_be_displayed_as(String string) {
		orders = new checkingorders(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", getPageTitle());
	}

	@Then("Click on sales and orders")
	public void click_on_sales_and_orders() {
		orders.sales();
		orders.orders();

	}

	@Then("Page Title should be be displayed  {string}")
	public void page_Title_should_be_be_displayed(String string) {
		Assert.assertEquals("Orders / nopCommerce administration", getPageTitle());

	}

	// WebElement Billingcountry = orders.Billingcountry;
	// WebElement Paymentmethod = orders.Paymentmethod;
	// List<WebElement> Orderstatus = orders.Orderstatus;
	// List<WebElement> Paymentstatuses = orders.Paymentstatuses;
	// List<WebElement> Shippingstatuses = orders.Shippingstatuses;

	@When("User user enters order details")
	public void user_user_enters_order_details() {
		// orders.Warehouse();
		// WebElement Warehouse = null;
		// checkingorders.selectdropdown1(Warehouse, "Warehouse 1 (New York)");

		orders.Billingcountry();
		checkingorders.selectdropdown1(orders.Billingcountry, "Canada");

		orders.Paymentmethod();
		checkingorders.selectdropdown1(orders.Paymentmethod, "Check / Money Order");

		orders.Orderstatus();
		orders.selectdropdown2(orders.Orderstatus1, "Complete");

		orders.Paymentstatuses();
		orders.selectdropdown2(orders.Paymentstatuses1, "Paid");

		orders.Shippingstatuses();
		orders.selectdropdown2(orders.Shippingstatuses1, "Delivered");
		
		orders.datepicker();
	}

	@When("Click on search")
	public void click_on_search() {
		orders.search();
	}

	@Then("orders detail should be displayed below")
	public void orders_detail_should_be_displayed_below() {
        boolean status = orders.searchOrders("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);

	}

}
