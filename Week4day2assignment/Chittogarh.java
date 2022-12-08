package week4.day2assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittogarh {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		//.addArguments("--headless");

		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.chittorgarh.com/");
		
		WebElement stockMarket = driver.findElement(By.xpath("//a[text()='STOCK MARKET ']"));
		stockMarket.click();
		
	
		
		WebElement bulkDeals = driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']"));
		
		Thread.sleep(4000);
		bulkDeals.click();
		List<WebElement> secNamesList = driver.findElements(By.xpath("//table[contains(@class,'table-condensed')]/tbody/tr/td[3]"));
		
		List<String> li = new ArrayList<String>();
		for (WebElement webElement : secNamesList) {
			
			System.out.println(webElement.getText());
			li.add(webElement.getText());
		}
		Set<String> si = new HashSet<String>(li);
		
		if(si.size()==li.size())
		{
			System.out.println("No duplicates");
		}
		
		else if (si.size()<li.size())
		{
			System.out.println("There are duplicates" );
		}

		
	}

}
