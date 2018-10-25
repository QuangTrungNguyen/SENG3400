/** 
File name: CodeClient.java
Author: Nguyen Quang Trung
Student number: c3198416
Course: SENG3400 Network & Distributed Computing | Assignment 1
Date Created: August 20, 2016
Last Changed: August 26, 2016
Description: This file contains the CodeClient class for the client
*/ 

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class CodeClient 
{
	private static int portNumber = 12345; //Default port number for client
	private static String hostAddress = "127.0.0.1"; //Default host address for client
	
	public static void main(String[] args) 
	{
		//Use default port number and host address
		if (args.length == 0)
			System.out.println("Connecting to localhost:" + portNumber);
		//User overrides host address only
		else if (args.length == 1)
		{
			hostAddress = args[0];
			System.out.println("Connecting to " + hostAddress + ":" + portNumber);
		}
		//User overrides both host address and port number
		else if (args.length == 2)
		{
			hostAddress = args[0];
			portNumber = Integer.parseInt(args[1]);
			System.out.println("Connecting to " + hostAddress + ":" + portNumber);
		}
		
		try (
				//Create socket with specific host+port, open writers and readers on it
			    Socket socket = new Socket(hostAddress, portNumber);
			    PrintWriter out = 
			    		new PrintWriter(socket.getOutputStream(), true);
			    BufferedReader in =
			    		new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    	BufferedReader stdIn = 
		    			new BufferedReader(new InputStreamReader(System.in));
			)
		{
			//Declare variables
			String fromServer, //Server response
			       fromUser = "ASCII"; //Client request + initial value
			System.out.println("CLIENT: " + fromUser);
			//Initiate conversation with server
			out.println(fromUser);
			
		    //Begin to read server response
			while ((fromServer = in.readLine()) != null)
			{
                System.out.println("SERVER: " + fromServer); //Print server response
			    if (fromServer.equals("ASCII: OK"))
			    {	 				    
			    	System.out.print("Enter command to send to server [AC,CA,BYE,END, or something to convert]: ");
					fromUser = stdIn.readLine();  //User input for client request	
				    System.out.println("CLIENT: " + fromUser); //Print client request
				    out.println(fromUser); //Send client request
			    }
			    //Client request BYE or END
			    if (fromServer.equals("BYE: OK") || fromServer.equals("END: OK"))
			    {
				    System.out.println("Disconnected from server.");
			    	break;
			    	//While loop terminates, automatically closes reader, writer, socket
			    }
			}
		} 
		catch(UnknownHostException e) 
		{
			System.out.println("Error connecting to server: Network is unreachable: connect");
		}
		catch (IOException e) 
		{
			System.out.println("Error connecting to server: Connection refused: connect");
		} 
		//While terminated, connection shut down, system exists
		System.exit(0);
	}
}
	
