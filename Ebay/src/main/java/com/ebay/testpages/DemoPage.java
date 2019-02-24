package com.ebay.testpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ebay.comlib.CommonLibrary;
import com.ebay.comlib.CommonReusableMethods;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DemoPage {

	CommonLibrary comlib= new CommonLibrary();
	CommonReusableMethods commonReusableMethods= new CommonReusableMethods();
	ExtentTest extest;


	/* Constructor is created so that webelemwnts can be initialized wheneven an instance of this 
	 * class is created like i have done in DemoTest Class
	 */
	public DemoPage(WebDriver driver, ExtentTest test) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		extest=test;
	}

	/* For using common code base i am using common webelement variable */

	@iOSFindBy(xpath = "home")
	@AndroidFindBy(accessibility = "Main navigation, open")
	public WebElement hamburgerMenu;

	@iOSFindBy(id = "menuitem_settings")
	@AndroidFindBy(id = "menuitem_settings")
	public WebElement hamBurgerMenuSettingsOption;

	@iOSFindBy(id = "menuitem_settings")
	@AndroidFindBy(accessibility = "Deals,double tap to activate")
	public WebElement hamBurgerMenuDealsOption;


	@iOSFindBy(id = "Country/region button")
	@AndroidFindBy(accessibility = "Country/region button")
	public WebElement countryRegionButton;

	@iOSFindBy(id = "switchWidget")
	@AndroidFindBy(id = "android:id/switchWidget")
	public WebElement autoDetectCheckbox;

	@iOSFindBy(id = "title")
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[3]/android.widget.RelativeLayout")
	public WebElement countryRegionButtonCountryScreen;

	@iOSFindBy(id = "filter")
	@AndroidFindBy(id = "filter")
	public WebElement searchCountryEditbox;

	@iOSFindBy(id = "title")
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.CheckedTextView")
	public List<WebElement> countryList;

	@iOSFindBy(id = "title")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.TextView[2]")
	public WebElement countryName;

	@iOSFindBy(id = "more Trending deals")
	@AndroidFindBy(accessibility = "more Trending deals")
	public WebElement moreTrendingDeals;

	@iOSFindBy(id = "title")
	@AndroidFindBy(id = "title")
	public WebElement pageTitle;

	@iOSFindBy(id = "Search")
	@AndroidFindBy(accessibility = "Search")
	public WebElement categorySearchIcon;

	@iOSFindBy(id = "search_src_text")
	@AndroidFindBy(id = "search_src_text")
	public WebElement categorySearchEditbox;


	@iOSFindBy(id = "title")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.TextView")
	public WebElement searchedCategoryFirstResult;

	@iOSFindBy(id = "Categories,double tap to activate")
	@AndroidFindBy(accessibility = "Categories,double tap to activate")
	public WebElement hamburgerMenuCategoriesOption;

	@iOSFindBy(id = "progress_bar")
	@AndroidFindBy(accessibility = "progress_bar")
	public WebElement progressBar;

	@iOSFindBy(id = "resultName")
	@AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView")
	public WebElement searchedCategoryFirstResultName;

	@iOSFindBy(id = "Categories,double tap to activate")
	@AndroidFindBy(accessibility = "Home,double tap to activate")
	public WebElement hamburgerMenuHomeOption;

	@iOSFindBy(id = "button_register")
	@AndroidFindBy(id = "button_register")
	public WebElement registerButtonHomeScreen;


	@iOSFindBy(id = "firstname")
	@AndroidFindBy(id = "firstname")
	public WebElement registerScreenFirstNameTextbox;

	@iOSFindBy(id = "firstname")
	@AndroidFindBy(id = "lastname")
	public WebElement registerScreenLastNameTextbox;

	@iOSFindBy(id = "firstname")
	@AndroidFindBy(id = "email")
	public WebElement registerScreenEmailTextbox;


	@iOSFindBy(id = "firstname")
	@AndroidFindBy(id = "ppaFormSbtBtn")
	public WebElement registerScreenSubmitButton;

	@iOSFindBy(id = "firstname")
	@AndroidFindBy(accessibility = "Navigate up")
	public WebElement registerScreenCloseButton;


	@iOSFindBy(id = "firstname")
	@AndroidFindBy(accessibility = "Selling,double tap to activate")
	public WebElement hamburgerMenuSellingOption;

	@iOSFindBy(id = "sell_something_button")
	@AndroidFindBy(id = "sell_something_button")
	public WebElement startSellingButton;

	@iOSFindBy(id = "sell_something_button")
	@AndroidFindBy(id = "groupTitle")
	public WebElement sellingScreenHowItWorks;

	@iOSFindBy(id = "sell_something_button")
	@AndroidFindBy(accessibility = "Cart button")
	public WebElement sellingScreenCartIcon;

	@iOSFindBy(id = "sell_something_button")
	@AndroidFindBy(accessibility = "Navigate up")
	public WebElement navigateBackButton;



	/* Passing platform name so that if there is some difference in flow of iOS and android then this can be used to 
	 * differentiate
	 */
	@SuppressWarnings("rawtypes")
	public void selectCountryAndRegion(AppiumDriver driver,String platform,String expectedCountry) throws Exception
	{
		boolean check;
		TouchAction action = new TouchAction(driver);

		
		


		try {

			/*This Reusable method is called from common library which check for availability of an element and I have pass and fail condition reporting
			 * inside this method only
			 */
			comlib.validateForElementDisplayed(hamburgerMenu, driver, extest, "verify if Hamburger menu is displayed in homescreen", "",
					"", "Hamburger menu is not displayed in homescreen");
			hamburgerMenu.click();

			/* Below line method will scroll up as long as Settings button not displayed in screen and return boolean value 
			 * Through which further steps of code can be decided
			 * */
			check=commonReusableMethods.swipeToElement(hamBurgerMenuSettingsOption, driver, extest);
			if(check)
			{
				hamBurgerMenuSettingsOption.click();

				comlib.validateForElementDisplayed(countryRegionButton, driver, extest, "verify if Select country/Region displayed in settings", "",
						"", "Select country/Region not displayed in settings");
				countryRegionButton.click();

				comlib.validateForElementDisplayed(autoDetectCheckbox, driver, extest, "verify if Auto detect checkbox displayed", "",
						"", "Auto detect checkbox not displayed");
				check=autoDetectCheckbox.isSelected();

				if(check)
				{
					autoDetectCheckbox.click();
				}

				countryRegionButtonCountryScreen.click();
				comlib.validateForElementDisplayed(searchCountryEditbox, driver, extest, "verify if country search box displayed", "",
						"", "country search box not displayed");
				/* 2 ways are there to select Australia 
				 * 1. First way is written below where i search for Australia and get list of countries and verify the list value contains 
				 *    Australia and select if matches.
				 * 2. Without passing in search box we can take entire visible list and verify if australia is present by comparing string and keep 
				 *    scrolling up until autralia is displayed
				 */
				searchCountryEditbox.sendKeys(expectedCountry);

				for(WebElement st: countryList)
				{
					if(st.getText().equals(expectedCountry))
					{
						st.click();		
						break;
					}
				}

				comlib.validateForElementDisplayed(countryName, driver, extest, "verify if user redirected to selected country screen", "",
						"", "user not redirected to selected country screen");
				/*Below i am verifying if Australia text displayed under Country/Region */
				check=countryName.getText().equals(expectedCountry);

				comlib.verifyForCondition(driver, extest, check, "Verify if selected country is reflected as expected", "", 
						"Expected value was "+expectedCountry+" and forund is "+countryName.getText());
				action.tap(TapOptions.tapOptions().withElement(ElementOption.element(navigateBackButton))).perform();
				action.tap(TapOptions.tapOptions().withElement(ElementOption.element(navigateBackButton))).perform();

			}
		}catch (Exception e) {

			comlib.fail(driver,"Check Execution Status", "", "Test case got failed", extest);		
		}


	}

	public void verifyTrendingDealsScreen(AppiumDriver driver) throws Exception
	{
		boolean check;

		String expTitle="Trending deals";

		try {
			hamburgerMenu.click();
			comlib.swipe_ins(driver, "up");
			comlib.validateForElementDisplayed(hamBurgerMenuDealsOption, driver, extest, "verify if Deals option is displayed in hamburger Menu", "",
					"", "Deals option is not displayed in hamburger Menu");
			hamBurgerMenuDealsOption.click();
			check=comlib.scrollToElement(driver, moreTrendingDeals);
			if(check)
			{
				moreTrendingDeals.click();

				comlib.validateForElementDisplayed(pageTitle, driver, extest, "verify if page Title is displayed", "",
						"", "page Title is not displayed");
				check=expTitle.equals(pageTitle.getText());

				comlib.verifyForCondition(driver, extest, check, "Verify if Trending deals page title is correct", "", 
						"Expected value was "+expTitle+" and forund is "+pageTitle.getText());

			}


		}catch (Exception e) {

			comlib.fail(driver,"Check Execution Status", "", "Test case got failed", extest);		
		}

	}

	public void verifySearchCategories(AppiumDriver driver) throws Exception
	{
		boolean check;
		String expCategory="Stamps";

		try {
			hamburgerMenu.click();
			comlib.swipe_ins(driver, "up");

			comlib.validateForElementDisplayed(hamburgerMenuCategoriesOption, driver, extest, "verify if categories option is displayed in hamburger Menu", "",
					"", "categories option is not displayed in hamburger Menu");
			hamburgerMenuCategoriesOption.click();

			check=comlib.validateForElementDisplayed(categorySearchIcon, driver, extest, "verify if categories search icon is displayed", "",
					"", "categories search icon is not displayed");
			if(check)
			{
				categorySearchIcon.click();
				comlib.validateForElementDisplayed(categorySearchEditbox, driver, extest, "verify if categories search editbox is displayed", "",
						"", "categories search editbox is not displayed");
				categorySearchEditbox.sendKeys(expCategory);
				commonReusableMethods.waitForElementToDisappear(driver, progressBar);

				comlib.validateForElementDisplayed(searchedCategoryFirstResult, driver, extest, "verify if Auto suggest list is displayed", "",
						"", "Auto suggest list is not  displayed");
				searchedCategoryFirstResult.click();

				comlib.validateForElementDisplayed(searchedCategoryFirstResultName, driver, extest, "verify if Searched result name displayed", "",
						"", "Searched result name not displayed");
				check=searchedCategoryFirstResultName.getText().contains(expCategory);


				comlib.verifyForCondition(driver, extest, check, "Verify if Category is serached correctly", "", 
						"Expected value was "+expCategory+" and forund is "+searchedCategoryFirstResultName.getText());

			}


		}catch (Exception e) {

			comlib.fail(driver,"Check Execution Status", "", "Test case got failed", extest);		
		}

	}

	public void verifyRegisterScreenElements(AppiumDriver driver) throws Exception
	{
		

		try {
			hamburgerMenu.click();

			comlib.validateForElementDisplayed(hamburgerMenuHomeOption, driver, extest, "verify if Home option is displayed in hamburger Menu", "",
					"", "Home option is not displayed in hamburger Menu");
			hamburgerMenuHomeOption.click();

			comlib.validateForElementDisplayed(registerButtonHomeScreen, driver, extest, "verify if Register button is displayed in homescreen", "",
					"", "Register button is not displayed in homescreen");
			registerButtonHomeScreen.click();
			commonReusableMethods.waitForElementToDisappear(driver, progressBar);

			comlib.validateForElementDisplayed(registerScreenFirstNameTextbox, driver, extest, "verify if Register screen first name editbox is displayed", "",
					"", "Register screen first name editbox is not displayed");

			comlib.validateForElementDisplayed(registerScreenLastNameTextbox, driver, extest, "verify if Register screen last name editbox is displayed", "",
					"", "Register screen last name editbox is not displayed");
			
			comlib.validateForElementDisplayed(registerScreenEmailTextbox, driver, extest, "verify if Register screen email editbox is displayed", "",
					"", "Register screen email editbox is not displayed");

			comlib.validateForElementDisplayed(registerScreenSubmitButton, driver, extest, "verify if Register screen submit button is displayed", "",
					"", "Register screen submit button is not displayed");
			
			registerScreenCloseButton.click();

		}catch (Exception e) {

			comlib.fail(driver,"Check Execution Status", "", "Test case got failed", extest);		
		}

	}

	public void verifySellingScreen(AppiumDriver driver) throws Exception
	{
		

		try {
			hamburgerMenu.click();

			comlib.validateForElementDisplayed(hamburgerMenuSellingOption, driver, extest, "verify if Selling option is displayed in hamburger Menu", "",
					"", "Selling option is not displayed in hamburger Menu");
			hamburgerMenuSellingOption.click();

			comlib.validateForElementDisplayed(startSellingButton, driver, extest, "verify if Start selling button displayed in selling screen", "",
					"", "Start selling button not displayed in selling screen");
			
			comlib.validateForElementDisplayed(sellingScreenHowItWorks, driver, extest, "verify if how it works title displayed in selling screen", "",
					"", "how it works title not displayed in selling screen");

			comlib.validateForElementDisplayed(sellingScreenCartIcon, driver, extest, "verify if Cart icon displayed in selling screen", "",
					"", "Cart icon not displayed in selling screen");
			

		}catch (Exception e) {

			comlib.fail(driver,"Check Execution Status", "", "Test case got failed", extest);		
		}

	}



}
