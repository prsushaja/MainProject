package Testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

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
	test.log(LogStatus.INFO, "The following url is enterd : "+currentUrl);
}

@BeforeClass
public void deleteAdds() throws InterruptedException
{
	Thread.sleep(5000);
	CommonLogics c = new CommonLogics();
	c.ClickIfElementExist(driver,"//*[@class='close']");
	test.log(LogStatus.INFO, "The first popup window closed sucessfully");
	c.ClickOnAddClose(driver);
	test.log(LogStatus.INFO, "The second popup window closed sucessfully");
	
}

@Test(priority=0,dataProvider="Locationinputs",dataProviderClass=DataProviderImplementations.class)
public void EnterValidSearchCriteria(String fcity,String tocity,String date,String Adultcount,String Childcount,String infantcount,String travellerclass) throws InterruptedException
{
	SearchPage sp = new SearchPage(driver);
	
	/*sp.SelectFromAndToValue("GOI","MAA");
	sp.SelectFlyFromDate("20");
	sp.SelectTravellers("1","1","1","Economy");*/
	sp.SelectFromAndToValue(fcity,tocity);
	test.log(LogStatus.INFO, "The "+fcity +" as from city and "+tocity+" as to city is selected sucessfully");
	sp.SelectFlyFromDate(date);
	test.log(LogStatus.INFO, "The "+date+ " is the given date is selected");
	sp.SelectTravellers(Adultcount,Childcount,infantcount,travellerclass);
	test.log(LogStatus.INFO, "The Adultcount "+Adultcount+ "childcount"+Childcount+"infantcount"+infantcount+"travellerclass"+travellerclass);
	sp.ClickonSearchButton();
	test.log(LogStatus.INFO, "Search button is clicked suecssfully");
	SerachResultFlightSelectionPage SRP = new SerachResultFlightSelectionPage(driver);
	SRP.ClickOnPopupOkGotIt();
	test.log(LogStatus.INFO, "ok Got it popup is clicked suecssfully");
	SRP.GetTextOfFlightFrom();
	test.log(LogStatus.INFO, "Search Text is validated sucessfully");
	Assert.assertEquals(sp.ValidateTextForAssertion(), "Flights from "+sp.FromCityName+" to "+sp.ToCityName);
	test.log(LogStatus.PASS, "All the Steps are executed sucessfully");
	SRP.Selectsortorder("Duration");
	test.log(LogStatus.INFO, "The Duration is selected");
	SRP.ClickOnViewButton(driver.findElement(By.xpath("//span[@class='appendRight8']")));
	test.log(LogStatus.INFO, "The Viewpice is clicked");
	SRP.Book_Ticket();
	test.log(LogStatus.INFO, "The Book Now is clicked sucessfully");
	Booking_Details bd=new Booking_Details(driver);
	bd.SelectInsuranceMode("Yes, Secure my trip.");
	test.log(LogStatus.INFO, "Insurance Mode is Selected");
	Assert.assertEquals(bd.Getradiovalidation(), "Yes, Secure my trip.");
	
	//Flights from Pune to Chennai
} 
@Test(priority=1,dataProvider="InputData",dataProviderClass=DataProviderImplementations.class)
public void EnterTravellerAdultData(String fname,String lname) throws InterruptedException
{
	TravellerInput tv=new TravellerInput(driver);
	
	tv.Traveller_Details(fname,lname);	
	test.log(LogStatus.INFO, "Adult Firstname "+fname+"Lastname "+lname);
}
@Test(priority=2,dataProvider="ChildInputData",dataProviderClass=DataProviderImplementations.class)
public void EnterTravellerChildData(String fname1,String lname1)
{
	TravellerInput tv=new TravellerInput(driver);
	tv.Travellerchild_Details(fname1,lname1);
	test.log(LogStatus.INFO, "Child Firstname "+fname1+"Lastname "+lname1);
}
@Test(priority=3,dataProvider="InfantInputData",dataProviderClass=DataProviderImplementations.class)
public void EnterTravellerInfantData(String fname2,String lname2)
{
	TravellerInput tv=new TravellerInput(driver);
	tv.Travellerinfant_Details(fname2,lname2);	
	test.log(LogStatus.INFO, "Infant Firstname  "+fname2+"Lastname  "+lname2);
	
}
@Test(priority=4)
public void Infant_dob() 
{
	TravellerInput tv=new TravellerInput(driver);
	tv.InfantDob_details();
	test.log(LogStatus.INFO, "Infant DOB Is selected successfully");
}
@Test(priority=5,dataProvider="BookingDetails",dataProviderClass=DataProviderImplementations.class)
public void EnterBooking_Details(String mbno,String email,String pinnum,String state,String address)
{
	TravellerInput tv=new TravellerInput(driver);
	tv.Bookinginfo(mbno,email,pinnum,state,address);
	test.log(LogStatus.INFO, "Mobile Number"+mbno+"Email"+email+"Pinnumber"+pinnum+"State"+state+"Address"+address+"Is selected");
}
@Test(priority=6)
public void Review_Details()
{
	TravellerInput tv=new TravellerInput(driver);
	tv.Review();
	test.log(LogStatus.INFO, "Confirm the traveller details");
}
@Test(priority=6)
public void Seat_Choose() throws InterruptedException
{
	SeatBookingPage sb=new SeatBookingPage(driver);
	sb.SeatAllocation();
	test.log(LogStatus.INFO, "Seat is selected defaultly");
}
@Test(priority=7)
public void meal_selection() throws InterruptedException
{
	MealSelection ms=new MealSelection(driver);
	ms.MealMenu();
	test.log(LogStatus.INFO, "Continue");
}
@Test(priority=8)
public void Proceed_Payment()
{
	ProceedPayment pp=new ProceedPayment(driver);
	pp.Proceed_Pay();
	test.log(LogStatus.INFO, "Proceed to payment");
}
@Test(priority=9,dataProvider="CreditcardDetails",dataProviderClass=DataProviderImplementations.class)
public void CreditCardPay(String card_no,String card_holder,String expiry_month,String expiry_year,String cvv)
{
	Payment_Details pd=new Payment_Details(driver);
	pd.Creditcard_Payment(card_no,card_holder,expiry_month,expiry_year,cvv);
	test.log(LogStatus.INFO, "Card number"+card_no+"Card Holder"+card_holder+"Card Expirymonth"+expiry_month+"Card ExpiryYear"+expiry_year+"Cvv"+cvv);
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

@AfterSuite
public void Teardown()
{
	test.log(LogStatus.INFO, "Testcase Executed Successfully");
	report.flush();
	driver.quit();
}

}
