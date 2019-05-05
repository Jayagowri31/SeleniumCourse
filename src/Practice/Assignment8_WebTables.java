package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8_WebTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		
		driver.get("http://qaclickacademy.com/practice.php");
		
		/*System.out.println(driver.findElements(By.xpath("//table[@id='product']/tbody/tr")).size());
		System.out.println(driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th")).size());
		System.out.println(driver.findElement(By.xpath("//table[@id='product']/tbody/tr[3]")).getText());*/
		
		WebElement table = driver.findElement(By.id("product"));
		System.out.println(table.findElements(By.tagName("tr")).size());
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		List<WebElement> secondrow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());
		driver.quit();
}
}
