package org.iit.MMP.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PayFees {

	WebDriver driver;
	Select cardType_dropdown, exp_Month, exp_Year;

	@FindBy(xpath = "//button[contains(text(),'Pay Now')]")
	WebElement payNow;

	@FindBy(xpath = "//select[@name='amount']")
	WebElement amount;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//input[@placeholder='First  & Last Name']")
	WebElement customerName;
	@FindBy(xpath = "//select[@name='Card_name']")
	WebElement cardType;

	@FindBy(xpath = "//input[@placeholder='Card Number']")
	WebElement cardNumber;

	@FindBy(xpath = "//select[@name='CCExpiresMonth']")
	WebElement month;
	@FindBy(xpath = "//select[@name='CCExpiresYear']")
	WebElement year;
	@FindBy(xpath = "//input[@id='cvv']")
	WebElement ccv;

	@FindBy(xpath = "//input[@value='submit']")
	WebElement submitButton;

	public PayFees(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void payNowClick() {
		payNow.click();
	}
		
	public void amountToBePaid(String optionValue) {
				
		Select s = new Select(amount);
		List<WebElement> amount_options = s.getOptions();
		for (WebElement options : amount_options) {
			if (options.getAttribute("value").equals(optionValue)) {
				s.selectByValue(optionValue);

			}
		}			
	}
	
	public void continueButtonClick() {
		continueButton.click();
	}
			
	public void submitButtonClick() {
		submitButton.click();

	}
	
	public void CCardDetails(String custName, String cCardTypeValue, String cCardNo, String expMonth, String expYear,
			String Ccard_CVV) 
	{

		customerName.sendKeys(custName);
		
		cardType_dropdown = new Select(cardType);
		cardType_dropdown.selectByValue(cCardTypeValue);
		
		cardNumber.sendKeys(cCardNo);	
		
		exp_Month = new Select(month);
		exp_Month.selectByValue(expMonth);
	
		exp_Year = new Select(year);
		exp_Year.selectByValue(expYear);

		ccv.sendKeys(Ccard_CVV);

	}
	
}
