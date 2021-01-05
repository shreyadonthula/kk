
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class googlesearchtest_testngdemo {
	private static WebDriver driver =null;
	@BeforeTest
	public void setuptest() {
	System.setProperty("webdriver.chrome.driver", "E:\\selenium_new\\chromedriver.exe");
		
		driver = new ChromeDriver();
	}
	@Test
	public void googlesearch() throws InterruptedException {
	
		driver.get("https://www.google.com");
		googlesearchpage.textbox_search(driver).sendKeys("Automation");
		Thread.sleep(2000);
		googlesearchpage.button_search(driver).click();
		
	}
	@AfterTest
	public void teardowntest() {
		driver.close();
		driver.quit();
		System.out.println("done....");
	}
         
}
