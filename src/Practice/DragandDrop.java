package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"D:\\Jaya Gowri\\Automation\\Selenium Tool\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://the-internet.herokuapp.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		// Context menu
		driver.findElement(By.linkText("Drag and Drop")).click();
		Actions act = new Actions(driver);
		WebElement source = driver.findElement(By.id("column-a"));
		WebElement target = driver.findElement(By.id("column-b"));
		act.dragAndDrop(source, target).build().perform();
		
		System.out.println("Dragged and dropped successfully");
		
		 driver.close();

	}

}
