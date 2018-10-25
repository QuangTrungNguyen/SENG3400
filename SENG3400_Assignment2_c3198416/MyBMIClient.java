/** 
File name: MyBMIClient.java
Author: Nguyen Quang Trung
Student number: c3198416
Course: SENG3400 Network & Distributed Computing | Assignment 2
Date Created: September 25, 2016
Last Changed: October 06, 2016
Description: This file contains MyBMIClient class for standard users clients.
*/ 

import localhost.axis.MyBMIAdmin_jws.*;  //to use MyBMIAdmin addCallCount() method
import localhost.axis.MyBMIServer_jws.*;

public class MyBMIClient
{
	public static void main(String[] args)
	{
		try
		{
			MyBMIServerService mbss = new MyBMIServerServiceLocator();
			MyBMIServer mbs = mbss.getMyBMIServer();
			
			MyBMIAdminService mbas = new MyBMIAdminServiceLocator();
			MyBMIAdmin mba = mbas.getMyBMIAdmin();
			
			//Switch statements to check method name given in args[0]
			switch(args[0])
			{
				//Call calcBMI method
				case "calcBMI":
				    System.out.println(mbs.calcBMI(args[2],args[1]));
					mba.addCallCount();  //update call count
				break;
				
				//Call listRanges method
				case "listRanges":
				    System.out.println(mbs.listRanges());
					mba.addCallCount(); //update call count
				break;
				
				//Call listWeights method
				case "listWeights":
				    System.out.println(mbs.listWeights(args[1]));
					mba.addCallCount(); //update call count
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