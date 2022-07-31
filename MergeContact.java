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

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {

		//call the web driver manager for the browser driver
		WebDriverManager.chromedriver().setup();
		
		//launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		//load the url
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//maximize the browser
		driver.manage().window().maximize();	
		
		//login to leaftaps page, click on contacts and select merge contacts
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		//get the current window handle
		String primary = driver.getWindowHandle();
		
		//select the wizard next to from contact
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();

		//get all the window handles for the tabs , opened as part of this execution in a set
		Set<String> windowHandles = driver.getWindowHandles();
		
		System.out.println(windowHandles);
		
		//converting the set into list to get the handle using index
		//can also use iteration
		List<String> lstWinHndles = new ArrayList<String> (windowHandles);
		
		//take the contro to second page
		driver.switchTo().window(lstWinHndles.get(1));
		
		Thread.sleep(5000);

		//click the first link
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
		
		//taking the control back to primary page
		driver.switchTo().window(primary);
		
		//System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		
		System.out.println("ToLead " +windowHandles1);
		
		List<String> lstWinHndles1 = new ArrayList<String> (windowHandles1);
		
		driver.switchTo().window(lstWinHndles1.get(1));
		
		Thread.sleep(5000);

		//click on the second link
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		
		driver.switchTo().window(primary);
		
		Thread.sleep(5000);

		driver.findElement(By.linkText("Merge")).click();
		
		//logic to take the control to alert pop up and accept it
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
		System.out.println(driver.getTitle());

	}
}