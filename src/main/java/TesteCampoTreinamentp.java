import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamentp {
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
		Assert.assertEquals("Freitas", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));
		
		driver.quit();
	}
	
	@Test
	public void testeTextArea() {
		
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste de textarea");
		Assert.assertEquals("Teste de textarea", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		driver.quit();
	}
	
	@Test
	public void testeRadioButton() {
		
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:sexo:0")).isSelected();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.quit();
	}
	
	@Test
	public void testeCheckBox() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		driver.quit();
	
	}
	
	@Test
	public void testeComboBox() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		//combo.selectByIndex(2);
		//combo.selectByValue("2grauincomp");
		combo.selectByVisibleText("Mestrado");
		
		Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());
		
		driver.quit();
	}
	
	@Test
	public void deveVerificarValoresComboBox() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element2 = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element2);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
		
		driver.quit();
	}
	
	@Test
	public void deveVerificarValoresComboBoxFalha() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element3 = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element3);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option:options) {
			if(option.getText().equals("Superior")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
		driver.quit();
	}
	
	@Test
	public void deveVerificarValoresComboBoxMultiplo() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("Karate");
		List<WebElement> options = combo.getAllSelectedOptions();
		
		boolean encontrado = false;
		for(WebElement option:options) {
			if(option.getText().equals("Natacao")) {
				encontrado = true;
				break;
			}
		}
		Assert.assertTrue(encontrado);
		driver.quit();
	}
	
	@Test
	public void deveMudarBotao() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();
	}
	
	@Test
	@Ignore
	public void deveInteragirComLink() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.linkText("Voltar")).click();
	}
	
	@Test
	public void deveInteragirComTexto() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		Assert.assertTrue(driver.findElement(By.tagName("body"))
				.getText().contains("Campo de Treinamento"));
		
		driver.quit();
	}
	
}
