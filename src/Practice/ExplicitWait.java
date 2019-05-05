package Practice;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\\\Automation\\\\Selenium\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
		
		driver.findElement(By.xpath("//a[text()='Click to load get data via Ajax!']")).click();
		WebDriverWait wait = new WebDriverWait(driver,25);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("results")));
		
		
		System.out.println(driver.findElement(By.id("results")).getText());
		
		driver.close();
	}

}