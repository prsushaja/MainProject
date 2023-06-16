package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import CommonElementsUtils.CommonElement;

public class TravellerInput extends CommonElement
{
WebDriver driver;
	
	public TravellerInput(WebDriver driver)
	{
		this.driver=driver;
	}
	public void Traveller_details(String Firstname,String Lastname) throws InterruptedException
	{
		Thread.sleep(1000);
		WaitForElementToBeVisible(driver,By.xpath("//div[@id='wrapper_ADULT']//button[@class='addTravellerBtn']"),2000);
		scrolloption(driver,driver.findElement(By.xpath("//div[@class='travellerWrapper']//h2")));
		clickOnButton(driver.findElement(By.xpath("(//div[@id='wrapper_ADULT']//button[@class='addTravellerBtn'])")));
		driver.findElement(By.xpath("//div[@id='wrapper_ADULT']//input[contains(@placeholder,'First')]")).sendKeys(Firstname);
		WaitForElementToBeVisible(driver,By.xpath("//div[@id='wrapper_ADULT']//input[contains(@placeholder,'Last')]"),2000);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='wrapper_ADULT']//input[contains(@placeholder,'Last')]")).sendKeys(Lastname);
		WaitForElementToBeVisible(driver,By.xpath("//div[@id='wrapper_ADULT']//label[@tabindex='0']"),2000);
		driver.findElement(By.xpath("//div[@id='wrapper_ADULT']//label[@tabindex='0']")).click();
	}
	public void Travellerchild_details(String Firstname1,String Lastname1)
	{
		WaitForElementToBeVisible(driver,By.xpath("(//div[@id='wrapper_CHILD']//button[@class='addTravellerBtn'])"),2000);
		clickOnButton(driver.findElement(By.xpath("(//div[@id='wrapper_CHILD']//button[@class='addTravellerBtn'])")));
		driver.findElement(By.xpath("//div[@id='wrapper_CHILD']//input[contains(@placeholder,'First')]")).sendKeys(Firstname1);
		driver.findElement(By.xpath("//div[@id='wrapper_CHILD']//input[contains(@placeholder,'Last')]")).sendKeys(Lastname1);
		driver.findElement(By.xpath("//div[@id='wrapper_CHILD']//label[@tabindex='1']")).click();
	}
	public void Travellerinfant_details(String Firstname2,String Lastname2)
	{
		WaitForElementToBeVisible(driver,By.xpath("(//div[@id='wrapper_INFANT']//button[@class='addTravellerBtn'])"),2000);
		clickOnButton(driver.findElement(By.xpath("(//div[@id='wrapper_INFANT']//button[@class='addTravellerBtn'])")));
		driver.findElement(By.xpath("//div[@id='wrapper_INFANT']//input[contains(@placeholder,'First')]")).sendKeys(Firstname2);
		driver.findElement(By.xpath("//div[@id='wrapper_INFANT']//input[contains(@placeholder,'Last')]")).sendKeys(Lastname2);
		driver.findElement(By.xpath("//div[@id='wrapper_INFANT']//label[@tabindex='0']")).click();
	}
	public void InfantDob_details()
	{
		WaitForElementToBeVisible(driver,By.xpath("//div[contains(text(),'Date')]"),2000);	
		clickOnElement(driver.findElement(By.xpath("//div[contains(text(),'Date')][//div[contains(@class,'dropdown__indicators')]]")));
		Actions mouseaction= new Actions(driver);
		mouseaction.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		WaitForElementToBeVisible(driver,By.xpath("//div[contains(text(),'Month')]"),2000);	
		clickOnElement(driver.findElement(By.xpath("//div[contains(text(),'Month')][//div[contains(@class,'dropdown__indicators')]]")));
		mouseaction.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		WaitForElementToBeVisible(driver,By.xpath("//div[contains(text(),'Year')]"),2000);	
		clickOnElement(driver.findElement(By.xpath("//div[contains(text(),'Year')][//div[contains(@class,'dropdown__indicators')]]")));
		mouseaction.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		//clickOnElement(driver.findElement(By.xpath("//div[contains(text(),'India')]")));
		//mouseaction.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
	}
	public void bookinginfo(String Mbnum,String email,String Pincode,String Statename,String address)
	{
		WaitForElementToBeVisible(driver,By.xpath("//input[contains(@placeholder,'Mobile')]"),2000);	
		WebElement mobileno=driver.findElement(By.xpath("//input[contains(@placeholder,'Mobile')]"));
		mobileno.sendKeys(Mbnum);
		WebElement Emailinfo=driver.findElement(By.xpath("//input[contains(@placeholder,'Email')]"));
		Emailinfo.sendKeys(email);
		scrolloption(driver,driver.findElement(By.xpath("//div[@id='BILLING_ADDRESS']")));
		WebElement pincode=driver.findElement(By.xpath("//input[@id='pincode_gst_info']"));
		pincode.clear();
		pincode.sendKeys(Pincode);
		Actions act = new Actions(driver);
		WaitForElementToBeVisible(driver,By.xpath("//div[@class='dropdownFieldWpr__inputWpr']"),2000);	
		WebElement statedbclick = driver.findElement(By.xpath("//div[@class='dropdownFieldWpr__inputWpr']")); 
		act.doubleClick(statedbclick).perform();
		SelectAllValueFromList(driver,By.xpath("//ul[@class='dropdownListWpr']//li"),Statename);
		WebElement addr=driver.findElement(By.xpath("//input[@id='address_gst_info']"));
		addr.sendKeys(address);
		clickOnElement(driver.findElement(By.xpath("//div[@class='checkboxWithLblWpr']//span")));
		clickOnElement(driver.findElement(By.xpath("//button[contains(text(),'Continue')]")));
	
	}
	public void review()
	{
		WaitForElementToBeVisible(driver,By.xpath("//div[@class='detailsPopupFooter']//button[contains(text(),'CONFIRM')]"),2000);	
		clickOnElement(driver.findElement(By.xpath("//div[@class='detailsPopupFooter']//button[contains(text(),'CONFIRM')]")));
	}
	
	 
}
