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

public class Leafground {

	public static void main(String[] args) throws InterruptedException {

		//call the web driver manager for the browser driver
		WebDriverManager.chromedriver().setup();
		
		//launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		//load the url
		driver.get("http://www.leafground.com/pages/Window.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//maximize the browser
		driver.manage().window().maximize();	
		
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		
		System.out.println(driver.getTitle());
		
		//get all the window handles for the tabs , opened as part of this execution in a set
		Set<String> windowHandles = driver.getWindowHandles();
		
		//converting the set into list to get the handle using index
		//can also use iteration
		List<String> lstWinHndles = new ArrayList<String> (windowHandles);
		
		//take the contro to second page
		driver.switchTo().window(lstWinHndles.get(1));
		
		driver.close();		
		
		//take the contro to home page
		driver.switchTo().window(lstWinHndles.get(0));
		
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		
		System.out.println("The number of open windows is : " +windowHandles1.size());
		
		//converting the set into list to get the handle using index
		//can also use iteration
		List<String> lstWinHndles1 = new ArrayList<String> (windowHandles1);
		
		//take the contro to third page
		driver.switchTo().window(lstWinHndles1.get(2));
		
		driver.close();		
		
		//take the control to first page
		driver.switchTo().window(lstWinHndles1.get(1));
		
		driver.close();		

		//take the control to home page
		driver.switchTo().window(lstWinHndles.get(0));
		
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		
		Set<String> doNotClose = driver.getWindowHandles();
		
		List<String> lstNotClose = new ArrayList<String> (doNotClose);
		
		driver.close();
		
		driver.switchTo().window(lstNotClose.get(1));

		driver.close();
		
		driver.switchTo().window(lstNotClose.get(2));

		driver.manage().window().maximize();

		WebElement position = driver.findElement(By.xpath("//button[text()='Get Position']"));
		
		System.out.println(position.getLocation());
		
		System.out.println(driver.findElement(By.id("color")).getCssValue("background-color"));
		
		System.out.println(driver.findElement(By.id("size")).getSize());
		
		driver.findElement(By.xpath("//button[@id='home']")).click();
		
		Thread.sleep(5000);

		driver.findElement(By.xpath("//img[@src='images/windows.png']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();

		Set<String> finalWindowHandles1 = driver.getWindowHandles();
		
		System.out.println("The number of open windows is : " +finalWindowHandles1.size());

	}
}