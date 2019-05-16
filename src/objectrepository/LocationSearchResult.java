package objectrepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationSearchResult {
		
		WebDriver driver;
			
		public LocationSearchResult(WebDriver driver) {
				this.driver = driver;
			}
		By dayLabels = By.className("schedule-detailed-day-label");
		By detailedDayMeetingsTime = By.className("schedule-detailed-day-meetings-item-time");
		By detailedDayMeetingsLeader = By.className("schedule-detailed-day-meetings-item-leader");
		
		By dayOfTheWeek = By.xpath("//div[@class=\"hours-list-item-day\"]");
		
		public HashMap<String, String> printMeetings(String day) {
		
			HashMap<String, HashMap<String, String>> outterDays = new HashMap<String, HashMap<String, String>>();
			HashMap<String, String> innerTimeLeads = new HashMap<String, String>();
			
			// get all days of the week elements
			List<WebElement> getDays = driver.findElements(dayLabels);
		
			for (int x=0; x<getDays.size();x++) {
				
				day = getDays.get(x).getText();
				
				WebElement meetingItem = getDays.get(x).findElement(By.xpath("./following-sibling::div"));
				List<WebElement> items = meetingItem.findElements(By.xpath("./child::div"));
				
				for (int i=0; i<items.size(); i++) {
					String time = items.get(i).findElement(detailedDayMeetingsTime).getText();
					String lead = items.get(i).findElement(detailedDayMeetingsLeader).getText();
					innerTimeLeads.put(time,  lead);
				}
				outterDays.put(day, innerTimeLeads);
			}
			
			HashMap<String, String> value = ((HashMap<String, String>) outterDays.get(day.toUpperCase()));
			
			return value;
		}
		
		
		public Map<String, List<WebElement>> getHoursOperationListDay(){
			List<WebElement> hoursListDays = driver.findElements(dayOfTheWeek);
			Map<String, List<WebElement>> hoursOperationData = new HashMap<String, List<WebElement>>();
			
			for (int x=0; x<hoursListDays.size(); x++) {
				WebElement allHours = hoursListDays.get(x).findElement(By.xpath("./following-sibling::div"));
				List<WebElement> hourItems = allHours.findElements(By.xpath("./child::div"));
				hoursOperationData.put(hoursListDays.get(x).getText(), hourItems);				
			}
			return hoursOperationData;

	}

}