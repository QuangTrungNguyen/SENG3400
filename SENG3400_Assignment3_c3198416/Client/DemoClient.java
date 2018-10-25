/** 
File name: DemoClient.java
Author: Nguyen Quang Trung
Student number: c3198416
Course: SENG3400 Network & Distributed Computing | Assignment 3
Date Created: October 18, 2016
Last Changed: October 28, 2016
Description: This file is for the Client Application. It includes the logic for all 3 request modes: synchronous, deferred synchronous and asynchronous.
*/

import DemoApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.lang.*;
import java.util.*;

public class DemoClient
{
	// default randomCharue for the private variable
	private static final String defaultrandomCharue = "*";
	// initialise the variable to default randomCharue
	private static String randomChar = defaultrandomCharue;
	
	private Thread thread;
	
	static Scanner console = new Scanner(System.in);  
	
	public static void main(String[] args)
	{
		// variable indicates which request mode to run
		int iMode = 0;
		
		try
		{
			Thread.sleep(500);
			// Ask for user input of request mode to run
			System.out.println("\n(1) Synchronous\n"
		                     + "(2) Deferred Synchronous\n"
						     + "(3) Asynchronous\n"
						     + "(4) Exit program\n"
						     + "Please select the mode you want to run (1,2,3,4): ");
			iMode = console.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("InrandomCharid input!");
		}
		
		try
		{
			// declare and initialise orb object
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			
			String name = "Demo";
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			Demo DemoRef = DemoHelper.narrow(ncRef.resolve_str(name));
			
			//SYNCHRONOUS 
			if(iMode == 1)
			{
				for(int i=1; i<=10; i++)
			    {
					// after 5 iterations
					if(i==6)
					{
						System.out.println("CALL SERVER");
						// call server, get random value for variable
						randomChar = DemoRef.getRandomChar();	 
				    }
					//Delay for readability
				    Thread.sleep(500);
					// Print output
				    System.out.println("Counter " + i + " Value: " + randomChar);			 
			    }
				// reset variable to default for other request mode
			    randomChar = defaultrandomCharue;
				// call main method to ask for user input again
			    main(args);
			}
			
			// DEFERRED SYNCHRONOUS
			if(iMode == 2)
			{
				// create a request object 
				Request request = DemoRef._request("getRandomChar");
				for(int i=1; i<=15; i++)
				{
					// after 5 iterations
					if (i == 6)
					{		
				        // call server
						System.out.println("CALL SERVER");	
						request.set_return_type(orb.create_string_tc(1));
						request.send_deferred();
					}
					
					// after 10 iterations
					if(i==11)
					{
						// get result 
						request.get_response();	
						// set the value to the variable
						randomChar = request.return_value().extract_string();
					}
					//Delay for readability
					Thread.sleep(500);
					// Print output
					System.out.println("Counter " + i + " Value: " + randomChar);						
			    }
				// reset variable to default for other request mode
				randomChar = defaultrandomCharue;
				// call main method to ask for user input again
				main(args);
			}
			
			
			//ASYNCHRONOUS
			if(iMode == 3)
			{
				
				// default iteration number
				int iterationNum = 5;
                
				// create a request object
			    Request request = DemoRef._request("getRandomChar");
			    request.set_return_type(orb.create_string_tc(1));
				
			    for(int i=1;i<=iterationNum;i++)
			    {				
			        //Delay for readability
		            Thread.sleep(500);
					// Print output
		            System.out.println("Counter " + i + " Value: " + randomChar);	
					
					// after 5 iterations
				    if(i == 5 && request != null)
				    {
						// call server
					    System.out.println("CALL SERVER");				
					    request.send_deferred();				
				    }				
					
					// if response has been received
				    if(request != null && request.poll_response())
				    {
						// set the value to the variable
					    randomChar = request.return_value().extract_string();
						// go for 5 more iterations
					    iterationNum += 5;
					    request = null;
				    }
					
					// if response is not yet received
				    else if(i>=5 && request != null && !request.poll_response())
				    {
						// keep looping
					    iterationNum += 1;
				    }				
			    }
				// reset variable to default for other request mode
				randomChar = defaultrandomCharue;
				// call main method to ask for user input again
				main(args);
			}

			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

