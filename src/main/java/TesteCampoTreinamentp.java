import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamentp {
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	@Test
	public void testeTextField() {
		dsl.escreve("elementosForm:nome", "Gabriel");
		Assert.assertEquals("Gabriel", dsl.obterValorCampo("elementosForm:nome"));

	}
	
	@Test
	public void testeTextField2() {
		dsl.escreve("elementosForm:sobrenome", "Freitas");
		Assert.assertEquals("Freitas", dsl.obterValorCampo("elementosForm:sobrenome"));
	}
	
	@Test
	public void testeTextArea() {
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste de textarea");
		Assert.assertEquals("Teste de textarea", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

	}
	
	@Test
	public void testeRadioButton() {

		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:sexo:0")).isSelected();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

	}
	
	@Test
	public void testeCheckBox() {
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());

	}
	
	@Test
	public void testeComboBox() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		//combo.selectByIndex(2);
		//combo.selectByValue("2grauincomp");
		combo.selectByVisibleText("Mestrado");
		
		Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());

	}
	
	@Test
	public void deveVerificarValoresComboBox() {
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

	}
	
	@Test
	public void deveVerificarValoresComboBoxFalha() {
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
	}
	
	@Test
	public void deveVerificarValoresComboBoxMultiplo() {
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

	}
	
	@Test
	public void deveMudarBotao() {
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));

	}
	
	@Test
	@Ignore
	public void deveInteragirComLink() {
		driver.findElement(By.linkText("Voltar")).click();
	}
	
	@Test
	public void deveInteragirComTexto() {
		//Assert.assertTrue(driver.findElement(By.tagName("body"))
			//	.getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		//getText() - serve para transformar em string algo que está sendo retornado como WebElement
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", 
				driver.findElement(By.className("facilAchar")).getText());//className serve para pesquisar por class
	}
	
}