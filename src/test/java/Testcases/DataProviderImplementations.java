package Testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utils.ExcelFileHandling;

public class DataProviderImplementations
{
	@DataProvider(name ="Locationinputs")
	public Object[][] SearchInputPageTestData() throws IOException
	{
		ExcelFileHandling E = new ExcelFileHandling();
		return E.ExcelReaddata("Makemytripinput.xlsx","Locationinput");
	}
	@DataProvider(name ="InputData")
	public Object[][] SearchPageTestData() throws IOException
	{
		ExcelFileHandling E = new ExcelFileHandling();
		return E.ExcelReaddata("Makemytripinput.xlsx","input");
	}
	@DataProvider(name ="ChildInputData")
	public Object[][] TravellerPageTestData() throws IOException
	{
		ExcelFileHandling E = new ExcelFileHandling();
		return E.ExcelReaddata("Makemytripinput.xlsx","Childinput");
	}
	@DataProvider(name ="InfantInputData")
	public Object[][] TravellerInfantPageTestData() throws IOException
	{
		ExcelFileHandling E = new ExcelFileHandling();
		return E.ExcelReaddata("Makemytripinput.xlsx","Infantinput");
	}
	@DataProvider(name ="BookingDetails")
	public Object[][] TravellerBookingTestData() throws IOException
	{
		ExcelFileHandling E = new ExcelFileHandling();
		return E.ExcelReaddata("Makemytripinput.xlsx","BookingDetail");
	}
	@DataProvider(name ="CreditcardDetails")
	public Object[][] CreditTestData() throws IOException
	{
		ExcelFileHandling E = new ExcelFileHandling();
		return E.ExcelReaddata("Makemytripinput.xlsx","creditcarddetails");
	}
	
	
}
