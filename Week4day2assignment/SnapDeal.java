package week4.day2assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	static String[] s = new String[5];

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		//ch.addArguments("--headless");

		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");

		Actions builder = new Actions(driver);

		WebElement mensFashion = driver
				.findElement(By.xpath("//ul[@class='nav smallNav']/li/a/span[text()=\"Men's Fashion\"]"));
		builder.moveToElement(mensFashion).perform();
		WebElement sportShoes = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		sportShoes.click();

		String countOfShoes = driver.findElement(By.xpath("//h1[@class='category-name']/following-sibling::span"))
				.getText();
		System.out.println("Total count of shoes :" + countOfShoes);
		WebElement trainingShoes = driver
				.findElement(By.xpath("//ul[@id='js-255-nav']/li/a/div[text()='Training Shoes']"));
		trainingShoes.click();

		WebElement sortBy = driver.findElement(By.xpath("//div[@class='sort-drop clearfix']/div"));
		sortBy.click();

		WebElement lowToHigh = driver.findElement(By.xpath("//div[@class='sorting-sec animBounce']/ul[@class='sort-value']/li[@data-index='1']"));
		
		lowToHigh.click();
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.elementToBeClickable(lowToHigh));

		List<WebElement> price = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));

		List<Integer> li = new ArrayList<Integer>();
		
		Thread.sleep(2000);
		for (int j =1; j<price.size()-1;j++)
			
		{
			String domAttribute = driver.findElement(By.xpath("(//span[@class='lfloat product-price'])["+j+"]")).getDomAttribute("data-price");
			int intpr = Integer.parseInt(domAttribute);
			li.add(intpr);
		}
		

		
		Set<Integer> se = new TreeSet<Integer>(li);
		Set<Integer> se1 = new LinkedHashSet<Integer>(li);
		boolean isSetEquals = se.equals(se1);
		if(isSetEquals)
		{
			System.out.println("Shoes are listed in Low to High Price");
		}
		
		else
		{
			System.out.println("Shoes are NOT in Low to High Price order");
		}
		//System.out.println(li);
		//System.out.println(se);
		//System.out.println(se1);
		
		
		WebElement fromVal = driver.findElement(By.xpath("//input[@name='fromVal']"));
		fromVal.clear();
		fromVal.sendKeys("600");

		WebElement toVal = driver.findElement(By.xpath("//input[@name='toVal']"));
		toVal.clear();
		toVal.sendKeys("1200");

		WebElement goClick = driver.findElement(By.xpath("//div[contains(text(),'GO')]"));
		goClick.click();
		Thread.sleep(2000);
		WebElement navyColor = driver.findElement(By.xpath("//input[@id='Color_s-Navy']/following-sibling::label"));
		navyColor.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(navyColor));

		WebElement priceFilter = driver.findElement(By.xpath("//div[@class='navFiltersPill']/a"));

		String priceFilterText = priceFilter.getText();
		System.out.println(priceFilterText);

		Pattern compile = Pattern.compile("\\d+");
		Matcher match = compile.matcher(priceFilterText);
		int i = 0;
		while (match.find()) {

			String group = match.group();
			System.out.println(group);
			s[i] = group;
			i++;
		}

		WebElement colorFilter = driver.findElement(By.xpath("//div[@class='navFiltersPill'][text()='Color: ']/a"));
		String colorFilterText = colorFilter.getText();
		System.out.println(colorFilterText);

		if (colorFilterText.equals("Navy") && s[0].equals("600") && s[1].equals("1200")) {
			System.out.println("Filter is correct");
		} else {
			System.out.println("Please check filter");
		}

		WebElement shoePic = driver.findElement(By.xpath("//div[@class='product-tuple-image ']"));

		builder.moveToElement(shoePic).perform();

		WebElement quickView = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));

		quickView.click();

		WebElement mrp = driver.findElement(By.xpath("//div/span[@class='payBlkBig']"));
		String mrptext = mrp.getText();
		System.out.println(mrptext);

		WebElement percentageDes = driver.findElement(By.xpath("//div/span[@class='percent-desc ']"));
		String percentageDestext = percentageDes.getText();
		System.out.println(percentageDestext);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/shoe.png");
		FileUtils.copyFile(src, desc);

		WebElement xbutton = driver.findElement(By.xpath("//div[@class='close close1 marR10']"));
		xbutton.click();

		try {
		driver.close();

		}
		
		catch(Exception e)
		{
			System.out.println("Issue in closing the browser");
		}
		finally {
			System.out.println("Closed the browser");
		}
	}

}
