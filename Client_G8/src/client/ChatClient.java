package client;

import java.io.IOException;
import java.util.ArrayList;

import commonData.ChatIF;

//This file contains material supporting section 3.7 of the textbook:
//"Object Oriented Software Engineering" and is issued under the open-source
//license found at www.lloseng.com 
import ocsf.client.AbstractClient;

/**
* This class overrides some of the methods defined in the abstract
* superclass in order to give more functionality to the client.
*
* @author Dr Timothy C. Lethbridge
* @author Dr Robert Lagani&egrave;
* @author Fran&ccedil;ois B&eacute;langer
* @version July 2000
*/
public class ChatClient extends AbstractClient
{
	private final String sendMessage = "send";
	public static boolean awaitResponse = false;
//Instance variables **********************************************

/**
* The interface type variable.  It allows the implementation of 
* the display method in the client.
*/
ChatIF clientUI; 


//Constructors ****************************************************

/**
* Constructs an instance of the chat client.
*
* @param host The server to connect to.
* @param port The port number to connect on.
* @param clientUI The interface type variable.
*/

public ChatClient(String host, int port, ChatIF clientUI) 
 throws IOException 
{
 super(host, port); //Call the superclass constructor
 this.clientUI = clientUI;
 openConnection();
}


//Instance methods ************************************************
 
/**
* This method handles all data that comes in from the server.
*
* @param msg The message from the server.
*/
public void handleMessageFromServer(Object msg) 
{
 clientUI.display(msg.toString());
}

/**
* This method handles all data coming from the UI            
*
* @param studentDetails The message from the UI.    
*/
public void handleMessageFromClientUI(String str)  
{
  try
  {
  	openConnection();//in order to send more than one message
     	awaitResponse = true;
  	sendToServer(str);
		// wait for response
		while (awaitResponse) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
  }
  catch(IOException e)
  {
  	e.printStackTrace();
    clientUI.display("Could not send message to server: Terminating client."+ e);
    quit();
  }
}

/**
* This method terminates the client.
*/
public void quit()
{
 try
 {
   closeConnection();
 }
 catch(IOException e) {}
 System.exit(0);
}
}
//End of ChatClient class
