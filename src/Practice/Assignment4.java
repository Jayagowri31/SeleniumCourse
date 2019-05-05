package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		
		driver.get("http://qaclickacademy.com/practice.php");
		
		//Select checkbox value
		driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).click();
		String text = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
		
		//Select dropdown value
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select s = new Select(dropdown);
		s.selectByVisibleText(text);
		
		//Enter text in editbox
		driver.findElement(By.id("name")).sendKeys(text);
		
		//Verify text in alert
		driver.findElement(By.id("alertbtn")).click();
	    String alerttext = driver.switchTo().alert().getText();
	    if (alerttext.contains(text))
	    {
	    	System.out.println("Retrieved alert message successfully");
	    }
	    
	    else
	    {
	    	System.out.println("Alert message is not retrieved");
	    }
	    
		driver.close();
	}

}
