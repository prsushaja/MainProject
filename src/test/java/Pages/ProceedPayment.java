package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonElementsUtils.CommonElement;

public class ProceedPayment extends CommonElement
{
WebDriver driver;
public ProceedPayment(WebDriver driver)
{
	this.driver=driver;
}
public void Proceed_Pay()
{
	WaitForElementToBeVisible(driver,By.xpath("//div[@id='ACKNOWLEDGE_SECTION']"),7000);
	scrolloption(driver,driver.findElement(By.xpath("//div[@id='ACKNOWLEDGE_SECTION']")));
	WaitForElementToBeClickable(driver,By.xpath("//div[@id='ACKNOWLEDGE_SECTION']//button[contains(text(),'Proceed')]"),7000);
	clickOnButton(driver.findElement(By.xpath("//div[@id='ACKNOWLEDGE_SECTION']//button[contains(text(),'Proceed')]")));

}
}
