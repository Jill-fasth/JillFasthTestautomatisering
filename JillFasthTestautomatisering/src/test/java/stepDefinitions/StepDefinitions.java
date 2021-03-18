package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class StepDefinitions {
	
	private WebDriver driver;
	
	@Before("I have opend the website")
	public void Open_website() {
}
	@Given("I have entered a email")
	public void i_have_entered_size_S_from_the_dropdown_list() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Selenium chrome\\chromedriver.exe");
System.out.println("");
	
}
	}
