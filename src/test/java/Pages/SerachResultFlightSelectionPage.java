package Pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonElementsUtils.CommonElement;

public class SerachResultFlightSelectionPage extends CommonElement {

	WebDriver driver;
	
	public SerachResultFlightSelectionPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public void ClickOnPopupOkGotIt()
	{
		WaitForElementToBeClickable(driver,By.xpath("//*[text()='OKAY, GOT IT!']"),80);
		clickOnButton(driver.findElement(By.xpath("//*[text()='OKAY, GOT IT!']")));
	}
	
	public void GetTextOfFlightFrom()
	{
		String text =GetTextOfelement(driver.findElement(By.xpath("//*[contains(@class,'journey-title')]")));
		System.out.println(text);
	}
	public void Selectsortorder(String order1)
	{
		System.out.println("hai");
		WaitForElementToBeVisible(driver,By.xpath("(//span[@class='pointer'])[2]"),1500);	
		SelectAllValueFromList(driver,By.xpath("//span[@class='pointer']"),order1);
	}
	public void Book_ticket()
	{
		String parent= driver.getWindowHandle();
		WaitForElementToBeVisible(driver,By.xpath("(//button[text()='Book Now'])[1]"),1500);	
	driver.findElement(By.xpath("(//button[text()='Book Now'])[1]")).click();
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String eachWindowName:allWindows)
		{
			if (!parent.equals(eachWindowName))
			{
				driver.switchTo().window(eachWindowName);
				 	
				scrolloption(driver,driver.findElement(By.xpath("//div[@class='claimSection']//section")));
			}
		}
	}
	


}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	