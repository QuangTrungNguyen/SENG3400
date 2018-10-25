/** 
File name: CodeProtocol.java
Author: Nguyen Quang Trung
Student number: c3198416
Course: SENG3400 Network & Distributed Computing | Assignment 1
Date Created: August 20, 2016
Last Changed: August 26, 2016
Description: This file contains CodeProtocol class which implements the protocol that the server and client use to communicate. 
It defines how the server response to a client request.
*/ 

public class CodeProtocol 
{
	private static String convertMode = "CA", //Default mode: Character to ASCII
	                      outputLine = null;  //Response from the server
	        
	//String method to validate client request and return server response accordingly
	public String processInput(String inputLine)
	{
		//Client initial request
		if(inputLine.equals("ASCII"))
		{
			outputLine = "ASCII: OK"; //Server standard response
		}		
		//Client change to AC mode
		else if (inputLine.equals("AC"))
		{
			convertMode = "AC";  //Mode changed
			outputLine = "CHANGE: OK" + "\nASCII: OK";
		}
		//Client change to CA mode
		else if (inputLine.equals("CA"))
		{
			convertMode = "CA";  //Mode changed
			outputLine = "CHANGE: OK" + "\nASCII: OK";		
		}
		//Client BYE request
		else if(inputLine.equals("BYE"))
		{
			outputLine = "BYE: OK";
		}
		//Client END request
		else if(inputLine.equals("END"))
		{
			outputLine = "END: OK";
		}
		
		//Check client request to convert
		//In AC mode: Check if client request is an integer within valid ranges
		else if (convertMode.equals("AC") && isInteger(inputLine) && isWithinRanges(inputLine))
		{
			//Return equivalent character for ASCII code
			outputLine = Character.toString((char)Integer.parseInt(inputLine)) + "\nASCII: OK"; 
		}
		//In CA mode: Check if client request is a single character string
		else if (convertMode.equals("CA") && inputLine.length() == 1)
		{
			//Check if the character is a letter
			if (Character.isLetter(inputLine.charAt(0)))
				//Return equivalent ASCII code for A-Z,a-z 
				outputLine = Integer.toString((int)inputLine.charAt(0)) + "\nASCII: OK"; 
			//Check if the character is an integer
			else if (isInteger(inputLine))
				//Return equivalent ASCII code for 0-9
				outputLine = Integer.toString(Integer.parseInt(inputLine) + 48) + "\nASCII: OK"; 
			//Invalid character
			else 
				outputLine = "EER" + "\nASCII: OK";
		}
		//All other invalid client requests
		else
		{
			outputLine = "EER" + "\nASCII: OK";
		}
		return outputLine;
	}
	
	//Boolean method to check if client request is an integer
	public boolean isInteger(String inputLine)
	{
		try
		{
           Integer.parseInt(inputLine);
		   return true; 	//Return true is it is an integer
	    }
		catch( NumberFormatException e )
		{
		   return false;    //Return false if it is not
		}
	}
	
	//Boolean method to check if client request is an integer within one of the valid ranges
	public boolean isWithinRanges(String inputLine)
	{
		if (48 <= Integer.parseInt(inputLine) && Integer.parseInt(inputLine) <= 57 || //48-57 (ASCII codes for 0-9)
		    65 <= Integer.parseInt(inputLine) && Integer.parseInt(inputLine) <= 90 || //65-90 (ASCII codes for A-Z)
		    97 <= Integer.parseInt(inputLine) && Integer.parseInt(inputLine) <= 122)  //97-122 (ASCII codes for a-z)
		{
			return true;  
		}
		else
			return false;
	}
}
