import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.javascript.host.Proxy;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;

public class TesteLP {
	
	@Test
	public void testSignature() {
		
		BrowserMobProxy proxy = new BrowserMobProxyServer();
	    proxy.start(0);
	    // get the JVM-assigned port and get to work!
	    int port = proxy.getPort();

	    // get the Selenium proxy object
	    org.openqa.selenium.Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

	    // configure it as a desired capability
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

	    // start the browser up
	    WebDriver driver = new ChromeDriver(capabilities);

	    // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
	    proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

	    // get the HAR data
	    Har har = proxy.getHar();
		
		driver.get("http://portalrecarga.vivo.com.br/lp/descontosnc1");
		driver.findElement(By.className("btn")).click();
		driver.findElement(By.className("btn")).isSelected();
		
		Assert.assertEquals("Parabéns!", driver.findElement(By.tagName("h2")).getText());
		
	}
}
