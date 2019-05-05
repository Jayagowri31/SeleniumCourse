package Practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthandBrokenImages {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"E:\\Automation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/");

		//Add/Remove Elements
		driver.findElement(By.linkText("Add/Remove Elements")).click();
		driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
		driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
		System.out.println("Added and Removed elements successfully");
		
		//Authentication popup handling
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		System.out.println(driver.findElement(By.xpath("//div/div/p")).getText());
		System.out.println("Authorized successfully");
		
		//Broken images
		driver.navigate().to("http://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Broken Images")).click();
		List<WebElement> brokenimages = driver.findElements(By.xpath("//body/div[2]/div/div/img"));
		System.out.println("Total number of images : " + brokenimages.size());
		for (WebElement ele : brokenimages){
		try {
			HttpURLConnection con = (HttpURLConnection) new URL(ele.getAttribute("src")).openConnection();
			con.setRequestMethod("GET");
			int a = con.getResponseCode();
			if(a !=200)
			{
			
			System.out.println("Broken Image : " + ele.getAttribute("src"));
			}
			else
			{
				System.out.println("Fine Image : " + ele.getAttribute("src"));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		}
		
		driver.close();

	}

}
