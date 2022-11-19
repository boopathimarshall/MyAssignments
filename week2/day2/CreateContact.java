package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://leaftaps.com/opentaps/control/main");
		

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");

		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		driver.findElement(By.xpath("//input[@id='firstNameField']")).sendKeys("boopathi");
		driver.findElement(By.xpath("//input[@id='lastNameField']")).sendKeys("varma");
		driver.findElement(By.xpath("//input[@name='firstNameLocal']")).sendKeys("bloc");
		driver.findElement(By.xpath("//input[@name='lastNameLocal']")).sendKeys("vloc");
		driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("CIVIL");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("This is description ");
		driver.findElement(By.xpath("//td//input[@name='primaryEmail']")).sendKeys("test@gmail.com");
		
		Select select = new Select (driver.findElement(By.xpath("//td//select[@name='generalStateProvinceGeoId']")));
		
		select.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		driver.findElement(By.xpath("//textarea[@name='description']")).clear();
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Notes added");
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		String title = driver.getTitle();
		System.out.println("Title of the page: "+title);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
