package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup(); // Setup Driver

		ChromeDriver driver = new ChromeDriver(); // Setup Driver
		driver.get("http://leaftaps.com/opentaps/control/login"); // Launch URl
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager"); // Send Username
		driver.findElement(By.id("password")).sendKeys("crmsfa"); // Sending Password
		driver.findElement(By.className("decorativeSubmit")).click(); // Clicking Login
		driver.findElement(By.linkText("CRM/SFA")).click(); // Clicking crmsfa link
		driver.findElement(By.linkText("Leads")).click(); // Click on Leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click(); // Click on find leads

		driver.findElement(By.xpath("//span [text()='Email']")).click();

		driver.findElement(By.xpath("//label[text()='Email Address:']/following-sibling::div/input"))
				.sendKeys("boopathimarshall@gmail.com"); // passing

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click(); // Click Find leads
		Thread.sleep(30000);
		WebElement eleFirstnamerecord = driver.findElement(By.xpath("//td[contains(@class,'friendlyPartyName ')]"
				+ "/following-sibling::td[contains(@class,'firstName ')]"));
		String text4 = eleFirstnamerecord.getText();   //Capturing the Firstname
		
//		System.out.println("button clicked");
//		WebElement elemId = driver.findElement(By.xpath("//div [contains(@class,'col-partyId')]/a"));
//		String text = elemId.getText();
//		System.out.println(text);
		
		driver.findElement(By.xpath("//div [contains(@class,'col-partyId')]/a")).click(); //clicking first record
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click(); // clicking duplicate lead
		
		WebElement elemTitle = driver.findElement(By.xpath("//div[text()='Duplicate Lead']"));
		String textTitle = elemTitle.getText();
		if(textTitle.equalsIgnoreCase("Duplicate Lead"))  // Checking the heading 
		{
			System.out.println("Pass Verification : Duplicate Lead heading");
		}
		else
			System.out.println("Title is wrong");
		
		
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();// Clicking on Create lead
		
		WebElement elemFirstname = driver.findElement(By.xpath("//span[@id=\"viewLead_firstName_sp\"]"));
		String textFirstname = elemFirstname.getText();// Taking the Duplicate lead name
		
		if(text4.equals(textFirstname))// Comparing the duplicate lead name and the captured name.
		{
			System.out.println("Compared the names and they are same");
		}
		else
			System.out.println("Names Missmatch");
		
		driver.close();
		
		

	}

}
