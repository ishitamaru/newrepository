package GreenCartProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC3_CartPage {
	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

//		Implicit wait
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		// creating object for explicit wait
		WebDriverWait e = new WebDriverWait(driver, 5);

//		green kart website 
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		AddItemMethod addItemsObject = new AddItemMethod();

		String[] requiredVeg = { "Beetroot", "Beans", "Corn" };
		addItemsObject.addItems(driver, requiredVeg);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();

		e.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		System.out.println("Applied discount in % is " + driver.findElement(By.cssSelector("span.discountPerc")).getText());
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();

		System.out.println("test case passed");
	}
}
