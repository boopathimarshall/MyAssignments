package week4.day1assigment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9",Keys.ENTER);
		String firstPrice = driver.findElement(By.xpath("//span[@class=\"a-price-whole\"]")).getText();
		firstPrice=firstPrice.trim().replace(",", "");
		
		int nprice = Integer.parseInt(firstPrice);
		System.out.println("First mobile price is :"+firstPrice);
		
		String cusRating = driver.findElement(By.xpath("//a//*[contains(@class,\"a-icon a-icon-star-small\")]/span[@class='a-icon-alt']")).getAttribute("innerText");
		
		System.out.println("Customer Rating is "+cusRating);
		
		
		driver.findElement(By.xpath("//h2/a[contains(@class,'a-link-normal s-underline-text')]")).click();
		

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> li = new ArrayList<String>(windowHandles);
		driver.switchTo().window(li.get(1));
		driver.manage().window().maximize();
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/oneplues.png");
		FileUtils.copyFile(screenshotAs, dest);
		Thread.sleep(5000);
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.xpath("//a[@id=\"attach-close_sideSheet-link\"]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Cart')]")).click();
		String subTotal = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']/span")).getText();
		
		subTotal=subTotal.trim().replace(",", "");
		System.out.println(subTotal);
		int sprice = (int)Double.parseDouble(subTotal);
		System.out.println("Sub Total is : "+subTotal);
		if( nprice ==sprice )
		{
			System.out.println("Sub total is correct and the value is "+subTotal);
		}
		else
			System.out.println("wrong subTotal"+subTotal);  

	}

}
