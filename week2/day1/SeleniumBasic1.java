package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasic1 {

	public static void main(String[] args) {
        //Set up Webdriver
		WebDriverManager.chromedriver().setup();
		
		//Setup driver
		ChromeDriver driver = new ChromeDriver();
		
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Encora");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Boopathi");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Varma");
		WebElement seldrop = driver.findElement(By.id("createLeadForm_dataSourceId"));
		
		Select select = new Select(seldrop);
		
		select.selectByValue("LEAD_CONFERENCE");
	
		
		
		//driver.findElement(By.name("submitButton")).click();
		
		
		
		

	}

}
