package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) throws InterruptedException {

		//call the web driver manager for the browser driver
		WebDriverManager.chromedriver().setup();
		
		//launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		//load the url
		driver.get("https://login.salesforce.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//maximize the browser
		driver.manage().window().maximize();	
		
		//login and click on learn more option in mobile publisher
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		
		driver.findElement(By.id("password")).sendKeys("Password$123");
		
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();
		
		//switch the controls to new window
		Set<String> newWindow = driver.getWindowHandles();
		
		List<String> lstWndw = new ArrayList<String> (newWindow);
		
		driver.switchTo().window(lstWndw.get(1));
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(lstWndw.get(0));
		
		driver.close();

	}
}