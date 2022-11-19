package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		// Setup driver
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");

		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text() ='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9999999999");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(30000);
		System.out.println("button clicked");
		WebElement elemId = driver.findElement(By.xpath("//div [contains(@class,'col-partyId')]/a"));
		String text = elemId.getText();
		System.out.println(text);
		driver.findElement(By.xpath("//div [@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[@name='id']")).sendKeys(text);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String verifyText = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		
		if(verifyText.equals("No records to display"))
		{
			System.out.println("confirms the successful deletion");
		}
	 driver.close(); // Close the browser
		
		
		
		
		
		
		
		
		

	}

}
