Nguyen Quang Trung - c3198416

The following files are included in my submission folder SENG3400_Assignment1_c3198416:

1. Assessment CoverSheet.pdf
2. readme.txt
3. CodeClient.java (Contains class for the client)
4. CodeConverter.java (Contains class for the server)
5. CodeProtocol.java (Contains class that holds protocol for communication)

To compile these files run: javac CodeClient.java
                            javac CodeConverter.java
                            javac CodeProtocol.java

The server and client have been provided with default port: 12345
The client's default host address is 127.0.0.1

To execute the SERVER:
  + With default port number, run: java CodeConverter
  + With new port number, run:     java CodeConverter + (port number)

To execute the CLIENT:
  + With default host and port, run: java CodeClient
  + With new host and/or port, run:  java CodeClient + (host address) 
                                  OR java CodeClient + (host address) + (port number)

The server and client have been successfully tested with the sample code.