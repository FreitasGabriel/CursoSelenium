import java.util.List;

import org.junit.Assert;
//import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestesUnitários {
	WebDriver driver = new FirefoxDriver();
	 
	@Test
	public void testeTextField() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Gabriel");
		Assert.assertEquals("Gabriel", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		driver.quit();
		
	}
	
	@Test
	public void testeTextField2() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Freitas");
		Assert.assertEquals("Freitas", driver.findElement(By.id("ElementosForm:sobrenome")).getAttribute("value"));
		
		driver.quit();
	}
	
	@Test
	public void testeTextArea() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste de escrita");
		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		driver.quit();
	}
	
	@Test
	public void testeRadioButton() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:sexo:1")).isSelected();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
		driver.quit();
	}
	
	@Test
	public void testeCheckBox() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		
		driver.quit();
	}
	
	@Test
	public void testeComboBox() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Superior");
		
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		
		driver.quit();
	}
	
	@Test
	public void deveVerificarValoresCombo() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		
		boolean encontrou = false;
		for(WebElement option:options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
		driver.quit();
	}
	
	@Test
	public void MudarBotao() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();
				}
}
