package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundAssignment2 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("disable-notifications");

		ChromeDriver driver = new ChromeDriver(ch);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://leafground.com/checkbox.xhtml");
		
		/*// 1. Basiccheck box
		driver.findElement(By.xpath("//span[text()='Basic']/preceding-sibling::div/following-sibling::div")).click();
		
		//2 ajax
		driver.findElement(By.xpath("//span[text()='Ajax']/preceding-sibling::div/following-sibling::div")).click();

		//3. Click others
		driver.findElement(By.xpath("//label[text()='Others']/preceding-sibling::div/div[contains(@class,'chkbox-box')]")).click();
		
		// 4. Try state
		driver.findElement(By.xpath("//h5[text()='Tri State Checkbox']/parent::div//div[contains(@class,'ui-state-default')]")).click();
		
		System.out.println(driver.findElement(By.xpath("//span[text()='State has been changed.']")).getText());
		
		System.out.println(driver.findElement(By.xpath("//p[text()='State = 1']")).getText());
		
		
		//5. toggle
		boolean isselected = driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).isSelected();
		System.out.println("Before "+isselected);
		WebElement elem1 = driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']"));
		elem1.click();
		String classval = driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']/parent::div")).getAttribute("class");
		System.out.println(classval);
		
		if(classval.contains("checked"))
		{
			
		System.out.println("Checked");
		}
		else
			System.out.println("not checked"); */
		
		
		//6. disabled check box
		boolean enabled = driver.findElement(By.xpath("(//span[text()='Disabled']/preceding-sibling::div) [2]")).isEnabled();
		if(!enabled)
		{
			System.out.println("IT is disabled");
		}
		else 
			System.out.println("IT is enabled");
		
		
		//7 multiple
		driver.findElement(By.xpath("//h5[text()='Select Multiple']/following-sibling::div//ul")).click();
		driver.findElement(By.xpath("//label[text()='Rome']/preceding-sibling::div/div[contains(@class,'ui-state-default')]")).click();
		driver.findElement((By.xpath("//label[text()='Paris']/preceding-sibling::div/div[contains(@class,'ui-state-default')]"))).click();
		driver.findElement(By.xpath("//div[@class =\"ui-selectcheckboxmenu-filter-container\"]/input")).clear();
		driver.findElement(By.xpath("//div[@class =\"ui-selectcheckboxmenu-filter-container\"]/input")).sendKeys("Lon");
		driver.findElement(By.xpath("//div[@class ='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")).click();
		System.out.println("clicked");
	}
	
	

	
	

}
