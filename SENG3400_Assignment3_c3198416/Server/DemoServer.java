/** 
File name: DemoServer.java
Author: Nguyen Quang Trung
Student number: c3198416
Course: SENG3400 Network & Distributed Computing | Assignment 3
Date Created: October 18, 2016
Last Changed: October 28, 2016
Description: This file is for the Server Application. It includes a method to return a random character.
*/

import DemoApp.*; 
import org.omg.CosNaming.*; 
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*; 
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;
import java.lang.*; 
import java.util.*;

public class DemoServer
{
	public static void main(String[] args)
	{
    	try
    	{
			// declare and initialise orb object
    		ORB orb = ORB.init(args, null);
			// activate POA Manager
		    POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
				
     		DemoImpl DemoImpl = new DemoImpl();
      	    DemoImpl.setORB(orb);
      	
      	    // get object reference from the servant
      	    org.omg.CORBA.Object ref = rootpoa.servant_to_reference(DemoImpl);
      	    Demo href = DemoHelper.narrow(ref);

			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			
			String name = "Demo";
			NameComponent[] path = ncRef.to_name(name);
			ncRef.rebind(path, href);
				
			orb.run();
    	}
		catch (Exception e)
		{

			e.printStackTrace();
		}
	}
}

class DemoImpl extends DemoPOA
{

  private ORB orb;
  Random r = new Random();

  public void setORB(ORB orb_val)
  {
    orb = orb_val;
  }
  
  // method to generate and return a random character in String format
  public String getRandomChar()
  {
	  
	  int randomInt = 91, 
	      waitTime = r.nextInt(6000-3000+1) + 3000; //get random delay tinme between 3-5 seconds
	  
	  //get random integer within 65-90, 97-122 only
	  //to make ACSII conversion to A-B, a-z
      while(randomInt < 97 && randomInt > 90)
	  {
		  randomInt = r.nextInt(122 - 65 + 1) + 65;
	  }		  
	  
	  //convert ACSII to character
	  char randomChar = (char) randomInt;
	  
	  //Delay before returning
	  try
	  {
		  Thread.sleep(waitTime);           
	  }
	  catch(InterruptedException ex) 
	  {
		  Thread.currentThread().interrupt();
      }	
	  
      return Character.toString(randomChar);	  
  }
  
  public void shutdown()
  {
    orb.shutdown(false);
  }
}
