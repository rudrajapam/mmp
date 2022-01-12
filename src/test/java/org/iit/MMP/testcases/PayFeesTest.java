package org.iit.MMP.testcases;

import org.iit.MMP.Utils.CreditCardValidate;
import org.iit.MMP.Utils.HelperClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PayFeesTest extends mmpBaseTest{

	@Test(priority=2)
	public void fees() throws Exception{

		//logger=reports.createTest("PayFees");
		HelperClass helper = new HelperClass(driver);
		helper.launchApplication(prop.getProperty("patienturl"));		  	   
		helper.loginCredentials(prop.getProperty("patientUser"),prop.getProperty("patientPassword")); 		
		//logger.pass("Login Success");
		
		helper.navigatetoModule("  Fees ");		
	    //logger.info("Navigated to Fees Page");
		
		//PayFees pFees = new PayFees(driver);		
		pFees.payNowClick();		
		pFees.amountToBePaid("2904");
		pFees.continueButtonClick();
		pFees.CCardDetails("Sri K'hari","2","2345678923456789","03","16","346");			
		pFees.submitButtonClick();
		
		//Validating for Customer Name		
		CreditCardValidate cardname = new CreditCardValidate();
		
		boolean nameChk = cardname.CustName("Sri K'hari");		
		Assert.assertTrue(nameChk);
	
		boolean result= cardname.creditCardNoCheck("2345678923456789");
		Assert.assertTrue(result);
		
	}

}
