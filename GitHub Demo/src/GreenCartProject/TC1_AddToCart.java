package GreenCartProject;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;


public class TC1_AddToCart {
	public static void main(String[] args) throws InterruptedException {
//		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		green kart website 
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		List<WebElement> vegetables = driver.findElements(By.className("product-name"));
		List<WebElement> addToCartButton = driver.findElements(By.xpath("//div[@class='product-action']//button"));
		String[] requiredVeg = {"Beetroot", "Beans", "Corn"};
		List<String> requiredVegList = Arrays.asList(requiredVeg);
		int loopRunning = 0;
		
		for(int i=0; i<vegetables.size(); i++) {
			String[] vegName = vegetables.get(i).getText().split("-");
			String formatedVegName = vegName[0].trim();	
			
			if(requiredVegList.contains(formatedVegName)) {	
				addToCartButton.get(i).click();	
				loopRunning++;
				
//				if(loopRunning == requiredVeg.length)
				if(loopRunning == requiredVegList.size()) {
					break;
				}
			}	
		}
		System.out.println("test case passed");
//		driver.close();
	}
}
