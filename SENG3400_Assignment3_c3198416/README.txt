Nguyen Quang Trung - c3198416

The following files are included in my submission folder SENG3400_Assignment3_c3198416:

1. demo.idl
(Client Folder)
2. DemoClient.java
(Server Folder)
3. DemoServer.java

HOW TO RUN THE PROGRAM:

Open Command Prompt, go to SENG3400_Assignment3_c3198416 folder
idlj –td Client –fclient Demo.idl
idlj –td Server –fall Demo.idl 

Compile client and server .java files in Client/Server folder respectively:
javac DemoClient.java DemoApp\*.java
javac DemoServer.java DemoApp\*.java

Start ORB
start orbd –ORBInitialPort 2014
In Server folder: start java DemoServer –ORBInitialHost localhost –ORBInitialPort 2014
In Client folder: java DemoClient –ORBInitialHost localhost –ORBInitialPort 2014

HOW THE PROGRAM IS RUN:

The program will first ask for user input (1,2,3,4) to choose which request mode to run.

(a is the random character returned from server in this example)

- If 1 is entered, Synchronous mode will be demonstrated:
  The output will be 
  Counter 1. Value: *
  ...(time delay from client between each counter is 0.5 second)
  Counter 5. Value: *
  CALL SERVER (there should be a random time delay from server here)
  Counter 6. Value: a
  Counter 7. Value: a
  Counter 8. Value: a
  Counter 9. Value: a
  Counter 10. Value: a (it should stop here)
  
- If 2 is entered, Deferred Synchronous mode will be demonstrated:
  The output will be
  Counter 1. Value: *
  ...(time delay from client between each counter is 0.5 second) 
  Counter 5. Value: *
  CALL SERVER
  Counter 6. Value: *
  ...
  Counter 10. Value: *
  (there should be a random time delay from server here)
  Counter 11. Value: a
  Counter 12. Value: a
  Counter 13. Value: a
  Counter 14. Value: a
  Counter 15. Value: a (it should stop here)

- If 3 is entered, Aynchronous mode will be demonstrated:
  The output will be
  Counter 1. Value: *
  ...(time delay from client between each counter is 0.5 second)
  Counter 5. Value: *
  CALL SERVER 
  (The loop keeps going with 0.5 second delay from client between each counter)
  (Depending on random wait time from server, the number of iteration/counter is based on that)
  Counter 12. Value: a (let's say the value is returned from server by counter 12)
  Counter 13. Value: a
  Counter 14. Value: a
  Counter 15. Value: a
  Counter 16. Value: a (it should stop here)



