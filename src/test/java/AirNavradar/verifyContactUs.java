package AirNavradar;

import java.util.*;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class verifyContactUs {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Users//datukuri//driver//chromedriver-win64//chromedriver-win64//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.airnavradar.com//");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement consent=driver.findElement(By.xpath("//p[text()='Consent']"));
		consent.click();
		WebElement about=driver.findElement(By.xpath("//span[contains(text(),'About')]"));
		Actions action = new Actions(driver);
		 
		//Performing the mouse hover action on the target element.
		action.moveToElement(about).perform();
		Thread.sleep(2000);
		WebElement contactUs=driver.findElement(By.xpath("//a[text()='Contact Us']"));
		action.moveToElement(contactUs).perform();
		contactUs.click();
	      System.out.println("Page title of new tab: " + driver.getTitle());
	      driver.quit();
		
	}

}
