import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import net.lightbody.bmp.util.BrowserMobHttpUtil;


public class TesteLP {
	
	@Test
	public void testSignature() throws Exception {
		
		BrowserMobProxyServer proxyServer = new BrowserMobProxyServer();
		proxyServer.start();
		proxyServer.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
		proxyServer.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
		Proxy proxy = ClientUtil.createSeleniumProxy(proxyServer);
		FirefoxProfile profile = new FirefoxProfile();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setAcceptInsecureCerts(true);
		String host = proxy.getHttpProxy().split(":")[0];
		int port = Integer.parseInt(proxy.getHttpProxy().split(":")[1]);
		
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.http", host);
		profile.setPreference("network.proxy.http_port", port);
		profile.setPreference("netqork.proxy.ssl", host);
		profile.setPreference("network.proxy.ssl_port", port);
		
		profile.setPreference("acceptInseruceCerts", true);
		cap.setCapability(FirefoxDriver.PROFILE, profile);
		FirefoxDriver driver = new FirefoxDriver(cap);		

		
		proxyServer.newHar("mysite");
		driver.get("http://www.google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("Teste");
		driver.findElement(By.name("btnK")).click();

		
	}
		

}
