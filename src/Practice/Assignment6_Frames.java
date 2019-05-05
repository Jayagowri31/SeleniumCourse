package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6_Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		
		driver.get("https://the-internet.herokuapp.com");
		
		driver.findElement(By.linkText("Nested Frames")).click();
		/*driver.switchTo().frame("frame-top");
		driver.switchTo().frame(0);
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame-middle");*/
		WebElement ft = driver.findElement(By.name("frame-top"));
		driver.switchTo().frame(ft);
		WebElement fm = driver.findElement(By.name("frame-middle"));
		driver.switchTo().frame(fm);
		System.out.println(driver.findElement(By.id("content")).getText());
		
		driver.close();
		

}
}
