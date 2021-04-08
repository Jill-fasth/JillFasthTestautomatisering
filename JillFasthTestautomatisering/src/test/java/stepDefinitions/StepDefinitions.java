package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.junit.Assert;

import common.UserDetails;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	public UserDetails details = new UserDetails();
	private WebDriver driver;
	
	@Before("")
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Selenium chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.mailchimp.com/signup/");
		driver.manage().window().maximize();
	}
	@After("")
	public void close() {
		driver.quit();
	}
	@Given("I have entered a ranUser")
	public void email() {
		sendKeys(By.id("email"), details.ranUser());
	}
	@And("I have entered a empty")
	public void empty_string() {
		sendKeys(By.id("email"), details.empty());
	}
	@And("I have entered a saved")
	public void saved_email_address() {
		sendKeys(By.id("email"), details.saved());
	}
	@And("A ranUser")
	public void ranUser() {
		sendKeys(By.id("new_username"), details.ranUser());
	}
	@And("A ranUser101")
	public void ranUser101() {
		sendKeys(By.id("new_username"), details.ranUser101());
	}
	@And("A saved")
	public void saved_username() {
		sendKeys(By.id("new_username"), details.saved());
	}
	@And("Finally I have entered a password")
	public void add_password() {
		sendKeys(By.id("new_password"), details.password());
	
	}
	private void sendKeys(By by, String keys) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
		driver.findElement(by).sendKeys(keys);
		
	}
	@When("I accept cookies and click on the Sign-Up button")
	public void enter() {
		click(By.id("onetrust-accept-btn-handler"));
		click(By.id("create-account"));
		
	}
	private void click(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
		
	}
	@Then("I verify the {string} in step")
	public void result(String status) {

		if (status.equals("success")) {
			getText(By.cssSelector(".\\!margin-bottom--lv3"), ("Check your email"));
			System.out.println("Perfect, a account was created.");
		}
		else if (status.equals("too long")) {
			getText(By.cssSelector(".invalid-error"), ("Enter a value less than 100 characters long"));
			System.out.println("Username need to be less than 100 characters");
		}
		else if (status.equals("already in use")) {
			getText(By.cssSelector(".invalid-error"),
					("Another user with this username already exists. Maybe it\'s your evil twin. Spooky."));
			System.out.println("E-mail account already exists");
		}
		else if (status.equals("email missing")) {
			getText(By.id("email"), (""));
			System.out.println("Email is needed");
		} else {
			System.out.println("This looks like a new error message!");
		}
	}
	private void getText(By by, String text) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
		Assert.assertEquals(driver.findElement(by).getText(), (text));
	}
}