package week4.day1assigment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesCherCher {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

		String text1 = driver.findElement(By.xpath("//label[contains(text(),'Topic : ')]/span")).getText();
		System.out.println("Text in the Topic is " + text1);
		
        //Frame 1 - Send keys as boopathivarma
		WebElement frame1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);
		System.out.println("entered Frame1");
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("BoopathiVarma");
		
		//Frame 3 - Checking the check box
		driver.switchTo().frame("frame3");
		System.out.println("entered Frame3");
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following-sibling::input")).click();
		driver.switchTo().defaultContent();
		
		//Frame 2 - Dropdown value as "Big Baby Cat"
		driver.switchTo().frame("frame2");
		System.out.println("entered Frame2");

		Select sel = new Select(driver.findElement(By.id("animals")));
		sel.selectByVisibleText("Big Baby Cat");
		System.out.println("Performed all actions");

	}

}
