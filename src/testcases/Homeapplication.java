package testcases;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import objectrepository.Homepage;
import objectrepository.Findastudiopage;
import objectrepository.LocationSearchResult;

public class Homeapplication {
	
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Homepage hp = new Homepage(driver);
		driver.get("https://www.weightwatchers.com/us/");
		String t = hp.getHomePageTitle();
		// assert tile of homepage
		Assert.assertEquals(t, "WW (Weight Watchers): Weight Loss & Wellness Help");
		// click search studio link
		hp.clickFindAStudio().click();
		// assert the title on search result page
		Findastudiopage fs = new Findastudiopage(driver);
		String fmeetingTitle = driver.getTitle();
		fmeetingTitle.equals("Find WW Studios & Meetings Near You | WW USA");
		// entering zipcode and click
		fs.meetingSearch().sendKeys("10011");
		fs.meetingSearchBtn().click();
		
		// get list of search result title elements
		List<WebElement> frt = fs.getResultTitles();
		// get list of search result distance elements
		List<WebElement> frd = fs.getResultDistances();
		
		// print the first search results title & distance
		System.out.println("title: " + frt.get(0).getText());
		System.out.println("distance: " + frd.get(0).getText());
		
		// click the first alink
		frt.get(0).click();
		
		// get the current day of the week from local system time
		DayOfWeek currentDay = LocalDate.now().getDayOfWeek();
		String dayOfTheWeek = currentDay.getDisplayName(TextStyle.SHORT,Locale.getDefault());
		
		// print today's hours of operation
		LocationSearchResult lsr = new LocationSearchResult(driver);
		Map<String, List<WebElement>> hoursOperationMap = lsr.getHoursOperationListDay();
		System.out.println("today is: " + dayOfTheWeek);
		for (int x=0; x<hoursOperationMap.get(dayOfTheWeek.toUpperCase()).size(); x++){
			System.out.println(hoursOperationMap.get(dayOfTheWeek.toUpperCase()).get(x).getText());
		}
		
		HashMap<String, String> data = lsr.printMeetings("SUN");
		System.out.println(data.values());

		
	}

}
