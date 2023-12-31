package CommonElementsUtils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonElement 
{
	
	public void WaitForElementToBeVisible(WebDriver driver, By WaitForElement, int secondsToWait)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(secondsToWait));
		wait.until(ExpectedConditions.visibilityOfElementLocated(WaitForElement));
	}
	
	public void WaitForElementToBeClickable(WebDriver driver, By WaitForElement, int secondsToWait)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(secondsToWait));
		wait.until(ExpectedConditions.elementToBeClickable(WaitForElement));
	}
	
	public void SelectTheValueFromList(WebDriver driver, By AllListelements,String expectedloaction)
	{
		List<WebElement> AllValues = driver.findElements(AllListelements);
		
		for (WebElement eachElement : AllValues )
		{
			String actualFromLocation = eachElement.findElement(By.cssSelector("div[class*='makeFlex']>div[class*='pushRight']")).getText();
			//System.out.println(actualFromLocation);
			if(expectedloaction.equalsIgnoreCase(actualFromLocation))
			{
				eachElement.click();
				break;
			}
		}
	}
	public void SelectAllValueFromList(WebDriver driver, By AllListelement,String expectedtraveller)
	{
		List<WebElement> AllValues = driver.findElements(AllListelement);
		for (WebElement eachElement : AllValues )
		{
			String actualtraveller = eachElement.getText();
			//System.out.println(actualtraveller);
			if(expectedtraveller.equalsIgnoreCase(actualtraveller))
			{
				eachElement.click();
				break;
			}
		}
	}
	
	public void ClickOnButton(WebElement buttonElement)
	{
		if (buttonElement.isEnabled())
			buttonElement.click();
	}
	public void ClickOnViewButton(WebElement buttonElement)
	{
		if (buttonElement.isEnabled())
			buttonElement.click();
	}
	public void ClickOnMealButton(WebElement buttonElement)
	{
		if (buttonElement.isEnabled())
			buttonElement.click();
	}
	public boolean SelectValueinCalender(WebDriver driver,String expectedDay)
	{
		List<WebElement> totalWeekRows = driver.findElements(By.xpath("(//*[@class='DayPicker-Months']//div)[1]//div[@class='DayPicker-Week']"));
		for(WebElement eachWeekRow : totalWeekRows)
		{
			List<WebElement> totalDaysInWeek = eachWeekRow.findElements(By.cssSelector("div[class^='DayPicker-Day']"));
			for(WebElement eachDays : totalDaysInWeek)
			{
				String checkItsDisabled = eachDays.getAttribute("class");
				if (!checkItsDisabled.contains("disabled"))
				{
					String eachDayValue =eachDays.findElement(By.cssSelector("[class='dateInnerCell']>p:nth-of-type(1)")).getText();
					if(eachDayValue.equalsIgnoreCase(expectedDay))
					{
						eachDays.click();
						return true;
					}
					
				}
			}
		}
		return false;
	}
	
	public void clickOnButton(WebElement buttonElement)
	{
		
		if (buttonElement.isDisplayed())
		{
			buttonElement.click();
		}
	}
	public void clickOnElement(WebElement Element)
	{
		
		if (Element.isDisplayed())
		{
			Element.click();
		}
	}
	
	public String GetTextOfelement(WebElement getTextElement)
	{
		if(getTextElement.isDisplayed())
			return getTextElement.getText();
		return null;
	}
	public void scrolloption(WebDriver driver,WebElement scrollvalue)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",scrollvalue);
	}
	
	

}
