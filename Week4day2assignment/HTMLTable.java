package week4.day2assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTMLTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		// ch.addArguments("--headless");

		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 2. https://html.com/tags/table/

		driver.get("https://html.com/tags/table/");

		List<WebElement> numberOfRows = driver.findElements(By.xpath("//table//tr"));
		List<WebElement> numberOfColumns = driver.findElements(By.xpath("//table//th"));

		System.out.println("Total number of Rows in the page : " + numberOfRows.size());
		System.out.println("Total number of columns in the page:  " + numberOfColumns.size());

		List<WebElement> rows = driver
				.findElements(By.xpath(" //caption[contains(text(),'Libraries')]/parent::table//tr"));

		List<WebElement> col = driver
				.findElements(By.xpath(" //caption[contains(text(),'Libraries')]/parent::table//tr[2]/td"));

		System.out.println();

		for (int i = 1; i < rows.size() - 1; i++) {
			for (int j = 1; j <= col.size(); j++) {
				String text = driver
						.findElement(By.xpath(
								" //caption[contains(text(),'Libraries')]/parent::table//tr[" + i + "]/td[" + j + "]"))
						.getText();

				System.out.print(text);
				System.out.print("   ");
			}
			System.out.println();
		}

	}

}
