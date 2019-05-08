package Practice;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectLastValueFromDropDown {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\\\Automation\\\\Selenium\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		
		driver.get("https://www.cleartrip.com");
		
		//select adult last value from drop down
		WebElement selectDropDown = driver.findElement(By.id("Adults"));
		
		//1st way
		//Select s = new Select(selectDropDown);
		//int selectOptions = s.getOptions().size();
		//s.selectByIndex(selectOptions-1);
		
		//2nd way
		List<WebElement> option = selectDropDown.findElements(By.tagName("option"));
		ArrayList<String> list = new ArrayList<String>();
		for (int i=0; i<option.size();i++)
		{
			list.add(option.get(i).getText());
		}
		
		Collections.reverse(list);
		String lastOption = list.get(0);
		new Select(selectDropDown).selectByVisibleText(lastOption);
		System.out.println(driver.findElement(By.id("Adults")).getAttribute("value"));
		
		
		
	}

}