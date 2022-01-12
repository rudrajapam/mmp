package org.iit.MMP.testcases;

import org.iit.MMP.base.DriverScriptClass;
import org.iit.MMP.pages.PayFees;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class mmpBaseTest extends DriverScriptClass{
	
	PayFees pFees;
	
	@BeforeMethod
	public void setUp()
	{
		initSetUp();
		pFees = new PayFees(driver);
	}
	
    @AfterMethod
    public void tearDown()
    {
    	driver.close();
    }
	
	
}
