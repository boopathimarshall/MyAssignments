package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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

		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[@name='firstName']")).sendKeys("Boopathi"); // passing
																														// name
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click(); // Click Find leads
		Thread.sleep(30000);
		System.out.println("button clicked");
		WebElement elemId = driver.findElement(By.xpath("//div [contains(@class,'col-partyId')]/a")); 
		String text = elemId.getText();
		System.out.println(text);
		driver.findElement(By.xpath("//div [contains(@class,'col-partyId')]/a")).click(); // Clicking first element
		String title2 = driver.getTitle();
		System.out.println(title2); // printing the title of the page

		driver.findElement(By.xpath("//a[text()='Edit']")).click(); // Clicking edit
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("Test_Leaf"); // new Company
																											// name
		driver.findElement(By.xpath("//input[@value='Update']")).click(); // Update clicked.

		WebElement elemUpdatedName = driver.findElement(By.xpath("//span[@id=\"viewLead_companyName_sp\"]"));
		String updatedName = elemUpdatedName.getText();
		System.out.println(updatedName);
		String[] splitName = updatedName.split(" ");
		if (splitName[0].equalsIgnoreCase("Test_Leaf")) // Verification of updated name
		{
			System.out.println("Changed name successfully appeared");
		} else
			System.out.println("Error in updated name");

		driver.close(); // Close the browser

	}

}
