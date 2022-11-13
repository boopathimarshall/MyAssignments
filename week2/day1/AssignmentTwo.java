package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentTwo {


	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup(); // Setup Driver

		ChromeDriver driver = new ChromeDriver(); // Setup Driver
		driver.get("http://leaftaps.com/opentaps/control/login"); // Launch URl
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager"); // Send Username
		driver.findElement(By.id("password")).sendKeys("crmsfa"); // Sending Password
		driver.findElement(By.className("decorativeSubmit")).click(); // Clicking Login
		driver.findElement(By.linkText("CRM/SFA")).click(); // Clicking crmsfa link
		driver.findElement(By.linkText("Leads")).click(); // Click on Leads
		driver.findElement(By.linkText("Create Lead")).click(); // Click on Create lead
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Encora"); // Providing Company name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Boopathi"); // Providing Firstname
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Varma"); // Providing Lastname
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("marshall"); // Providing Local name
		driver.findElement(By.name("departmentName")).sendKeys("civil"); // Providing Department
		driver.findElement(By.name("description")).sendKeys(
				"This is to test my" + "automation skill and to know my level of understanding in the learnt concepts"); // Providing
																															// Description
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("boopathimarshall@gmail.com"); // Providing
																											// Email.

		WebElement elemState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")); // Drop down web
																										// element

		Select select = new Select(elemState); // Object for select
		select.selectByVisibleText("New York"); // Selecting New york
		driver.findElement(By.name("submitButton")).click(); // Click on Submit
		
		driver.findElement(By.linkText("Edit")).click(); // Clicking Edit
		driver.findElement(By.id("updateLeadForm_description")).clear(); //Clearing the Description
		driver.findElement(By.name("importantNote")).sendKeys("This is important Note !!"); //Adding inportant note
		driver.findElement(By.name("submitButton")).click();// Clicking Submit
		String title = driver.getTitle();
		System.out.println(title); // Printing Title
		
		
		
	}


}
