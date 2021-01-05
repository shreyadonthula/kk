

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CRossBrowserCheck {
			WebDriver driver;
			@BeforeTest
			@Parameters("browser")
			public void setup(String browser) throws Exception {
				if(browser.equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver","E:\\selenium_new\\chromedriver.exe" );
			  		
					 driver=new ChromeDriver();
				}
				else if(browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver", "E:\\selenium_new\\geckodriver.exe");

				 driver = new FirefoxDriver();
				}
				else {
					throw new Exception("browser is not correct");
				}
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			}
			
			@Test
			public void test() throws InterruptedException {
				driver.get("http://google.com/");
		  		
		  		 Thread.sleep(5000);
		  	    
			}
			
}
