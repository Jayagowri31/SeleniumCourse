package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {

	
public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	
	System.setProperty("webdriver.chrome.driver", "E:\\\\Automation\\\\Selenium\\\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
	
	driver.get("http://qaclickacademy.com/practice.php");
	
	//Select first checkbox and verify checked or not
	driver.findElement(By.id("checkBoxOption1")).click();
	System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
	
	//UnSelect first checkbox and verify unchecked or not
	driver.findElement(By.id("checkBoxOption1")).click();
	System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
	
	//Retrieve count of number of checkboxes
	System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	
	driver.close();
	

	}

}