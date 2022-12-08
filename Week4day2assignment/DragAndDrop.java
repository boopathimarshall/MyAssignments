package week4.day2assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://leafground.com/drag.xhtml;jsessionid=node01qey7o6oowt9dc09s8l9hc4bu437441.node0");

		// 1. Drag around
		Point location = driver.findElement(By.xpath("//span[text()='Drag and Drop']")).getLocation();
		int x = location.x;
		int y = location.y;
		System.out.println(x + " " + y);

		WebElement d1 = driver.findElement(By.xpath("//span[text()='Drag and Drop']"));
		Actions builder = new Actions(driver);

		builder.dragAndDropBy(d1, 520, 198).perform();
		System.out.println("Dragged to end");

		// 2. Drag to Target.

		WebElement d2 = driver.findElement(By.xpath("//p[text()='Drag to target']"));

		builder.moveToElement(d2).clickAndHold()
				.moveToElement(driver.findElement(By.xpath("//p[text()=\"Drop here\"]"))).release().build().perform();

		// 3.Draggable Columns

		WebElement qtyElem = driver.findElement(By.xpath("//span[text()='Quantity']"));
		Point location3 = qtyElem.getLocation();
		System.out.println(location3);
		WebElement nameElem = driver.findElement(By.xpath("//span[text()='Name']"));
		// builder.dragAndDropBy(nameElem, 751,530).perform();

		builder.moveToElement(nameElem).clickAndHold().moveToElement(qtyElem).release().perform();
		builder.moveToElement(qtyElem).clickAndHold().moveToElement(nameElem).release().perform();

		WebElement toastMessage = driver.findElement(By.xpath("//span[text()='Columns reordered']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastMessage));

		if (toastMessage.getText().contains("Columns reordered")) {
			System.out.println("toast message displayed");
		}

		else {
			System.out.println("not Displayed");
		}

		// 4.drag row contains 0 to top.

		WebElement d6 = driver.findElement(By.xpath("//tbody[@id='form:j_idt111_data']/tr/td[3][text()='0']"));
		WebElement d7 = driver.findElement(By.xpath("//tbody[@id='form:j_idt111_data']/tr"));

		builder.moveToElement(d6).clickAndHold().moveToElement(d7).release().perform();
		System.out.println("Moved");
	}

}
