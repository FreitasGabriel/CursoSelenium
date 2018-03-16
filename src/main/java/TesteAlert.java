import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteAlert {
	WebDriver driver = new FirefoxDriver();
	
	@Test
	public void deveInteragirComAlert() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		driver.quit();
	}
	
	@Test
	public void deveInteragirComAlertConfirmOk() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		//String texto = alert.getText();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.accept();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();
		driver.quit();
	}
	
	@Test
	public void deveInteragirComAlertConfirmNo() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.dismiss();
		Assert.assertEquals("Negado", alert.getText());
		alert.accept();
		driver.quit();
	}
	
	@Test
	public void deveInteragirComAlertPrompt() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("12");
		alert.accept();
		Assert.assertEquals("Era 12?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
		
		driver.quit();
	}
}
