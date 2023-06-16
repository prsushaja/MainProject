package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonElementsUtils.CommonElement;

public class MealSelection extends CommonElement
{
WebDriver driver;
public MealSelection(WebDriver driver)
{
	this.driver=driver;
}
public void mealmenu()
{
	/*WaitForElementToBeVisible(driver,By.xpath("//div[@class='overviewSummaryHeading']//span[contains(text(),'Your pincode')]"),2000);
	scrolloption(driver,driver.findElement(By.xpath("//div[@class='overviewSummaryHeading']//span[contains(text(),'Your pincode')]")));
	WaitForElementToBeClickable(driver,By.xpath("//input[@name='VEG']"),5000);
	clickOnElement(driver.findElement(By.xpath("//input[@name='VEG']")));	
	//clickOnButton(driver.findElement(By.xpath("//input[@name='VEG']")));*/
	WaitForElementToBeVisible(driver,By.xpath("//button[contains(text(),'Continue')]"),5000);
	clickOnButton(driver.findElement(By.xpath("//button[contains(text(),'Continue')]")));

}
}
