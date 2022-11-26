package week3.day2;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AJio {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(ch);
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@placeholder='Search AJIO']")).sendKeys("bags", Keys.ENTER);
		driver.findElement(By.xpath("//label[contains(text(),'Men')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id=\"Men - Fashion Bags\"]/following-sibling::label")).click();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String text = driver.findElement(By.xpath("//div[@class=\"filter\"]/div[@class=\"length\"]")).getText();
		String[] splitt = text.split("\\d+");
		String string = splitt.toString();
		System.out.println(text);

		List<WebElement> brandList = driver.findElements(By.className("brand"));
		List<WebElement> nameList = driver.findElements(By.className("nameCls"));

		System.out.println("------------Brand LIST--------------");
		for (int i = 0; i < brandList.size(); i++) {
			System.out.println(brandList.get(i).getText());

		}
		System.out.println("---------Name LIST---------");
		for (int i = 0; i < nameList.size(); i++) {
			System.out.println(nameList.get(i).getText());

		}

		driver.close();
	}

}
