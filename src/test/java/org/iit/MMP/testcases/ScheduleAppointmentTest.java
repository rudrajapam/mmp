package org.iit.MMP.testcases;

import java.util.HashMap;
import org.iit.MMP.Utils.HelperClass;
import org.iit.MMP.pages.ScehduleAppointmentModule;
import org.testng.Assert;
import org.testng.annotations.Test;
//import junit.framework.Assert;

public class ScheduleAppointmentTest extends mmpBaseTest {
		
	@Test(priority=1)
	   public void scheduleAppointment() throws Exception
	   {
		
		   HelperClass helper = new HelperClass(driver);		   
		   helper.launchApplication(prop.getProperty("patienturl"));	
		 
		   helper.loginCredentials(prop.getProperty("patientUser"),prop.getProperty("patientPassword")); 	
		   
		   helper.navigatetoModule("Schedule Appointment");		   		
		   ScehduleAppointmentModule s_appointment = new ScehduleAppointmentModule(driver);
		   
		   //Calling method that takes all details as input
		   //s_appointment.bookAppointments("Dr.Beth","October","3","2022","10Am","Fever and cough");	
		   
		   //Calling method that takes appointment date in date format
		   //boolean result = s_appointment.dateCheck("Dr.Beth","10/25/2022","10Am","Fever");
		   //Assert.assertTrue(result);		   
		   
		   //Calling the hashMap method
		   HashMap<String,String> expHashMap = s_appointment.dateCheck1("Beth","Fever","12/25/2021","10Am");
		   System.out.println("input given:"+expHashMap);
		   HashMap<String,String> actualHashMap = s_appointment.patientPortal();
		   System.out.println("Chk if input entered:"+actualHashMap);	
		   //logger.pass("Booking Appointment Successful");
		   Assert.assertTrue(expHashMap.equals(actualHashMap));
		  
		   //helper.tearDown();		   
	   
	   }       

}
