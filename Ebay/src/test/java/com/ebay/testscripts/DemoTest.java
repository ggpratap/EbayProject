package com.ebay.testscripts;

import org.testng.annotations.Test;

import com.ebay.base.SuperClass;
import com.ebay.comlib.CommonLibrary;
import com.ebay.comlib.CommonReusableMethods;
import com.ebay.reports.ExtentTestManager;
import com.ebay.testpages.DemoPage;




public class DemoTest extends SuperClass{

	/* This Class is inheriting superclass so driver control will be available and also Platform name*/
	CommonLibrary comlib = new CommonLibrary();
	CommonReusableMethods commonReusableMethods= new CommonReusableMethods();
	String countryToSelect="Australia";


	@Test(priority=1)
	public void selectCountryAndRegion() throws Exception {

		/*Creating Instance of DemoPage to initialize all the webelement variables*/
		
		DemoPage demopage= new DemoPage(driver, ExtentTestManager.getTest());
		
		/*calling method to select region or country*/
		demopage.selectCountryAndRegion(driver, osType, countryToSelect);
	}

	@Test(priority=2)
	public void verifyTrendingDealsScreen() throws Exception {
		
		DemoPage demopage= new DemoPage(driver, ExtentTestManager.getTest());
		demopage.verifyTrendingDealsScreen(driver);
	}
	
	@Test(priority=3)
	public void verifySearchCategories() throws Exception {
		
		DemoPage demopage= new DemoPage(driver, ExtentTestManager.getTest());
		demopage.verifySearchCategories(driver);
	}
	

	@Test(priority=4)
	public void verifyRegisterScreenElements() throws Exception {
		
		DemoPage demopage= new DemoPage(driver, ExtentTestManager.getTest());
		demopage.verifyRegisterScreenElements(driver);
	}

	@Test(priority=5)
	public void verifySellingScreen() throws Exception {
		
		DemoPage demopage= new DemoPage(driver, ExtentTestManager.getTest());
		demopage.verifySellingScreen(driver);
	}
}
