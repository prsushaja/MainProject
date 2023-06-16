package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CommonElementsUtils.CommonElement;

public class Payment_Details extends CommonElement
{
WebDriver driver;
public Payment_Details(WebDriver driver)
{
	this.driver=driver;
}
//6521530107958299
public void Creditcard_payment(String Credit_cardno,String holder_name,String Expdate,String Expyear,String cvv)
{
	WaitForElementToBeVisible(driver,By.xpath("//ul//span[contains(text(),'Credit')]"),2000);	
	clickOnElement(driver.findElement(By.xpath("//ul//span[contains(text(),'Credit')]")));
	WebElement creditcard=driver.findElement(By.xpath("//input[@id='cardNumber']"));
	creditcard.sendKeys(Credit_cardno);
	WebElement Holdername=driver.findElement(By.xpath("//input[@id='nameOnCard']"));
	Holdername.sendKeys(holder_name);
	WaitForElementToBeVisible(driver,By.xpath("//div//p[contains(text(),'Month')]"),2000);	
	clickOnElement(driver.findElement(By.xpath("//div//p[contains(text(),'Month')]")));
	SelectAllValueFromList(driver,By.xpath("//div[@class='month__select__wrap']//li"),Expdate);
	WaitForElementToBeVisible(driver,By.xpath("//div//p[contains(text(),'Year')]"),2000);	
	clickOnElement(driver.findElement(By.xpath("//div//p[contains(text(),'Year')]")));
	SelectAllValueFromList(driver,By.xpath("//div[@class='year__select__wrap']//li"),Expyear);
	WebElement cv_v=driver.findElement(By.xpath("//input[@id='cardCvv']"));
	cv_v.sendKeys(cvv);
}
}
