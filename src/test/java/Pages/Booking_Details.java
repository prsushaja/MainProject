package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonElementsUtils.CommonElement;
public class Booking_Details extends CommonElement
{
	WebDriver driver;
	
	public Booking_Details(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void SelectRadiobutton(String radvalue)
	{
		
		SelectAllValueFromList(driver,By.xpath("(//div[@class='insBottomSection']//p[@class='radioboxTitle'])"),radvalue);
		
	}
	public String Getradiovalidation()
	{
		return GetTextOfelement(driver.findElement(By.xpath("(//div[@class='insBottomSection']//p[@class='radioboxTitle'])")));
	}
	
	
}
