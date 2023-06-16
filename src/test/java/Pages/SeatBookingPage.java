package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonElementsUtils.CommonElement;
import CommonElementsUtils.CommonLogics;

public class SeatBookingPage extends CommonElement
{
	WebDriver driver;
	public SeatBookingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void seatalloc() throws InterruptedException
	{
		/*WaitForElementToBeClickable(driver,By.xpath("//p[@class='seatBookingOverlayCta']//button"),8000);
		clickOnElement(driver.findElement(By.xpath("//p[@class='seatBookingOverlayCta']//button")));	
		*/
		CommonLogics c = new CommonLogics();
		WaitForElementToBeClickable(driver,By.xpath("//p[@class='seatBookingOverlayCta']//button"),8000);
		c.ClickIfElementExists(driver,"//p[@class='seatBookingOverlayCta']//button");
		/*WaitForElementToBeVisible(driver,By.xpath("//ul[@class='legendWrap']"),3000);
		scrolloption(driver,driver.findElement(By.xpath("//ul[@class='legendWrap']")));
		WaitForElementToBeClickable(driver,By.xpath("//button[contains(text(),'Continue')]"),3000);
		clickOnButton(driver.findElement(By.xpath("//button[contains(text(),'Continue')]")));*/
	}
}
