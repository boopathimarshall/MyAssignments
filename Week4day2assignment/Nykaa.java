package week4.day2assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		//ch.addArguments("--headless");

		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.nykaa.com/");
		Actions builder = new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brands).perform();

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
		searchBox.sendKeys("L'Oreal Paris");
		System.out.println("Provided values");

		WebElement searchedValues = driver.findElement(By.xpath("//div[@id='list_topbrands']/following::div/a[text()=\"L'Oreal Paris\"]"));
        searchedValues.click();
        
        
		String lorealParis = driver.getTitle();
		if (lorealParis.contains("L'Oreal Paris")) {
			System.out.println("Title is correct");
		}

		WebElement sortByDropdown = driver.findElement(By.xpath("//span[text()='Sort By : popularity']"));
		sortByDropdown.click();
		WebElement custoRate = driver.findElement(By.xpath("//span[text()='customer top rated']"));
		custoRate.click();
		System.out.println("custoRate");
		//WebElement categoryBox = driver.findElement(By.xpath("//div[@id='first-filter']//span[text()='Category']"));
		//categoryBox.click();
		//System.out.println("categoryBox");
		
		driver.findElement(By.xpath("//div[@class='filter-open css-1kwl9pj']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class=' css-b5p5ep']/span[text()='Hair']")).click();
		driver.findElement(By.xpath("//div[@class=' css-b5p5ep']/span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//label[@class=\"control control-checkbox\"]//span[text()='Shampoo']"));
		Thread.sleep(3000);
		WebElement shampoo1 = driver.findElement(By.xpath("//span[text()='Shampoo']"));
		shampoo1.click();
		
		
		Thread.sleep(3000);
		
		

		String filterText = driver.findElement(By.xpath("//span[text()='Shampoo']")).getText();
		System.out.println("Filter Value :"+filterText);

		WebElement concernBox = driver.findElement(By.xpath("//span[text()='Concern']"));
		concernBox.click();
		WebElement colorprotection = driver.findElement(By.xpath("//span[text()='Color Protection']"));
		colorprotection.click();
		String filterText2 = driver.findElement(By.xpath("//div/span[text()='Color Protection']")).getText();
		System.out.println("Filter Value :"+filterText2);
		WebElement colorProtectShampoo = driver
				.findElement(By.xpath("//a/div[@class='css-1rd7vky']/div[contains(text(),'Colour Protect Shampoo')]"));
		
		WebElement clrProtShapmoo = driver.findElement(By.xpath("//div[@class='css-xrzmfa'][text()=\"L'Oreal Paris Colour Protect Shampoo\"]"));
		clrProtShapmoo.click();
		
		Set<String> win = driver.getWindowHandles();
		List<String> li  = new ArrayList<String>(win);
		
		driver.switchTo().window(li.get(1));
		
		Select sl = new Select(driver.findElement(By.xpath("//Select[@class='css-2t5nwu']")));
		sl.selectByVisibleText("175ml");
	
		System.out.println("175ml selected");
		
		String MRP = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
	   String MRP1 = MRP.replace("₹", "");
		System.err.println(MRP1);
	   
	
	driver.findElement(By.xpath("//button/span[text()='Add to Bag']")).click();
	driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
	
	driver.switchTo().frame(0);
	
	WebElement grandTotal = driver.findElement(By.xpath("//span[text()='Grand Total']/parent::div/preceding-sibling::div/span"));
	System.out.println(grandTotal.getText());
	
	
	driver.findElement(By.xpath("//span[text()='Proceed']")).click();
	
	driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
	
	driver.findElement(By.xpath("//span[@class='css-175whwo ehes2bo0']")).click();
	String priceAmount = driver.findElement(By.xpath("//p[text()='Price Details']/parent::div/following-sibling::p")).getText();
	
	String priceAmount1 = priceAmount.replace("₹", "");
	System.out.println(priceAmount1);
	
	if(MRP1.equals(priceAmount1))
	{
		System.out.println("Price Amount is Same");
	}
	else
	{
		System.out.println("Price Amount is different");
	}
	
	
	}
 
}
