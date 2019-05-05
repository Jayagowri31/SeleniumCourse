package Practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		
		driver.get("https://the-internet.herokuapp.com");
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentid = it.next();
		String childid = it.next();
		//driver.switchTo().window(it.next());
		driver.switchTo().window(childid);
		System.out.println(driver.findElement(By.xpath("//body/div/h3")).getText());
		driver.switchTo().window(parentid);
		System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());
	
		//driver.quit();
		

}
}
