package GreenCartProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;


public class TC2_AddToCartWithMethod {
	public static void main(String[] args) throws InterruptedException {
//		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		green kart website 
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] requiredVeg = {"Beetroot", "Beans", "Corn"};
		
		AddItemMethod addItemsObject = new AddItemMethod();
		addItemsObject.addItems(driver, requiredVeg);

		System.out.println("test case passed");
	}
}
