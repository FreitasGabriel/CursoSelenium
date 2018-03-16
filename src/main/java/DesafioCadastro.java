import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioCadastro {

	WebDriver driver = new FirefoxDriver();
	@After
	public void Finaliza() {
		driver.quit();
	}
	
	@Test
	public void cadastroComSucesso() {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		//CADASTRO NOME
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Gabriel");
		Assert.assertEquals("Gabriel", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		//CADASTRO SOBRENOME
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Freitas");
		Assert.assertEquals("Freitas", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));
		
		//SELECIONAR SEXO
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:sexo:0")).isSelected();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		//SELECIONAR COMIDA
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		
		//SELECIONAR ESCOLARIDADE
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Mestrado");
		
		Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());
		
		//SELECIONAR ESPORTES
		WebElement element2 = driver.findElement(By.id("elementosForm:esportes"));
		Select combo2 = new Select(element2);
		combo2.selectByVisibleText("Natacao");
		combo2.selectByVisibleText("Karate");
		List<WebElement> options = combo2.getAllSelectedOptions();
		
		
		boolean finded = false;
		for (WebElement option:options) {
			if(option.getText().equals("Natacao")) {
				finded = true;
				break;
			}
			System.out.println(finded);
			Assert.assertTrue(finded);
		}
		
		//DESELECIONAR OS CAMPOS
		
		combo2.deselectAll();
		
		//CADASTRO SUGESTÃO
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste de escrita");
		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		//CONFIRMAR
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
	}

}
