/** 
File name: CodeConverter.java
Author: Nguyen Quang Trung
Student number: c3198416
Course: SENG3400 Network & Distributed Computing | Assignment 1
Date Created: August 20, 2016
Last Changed: August 26, 2016
Description: This file contains the CodeConverter class for the server
*/ 

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CodeConverter 
{	
	private static int portNumber = 12345;     //Default port number for server
	private static String serverStatus = "ON"; //Status indicates if server is ON or OFF
	
	public static void main(String[] args) 
	{
		//Optional user input to override default port
		if (args.length == 1)
			portNumber = Integer.parseInt(args[0]);

		System.out.println("Starting server on port " + portNumber);
		
		do
	    {		
			try (   
					//Create socket with specific port, open writers and readers on it
				    ServerSocket serverSocket = new ServerSocket(portNumber);
				    Socket clientSocket = serverSocket.accept();
				    PrintWriter out =
					    new PrintWriter(clientSocket.getOutputStream(), true);
				    BufferedReader in = new BufferedReader(
				        new InputStreamReader(clientSocket.getInputStream()));
			    ) 
			{
				//Declare variables
				String inputLine,  //Client request
				       outputLine; //Server response
				CodeProtocol message = new CodeProtocol(); 
				
				//Begin to read client request
				while ((inputLine = in.readLine()) != null) 
				{
					//Validate client request
				    outputLine = message.processInput(inputLine);
				    //Server response
				    out.println(outputLine);
				    //Print client request and server response
				    System.out.println("REQUEST: " + inputLine);
	                System.out.println("RESPONSE: " + outputLine);
				        
			        //Server response is BYE: OK
			        if (outputLine.equals("BYE: OK"))
			        {
			        	System.out.println("Client disconnected. Waiting for new client.");
				       	break;
				       	//While loop terminates, automatically closes reader, writer, socket
				    }
				       
		            //Server response is END: OK
			        if (outputLine.equals("END: OK"))
			        {
			        	serverStatus = "OFF"; //Server status is turned OFF to stop accept new client
				        break;
				       	//While loop terminates, automatically closes reader, writer, socket
				    }				        	
			    }			    
			} 
			catch (IOException e) 
			{
			        System.out.println("Connection error.");
			}
	    }
		//While server status is still ON, continue try-with-resources statement to accept new client
		while (serverStatus.equals("ON"));  
		
		//When while loop terminates, server shuts down
        System.out.println("Server shuts down.");	
        System.exit(0);
	}
}




