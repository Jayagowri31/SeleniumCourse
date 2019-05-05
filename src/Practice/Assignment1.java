package Practice;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\\\Automation\\\\Selenium\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		
		driver.get("https://www.cleartrip.com");
		
		//select adult value from drop down
		WebElement Adult = driver.findElement(By.id("Adults"));
		Select s = new Select(Adult);
		s.selectByValue("7");
		
		//select children value from drop down
		WebElement Children = driver.findElement(By.id("Childrens"));
		Select s1 = new Select(Children);
		s1.selectByIndex(1);
		
		//Select the current date from depart on field
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		//Click on link, select class of travel from drop down and provide preferred airline
		driver.findElement(By.cssSelector("#MoreOptionsLink")).click();
		WebElement Classoftravel = driver.findElement(By.cssSelector("#Class"));
		Select s2 = new Select(Classoftravel);
		s2.selectByVisibleText("Premium Economy");
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("SpiceJet");
		
		//Validating error message 
		driver.findElement(By.id("SearchBtn")).click();
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
		
		driver.close();

	}

}