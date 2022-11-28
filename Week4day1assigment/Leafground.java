package week4.day1assigment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafground {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://leafground.com/window.xhtml;jsessionid=node0ssnceyfd5mtq1u38yu3inp0zh436503.node0");
		// 1. First Open Button
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> li = new ArrayList<String>(windowHandles);

		String title1 = driver.switchTo().window(li.get(1)).getTitle();
		System.out.println("Title of First window : " + title1);
		driver.close();
		driver.switchTo().window(li.get(0));

		System.out.println("Now in 1st window");

		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> li1 = new ArrayList<String>(windowHandles1);

		driver.switchTo().defaultContent();
		driver.switchTo().window(li1.get(1));
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		Thread.sleep(2000);
		System.out.println(title);

		driver.switchTo().window(li1.get(2));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//span/input[@placeholder='Search']")).sendKeys("BoopathiVarma");

		driver.close();
		System.out.println();
		driver.switchTo().window(li.get(0));

		// driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> li2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(li2.get(0));

		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		System.out.println(" click on close widnow");

		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> li3 = new ArrayList<String>(windowHandles3);
		System.out.println(windowHandles3);

		driver.switchTo().window(li3.get(1));
		driver.close();

		System.out.println(" 1st window closed");

		driver.switchTo().window(li3.get(2));
		driver.close();
		System.out.println(" 2nd window closed");

		driver.switchTo().window(li3.get(3));
		driver.close();
		System.out.println(" 3rd window closed");

	}

}
