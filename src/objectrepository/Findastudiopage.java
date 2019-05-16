package objectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Findastudiopage {
	
WebDriver driver;
	
	public Findastudiopage(WebDriver driver) {
		this.driver = driver;
	}
	
	By meetingSearchInput = By.id("meetingSearch");
	By meetingSearchButton = By.xpath("//*[@class=\"input-item input-group arrow-btn\"]/button");
	By resultTitles = By.xpath("//div[@class=\"location__name\"]/span[1]");
	By resultDistances = By.xpath("//div[@class=\"location__distance\"]");
	By resultTitle = By.xpath("//div[@class=\"location__name\"]/span");
	
	public WebElement meetingSearch() {
		return driver.findElement(meetingSearchInput);
	}
	
	public WebElement meetingSearchBtn() {
		return driver.findElement(meetingSearchButton);
	}
	
	public List<WebElement> getResultTitles() {
		return driver.findElements(resultTitles);
	}
	
	public WebElement getTitleElement() {
		return driver.findElement(resultTitle);
	}
	
	public List<WebElement> getResultDistances() {
		return driver.findElements(resultDistances);
	}

}
