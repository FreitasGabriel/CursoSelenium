import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TesteGoogle {
	
	@Test
	public void teste() {
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver2 = new ChromeDriver();
		//WebDriver driver2 = new InternetExplorerDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		assertEquals("Google", driver.getTitle());
		driver.quit();

	}

}
