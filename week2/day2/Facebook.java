package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://en-gb.facebook.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//a [text()='Create New Account']")).click();
		driver.findElement(By.xpath("//input [@name=\"firstname\"]")).sendKeys("FEM");
		driver.findElement(By.xpath("//input [@name=\"lastname\"]")).sendKeys("Nam");
		driver.findElement(By.xpath("//div [contains(text(),'Mobile number')]")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input [@id=\"password_step_input\"]")).sendKeys("TESTING");

		Select s = new Select(driver.findElement(By.xpath("//select[@name=\"birthday_day\"]")));
		s.selectByVisibleText("28");

		Select s1 = new Select(driver.findElement(By.xpath("//select[@id=\"month\"]")));
		s1.selectByIndex(9);

		Select s2 = new Select(driver.findElement(By.xpath("//select[@id=\"year\"]")));
		s2.selectByValue("1995");

		driver.findElement(By.xpath("//label[text()='Female']")).click();

	}

}
