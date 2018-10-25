/** 
File name: MyBMIAdminClient.java
Author: Nguyen Quang Trung
Student number: c3198416
Course: SENG3400 Network & Distributed Computing | Assignment 2
Date Created: September 25, 2016
Last Changed: October 06, 2016
Description: This file contains MyBMIAdminClient class for admin user client.
*/ 

import localhost.axis.MyBMIAdmin_jws.*;

public class MyBMIAdminClient
{	
	public static void main(String[] args)
	{
		try
		{
			MyBMIAdminService mbas = new MyBMIAdminServiceLocator();
			MyBMIAdmin mba = mbas.getMyBMIAdmin();
			
			//Switch statements to check method name given in args[0]
			switch(args[0])
			{
				//Call callCount method
				case "callCount": 
				if(mba.callCount(args[1],args[2]) == -1)
					System.out.println("Invalid user credentials.");
				else
				{
					mba.addCallCount();  //update call count
                    System.out.println("Call Count: " + mba.callCount(args[1],args[2])); 				
				}					
				break;
				
				//Call addRange method
				case "addRange": boolean result = mba.addRange(args[1],args[2],args[3],args[4],args[5],Boolean.parseBoolean(args[6])); 
				if(result)
				{
					System.out.println("New range has been added.");
					mba.addCallCount();  //update call count
				}		
				else 
					System.out.println("Invalid user credentials or range name already existed.");				
				break;
				
				//Call deleteRange method
				case "deleteRange":
				if(mba.deleteRange(args[1],args[2],args[3]))
				{
					System.out.println("Range has been deleted.");
				    mba.addCallCount();  //update call count
				}				
				else 
					System.out.println("Invalid user credentials or range name does not exist.");								
				break;
				
				//Call setName method
				case "setName":
				if(mba.setName(args[1],args[2],args[3],args[4]))
				{
					System.out.println("Range name has been updated.");
					mba.addCallCount();  //update call count
				}					
				else 
					System.out.println("Invalid user credentials or range name does not exist.");			
				break;			
			}			
		}
		catch (Exception e)
		{
			//Users feedback
			System.out.println("Invalid command.");
		}
	}
}