// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package Client;

import OCSF.client.*;
import Client.*;
import common.*;
import logic.*;

import java.io.*;

/**
 * This class overrides some of the methods defined in the abstract superclass
 * in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class GoClient extends AbstractClient {
	// Instance variables **********************************************

	/**
	 * The interface type variable. It allows the implementation of the display
	 * method in the client.
	 */
	goIF clientUI;
	public static PreOrderTraveller s1 = new PreOrderTraveller(null, null, null, null, null);
	public static boolean awaitResponse = false;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the chat client.
	 *
	 * @param host     The server to connect to.
	 * @param port     The port number to connect on.
	 * @param clientUI The interface type variable.
	 */

	public GoClient(String host, int port, goIF clientUI) throws IOException {
		super(host, port); // Call the superclass constructor
		this.clientUI = clientUI;
		// openConnection();
	}

	// Instance methods ************************************************

	/**
	 * This method handles all data that comes in from the server.
	 *
	 * @param msg The message from the server.
	 */
	public void handleMessageFromServer(Object msg) {
		System.out.println("--> handleMessageFromServer");

		awaitResponse = false;
		String st;
		st = msg.toString();
		String[] result = st.split(" ");
		  
		  if(result[0].equals("null"))
			  ClientUI.aFrame.GetRepondId(null);
		  else if(result.length==3)
			  ClientUI.aFrame.displayConnection(result);
		  else
			  ClientUI.aFrame.GetRepondId(result); 
//		String[] result = st.split("\\s");
//		s1.setFirstName(result[0]);
//		s1.setLastName(result[1]);
//		s1.setID(result[2]);
//		s1.setEmail(result[3]);
//		s1.setPhoneNum(result[4]);

	}

	/**
	 * This method handles all data coming from the UI
	 *
	 * @param message The message from the UI.
	 */

	public void handleMessageFromClientUI(String message) {
		try {
			openConnection();// in order to send more than one message
			awaitResponse = true;
			sendToServer(message);
			// wait for response
			while (awaitResponse) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			
			ClientUI.aFrame.thePortIsLBL.setText("No connection");
			ClientUI.aFrame.thePortIsLBL.setVisible(true);
			clientUI.display("Could not send message to server: Terminating client." + e);
			
		}
	}

	/**
	 * This method terminates the client.
	 */
	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}
}
//End of ChatClient class
