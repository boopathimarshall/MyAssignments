package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentFour {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://leafground.com/select.xhtml;jsessionid=node01726s9tfcenpf1bsn9pis5zxhx417425.node0");

		WebElement elemFirstDropdown = driver.findElement(By.className("ui-selectonemenu"));

		// 1 Tool selected
		Select select = new Select(elemFirstDropdown);
		select.selectByIndex(1);
		System.out.println("Tool selected");

		// 2 .Country Selection
		driver.findElement(By.id("j_idt87:country_label")).click();
		driver.findElement(By.id("j_idt87:country_3")).click();
		System.out.println("Country selected");

		Thread.sleep(3000);

		// 3. City Selection
		driver.findElement(By.id("j_idt87:city_label")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_idt87:city_2")).click();

		System.out.println("City selected");

		// 4. Select course Not covered
		// driver.findElement(By.className("ui-button-text")).click();

		// 5 . Language Selected
		driver.findElement(By.id("j_idt87:lang_label")).click();
		driver.findElement(By.id("j_idt87:lang_2")).click();

		System.out.println("language selected");
		Thread.sleep(3000);
		// 6. Two Selected
		driver.findElement(By.id("j_idt87:value_label")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("j_idt87:value_1")).click();

	}

}
