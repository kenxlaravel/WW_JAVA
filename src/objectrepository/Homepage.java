package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
	
	WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}
	
	By alinkFindAStudio = By.linkText("Find a Studio");
	
	public WebElement clickFindAStudio() {
		return driver.findElement(alinkFindAStudio);
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
}
