package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonElementsUtils.CommonElement;

public class MealSelection extends CommonElement
{
WebDriver driver;
By mealcontinue = By.xpath("//button[contains(text(),'Continue')]");
public MealSelection(WebDriver driver)
{
	this.driver=driver;
}
public void MealMenu() throws InterruptedException
{
	/*WaitForElementToBeVisible(driver,By.xpath("//div[@class='overviewSummaryHeading']//span[contains(text(),'Your pincode')]"),2000);
	scrolloption(driver,driver.findElement(By.xpath("//div[@class='overviewSummaryHeading']//span[contains(text(),'Your pincode')]")));
	WaitForElementToBeClickable(driver,By.xpath("//input[@name='VEG']"),5000);
	clickOnElement(driver.findElement(By.xpath("//input[@name='VEG']")));	
	//clickOnButton(driver.findElement(By.xpath("//input[@name='VEG']")));*/
	//Thread.sleep(2000);
	//WaitForElementToBeClickable(driver,By.xpath("//button[contains(text(),'Continue')]"),9000);
	//Thread.sleep(3000);
	//ClickOnMealButton(driver.findElement(By.xpath("//button[contains(text(),'Continue')]")));
	WaitForElementToBeClickable(driver,mealcontinue,9000);
	Thread.sleep(3000);
	ClickOnMealButton(driver.findElement(mealcontinue));
}
}
