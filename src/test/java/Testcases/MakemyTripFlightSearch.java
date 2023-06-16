package Testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import BrowserDriver.BrowserLaunch;
import CommonElementsUtils.CommonLogics;
import Pages.Booking_Details;
import Pages.MealSelection;
import Pages.Payment_Details;
import Pages.ProceedPayment;
import Pages.SearchPage;
import Pages.SeatBookingPage;
import Pages.SerachResultFlightSelectionPage;
import Pages.TravellerInput;
import Testcases.DataProviderImplementations;
import Utils.PropertyFileHandle;

public class MakemyTripFlightSearch extends BrowserLaunch 
{
	
	String currentUrl =null;
	
@BeforeSuite
public void launchTheBrowser()
{
	launch();
	
}

@BeforeTest()
public void EnterTheURL()
{
	currentUrl = PropertyFileHandle.propreaddata().getProperty("url");
	driver.get(currentUrl);
}

@BeforeClass
public void deleteAdds() throws InterruptedException
{
	Thread.sleep(5000);
	CommonLogics c = new CommonLogics();
	c.ClickIfElementExist(driver,"//*[@class='close']");
	c.ClickOnAddClose(driver);
}

@Test(priority=0,dataProvider="Locationinputs",dataProviderClass=DataProviderImplementations.class)
public void EnterValidSearchCriteria(String fcity,String tocity,String date,String Adultcount,String Childcount,String infantcount,String travellerclass)
{
	SearchPage sp = new SearchPage(driver);
	
	/*sp.SelectFromAndToValue("GOI","MAA");
	sp.SelectFlyFromDate("20");
	sp.SelectTravellers("1","1","1","Economy");*/
	sp.SelectFromAndToValue(fcity,tocity);
	sp.SelectFlyFromDate(date);
	sp.SelectTravellers(Adultcount,Childcount,infantcount,travellerclass);
	sp.ClickonSearchButton();
	SerachResultFlightSelectionPage SRP = new SerachResultFlightSelectionPage(driver);
	SRP.ClickOnPopupOkGotIt();
	SRP.GetTextOfFlightFrom();
	Assert.assertEquals(sp.ValidateTextForAssertion(), "Flights from "+sp.FromCityName+" to "+sp.ToCityName);
	SRP.Selectsortorder("Duration");
	SRP.clickOnButton(driver.findElement(By.xpath("//span[@class='appendRight8']")));
	SRP.Book_ticket();
	Booking_Details bd=new Booking_Details(driver);
	bd.SelectRadiobutton("Yes, Secure my trip.");
	Assert.assertEquals(bd.Getradiovalidation(), "Yes, Secure my trip.");
	
	//Flights from Pune to Chennai
}
@Test(priority=1,dataProvider="InputData",dataProviderClass=DataProviderImplementations.class)
public void EnterTravellerData(String Fname,String Lname) throws InterruptedException
{
	TravellerInput tv=new TravellerInput(driver);
	
	tv.Traveller_details(Fname,Lname);	
}
@Test(priority=2,dataProvider="ChildInputData",dataProviderClass=DataProviderImplementations.class)
public void EnterTravellerchildData(String Fname1,String Lname1)
{
	TravellerInput tv=new TravellerInput(driver);
	tv.Travellerchild_details(Fname1,Lname1);	
}
@Test(priority=3,dataProvider="InfantInputData",dataProviderClass=DataProviderImplementations.class)
public void EnterTravellerinfantData(String Fname2,String Lname2)
{
	TravellerInput tv=new TravellerInput(driver);
	tv.Travellerinfant_details(Fname2,Lname2);	
	
}
@Test(priority=4)
public void Infant_dob() 
{
	TravellerInput tv=new TravellerInput(driver);
	tv.InfantDob_details();
}
@Test(priority=5,dataProvider="BookingDetails",dataProviderClass=DataProviderImplementations.class)
public void EnterBooking_Details(String Mbno,String Email,String Pinnum,String State,String Address)
{
	TravellerInput tv=new TravellerInput(driver);
	tv.bookinginfo(Mbno,Email,Pinnum,State,Address);
}
@Test(priority=6)
public void review_details()
{
	TravellerInput tv=new TravellerInput(driver);
	tv.review();
}
@Test(priority=6)
public void seat_choose() throws InterruptedException
{
	SeatBookingPage sb=new SeatBookingPage(driver);
	sb.seatalloc();
}
@Test(priority=7)
public void meal_selection()
{
	MealSelection ms=new MealSelection(driver);
	ms.mealmenu();
}
@Test(priority=8)
public void proceed_payment()
{
	ProceedPayment pp=new ProceedPayment(driver);
	pp.proceed_pay();
}
@Test(priority=9,dataProvider="CreditcardDetails",dataProviderClass=DataProviderImplementations.class)
public void creditcardpay(String card_no,String card_holder,String Expiry_month,String Expiry_year,String Cvv)
{
	Payment_Details pd=new Payment_Details(driver);
	pd.Creditcard_payment(card_no,card_holder,Expiry_month,Expiry_year,Cvv);
	
}
/*@AfterMethod
public void BaseUrl() throws InterruptedException
{
	driver.get(currentUrl);
	Thread.sleep(5000);
	CommonLogics c = new CommonLogics();
	c.ClickIfElementExist(driver,"//*[@class='close']");
	// c.ClickOnAddClose(driver);

}*/

/*@Test(priority=1)
public void EnterSameFromandToInSearchCriteria()
{
	SearchPage sp = new SearchPage(driver);
	
	sp.SelectFromAndToValue("MAA","MAA");
	
	Assert.assertEquals(sp.GetSameCityError(), "From & To airports cannot be the same");
	//Flights from Pune to Chennai
}*/

}
