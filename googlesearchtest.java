
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class googlesearchtest {
	private static WebDriver driver =null;
	public static void main(String[] args) throws InterruptedException {
		googlesearch();
	}
	public static void googlesearch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:/selnium_software/chromedriver_win32/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		googlesearchpage.textbox_search(driver).sendKeys("Automation");
		Thread.sleep(2000);
		googlesearchpage.button_search(driver).click();
		
	}
         
}
