package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CommonElementsUtils.CommonElement;
import CommonElementsUtils.CommonLogics;

public class SeatBookingPage extends CommonElement
{
	WebDriver driver;
	public SeatBookingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void SeatAllocation() throws InterruptedException
	{
		/*WaitForElementToBeClickable(driver,By.xpath("//p[@class='seatBookingOverlayCta']//button"),8000);
		clickOnElement(driver.findElement(By.xpath("//p[@class='seatBookingOverlayCta']//button")));	
		*/
		/*CommonLogics c = new CommonLogics();
		try
		{
		WaitForElementToBeClickable(driver,By.xpath("//p[@class='seatBookingOverlayCta']//button"),8000);
		c.ClickIfElementExists(driver,"//p[@class='seatBookingOverlayCta']//button");
		}
		catch(Exception e)
		{
			//to do
			for(int i=0;i<2;i++)
			{
			List<WebElement> Allseats=driver.findElements(By.xpath("//div[@class='seatCol']//div[contains(@class,'seatBlock')]")); 
			
			for(WebElement eachseat:Allseats)
			{
				// String eachseatvalue=driver.findElement(By.xpath("//div[@class='seatNotAvailable']|//div[contains(@class,'seatBlock')]")).getAttribute("class");
				// if(eachseatvalue.contains("seatBlock"))
				// {
					scrolloption(driver,driver.findElement(By.xpath("//div[text()='5']")));
					
					eachseat.click();
					break;
				}
			}
			System.out.println("The seatBookingOverlayCta popup is not appeard");
		}*/
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		WebElement statedbclick = driver.findElement(By.xpath("//div[@class='flightSeatMatrix']")); 
		act.doubleClick(statedbclick).perform();
		scrolloption(driver,driver.findElement(By.xpath("//ul[@class='legendWrap']")));
		WaitForElementToBeClickable(driver,By.xpath("//button[contains(text(),'Continue')]"),7000);
		clickOnButton(driver.findElement(By.xpath("//button[contains(text(),'Continue')]")));
		
		
		
		
		
		/*WaitForElementToBeVisible(driver,By.xpath("//ul[@class='legendWrap']"),3000);
		scrolloption(driver,driver.findElement(By.xpath("//ul[@class='legendWrap']")));
		WaitForElementToBeClickable(driver,By.xpath("//button[contains(text(),'Continue')]"),3000);
		clickOnButton(driver.findElement(By.xpath("//button[contains(text(),'Continue')]")));*/
	}
}
