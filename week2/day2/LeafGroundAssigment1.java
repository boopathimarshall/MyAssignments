package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundAssigment1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("disable-notifications");

		ChromeDriver driver = new ChromeDriver(ch);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://leafground.com/input.xhtml;jsessionid=node01j540a7o52can13p945ps0fry4418339.node0");

		// 0. type your name and choose third option
		// writing this first as we need to refresh the page again if written in last

		driver.findElement(By.xpath(
				"//h5[contains(text(),'Type your name and choose the third option')]/following-sibling::div/ul/li/input"))
				.sendKeys("boopathi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li[contains(@data-item-value,'boopathi')])[3]")).click();
		// 1 . Typing my name

		driver.findElement(By.xpath("//h5[text()='Type your name']/following-sibling::div/div/input"))
				.sendKeys("Boopathi");
		// 2. Appended Country to the city
		driver.findElement(By.xpath("//input[@value=\"Chennai\"]")).sendKeys(" India ");

		// 3. to verify is disabled
		WebElement disableElem = driver.findElement(
				By.xpath("//h5[text()='Verify if text box is disabled']/following-sibling::div/div/input"));
		boolean enabled = disableElem.isEnabled();
		System.out.println("Is text box enabled ?" + enabled);

		// 4. Clearing the text
		driver.findElement(By.xpath("//input[@value='Can you clear me, please?']")).clear();

		// 5. Retriving the text
		String attribute = driver
				.findElement(By.xpath("//h5[text()='Retrieve the typed text.']/following-sibling::div/div/input"))
				.getAttribute("value");
		System.out.println(attribute);
		// 6. Type email and Tab off
		driver.findElement(By.xpath("//h5[contains(text(),'Type email and Tab')]/following-sibling::div//input"))
				.sendKeys("boopathimarshall@gmail.com", Keys.TAB);

		// 7. Type your self

		driver.findElement(By.xpath("//h5[text()='Type about yourself']/following-sibling::div//textarea"))
				.sendKeys("This is the paragraph text sending from eclipse");

		// 8. Text editer
		driver.findElement(By.xpath("//span[@class=\"ql-color ql-picker ql-color-picker\"]/span")).click();

		driver.findElement(By.xpath("//span[@data-value=\"#0047b2\"]")).click();
		driver.findElement(By.xpath("//button[@class=\"ql-bold\"]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'ui-editor-tool')]/following-sibling::div/div/p"))
				.sendKeys("Test text in blue bold");

		// 9 . enter and capture the error message
		driver.findElement(By.xpath("//h5[contains(text(),'Just Press Enter')]/following-sibling::div//input"))
				.sendKeys(Keys.ENTER);
		System.out.println(
				"Error occured is :" + driver.findElement(By.xpath("//span[text()='Age is mandatory']")).getText());

		// 10.confirmation of position change
		WebElement userNameElem = driver.findElement(
				By.xpath("//input[contains(@name,'float-input')]/following-sibling::label[text()='Username']"));
		System.out.println("Position of Username" + userNameElem.getLocation());

		WebElement userNameElem2 = driver.findElement(By.xpath("//input[contains(@name,'float-input')]"));
		System.out.println("After click" + userNameElem2.getLocation());

		// 11. Type you dob and confirm

		WebElement dobElem = driver
				.findElement(By.xpath("//h5[contains(text(),'Type your DOB')]/following::span/input"));
		dobElem.sendKeys("10/28/1995");
		dobElem.click();
		WebElement dobDD = driver.findElement(By.xpath("//a[@class=' ui-state-default ui-state-active']"));
		String attribute3 = dobDD.getAttribute("class");
		boolean contains2 = attribute3.contains("ui-state-active");
		if (contains2) {
			System.out.println(" your date of birth is selected as expected");
		}

		else {
			System.out.println("Date is  Not selected");
		}

		// Type number and spin
		driver.findElement(By.xpath("//h5[contains(text(),'Type number')]/following-sibling::span/input"))
				.sendKeys("20");

		driver.findElement(By.xpath(
				"//h5[contains(text(),'Type number')]/following-sibling::span/a[contains(@class,'spinner-down')]"))
				.click();
		String newVal = driver
				.findElement(By.xpath("//h5[contains(text(),'Type number')]/following-sibling::span/input"))
				.getAttribute("aria-valuenow");
		if (newVal.equals("19")) {
			System.out.println("value changed one down :" + newVal);
		}

		// 12. Slider the number
		driver.findElement(By.xpath("//h5[contains(text(),'Type random number')]/following-sibling::input"))
				.sendKeys("20");
		Thread.sleep(3000);
		String attribute2 = driver
				.findElement(By
						.xpath("//h5[contains(text(),'Type random number')]/following-sibling::input/following::span"))
				.getAttribute("style");

		String[] atrNum = attribute2.split("\\s");

		boolean contains = atrNum[1].contains("20");

		if (contains) {
			System.out.println("Slider moved correctly");
		} else {
			System.out.println("slider position is not accurate");
		}

		// 13.Keyboard display
		driver.findElement(By.xpath("//h5[contains(text(),'Keyboard appears')]/following-sibling::input")).click();
		boolean kbdisplayed = driver.findElement(By.xpath("//div[contains(@class,'shadow keypad-popup')]"))
				.isDisplayed();
		if (kbdisplayed) {
			System.out.println("keyboard displayed");
		} else {
			System.out.println("keyboard NOT displayed");
		}

		driver.close();

	}
}
