package GreenCartProject;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddItemMethod {

public void addItems(WebDriver driver, String[] requiredVeg) {
	List<WebElement> vegetables = driver.findElements(By.className("product-name"));
	List<WebElement> addToCartButton = driver.findElements(By.xpath("//div[@class='product-action']//button"));
	List<String> requiredVegList = Arrays.asList(requiredVeg);
	int loopRunning = 0;
	
	for(int i=0; i<vegetables.size(); i++) {
		String[] vegName = vegetables.get(i).getText().split("-");
		String formatedVegName = vegName[0].trim();	
		
		if(requiredVegList.contains(formatedVegName)) {	
			addToCartButton.get(i).click();	
			loopRunning++;
			
//			if(loopRunning == requiredVeg.length)
			if(loopRunning == requiredVegList.size()) {
				break;
				}
			}	
		}
	}
}