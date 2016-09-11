package practicalSeExample;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleLogin {
	public static WebDriver driver;

	@BeforeTest
	public void openurl() {
//adding comment at same point
		driver = new FirefoxDriver();
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier");

	}

	@Test
	public void login() {

		WebElement username = driver.findElement(By.xpath("//input[@id='Email']"));
		username.sendKeys("mittal.kanika12@gmail.com");

		WebElement next = driver.findElement(By.xpath("//input[@id='next']"));
		next.click();

	}

	@AfterTest
	public void closebrowser() {
		// Quits browser
		driver.quit();
	}

	public WebDriver getdriver() {
		return driver;
	}

}
