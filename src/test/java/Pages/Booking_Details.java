package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonElementsUtils.CommonElement;
public class Booking_Details extends CommonElement
{
	WebDriver driver;
	
	By selectRadioButton = By.xpath("(//div[@class='insBottomSection']//p[@class='radioboxTitle'])");
	
	public Booking_Details(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void SelectInsuranceMode(String radvalue) throws InterruptedException
	{
		Thread.sleep(5000);
		
		SelectAllValueFromList(driver,selectRadioButton,radvalue);
		
	}
	public String Getradiovalidation()
	{
		return GetTextOfelement(driver.findElement(selectRadioButton));
	}
	
	
}
