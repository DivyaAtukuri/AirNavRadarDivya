package AirNavradar;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findLinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Users//datukuri//driver//chromedriver-win64//chromedriver-win64//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.airnavradar.com//");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement consent=driver.findElement(By.xpath("//p[text()='Consent']"));
		consent.click();
		List<WebElement> links=driver.findElements(By.tagName("a"));
		

		for(WebElement link:links){
		    String url=link.getAttribute("href");
		    if(url!=null && !url.isEmpty() && !url.contains("#")){
		        checkLink(url);
		    }
		}
		
		driver.quit();
		
	}
		
	public static void checkLink(String linkurl) throws IOException{
	    try{
	        URL url=new URL(linkurl);
	        
	        HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
	        httpURLConnection.setRequestMethod("HEAD");
	        
	        int resCode=httpURLConnection.getResponseCode();
	        
	        if(resCode>=400){
	            System.out.println(linkurl+" is broken with response code "+resCode);
	        }
	        else{
	            System.out.println(linkurl+" is working with response code "+resCode);
	        }
	        
	    }
	    catch (IOException e) {
            System.out.println(linkurl + " is a broken link.");
        }
	    
	}

}

