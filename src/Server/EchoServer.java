// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package Server;

import java.io.*;
import java.util.Vector;
import logic.*;
import OCSF.server.*;

/**
 * This class overrides some of the methods in the abstract superclass in order
 * to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */

public class EchoServer extends AbstractServer {
	final public static int DEFAULT_PORT = 5555;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port The port number to connect on.
	 * 
	 */
	public static PreOrderTraveller[] preOrderTravellers = new PreOrderTraveller[5];

	public EchoServer(int port) {
		super(DEFAULT_PORT);
	}

	// Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg    The message received from the client.
	 * @param client The connection from which the message originated.
	 * @param
	 */
	public void handleMessageFromClient(Object msg, ConnectionToClient client) {
		int flag = 0;
		System.out.println("Message received: " + msg + " from " + client);
		for (int i = 0; i < 4; i++) {
			if (preOrderTravellers[i].getID().equals(msg)) {
				System.out.println("Server Found");
				this.sendToAllClients(preOrderTravellers[i].toString());
				flag = 1;
			}

		}
		if (flag != 1) {
			System.out.println("Not Found");
			this.sendToAllClients("Error");
		}
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());
//		preOrderTravellers[0] = new PreOrderTraveller("Omri", "Cohen", "204586507", "omric12@gmail.com", "0503440083");
//		preOrderTravellers[1] = new PreOrderTraveller("Tal", "Langer	", "205718588", "123.tallanger@gmail.com", "0505551801");
//		preOrderTravellers[2] = new PreOrderTraveller("Bar", "Elhanati", "312238645	", "elhanati.bar@gmail.com", "0526619871");
//		preOrderTravellers[3] = new PreOrderTraveller("Liad", "Yadin", "313590200	", "Liadyadin8@gmail.com	", "0525788002");
//		preOrderTravellers[4] = new PreOrderTraveller("Ilan", "Alexandrov", "315675322", "ilan19555@gmail.com", "0547281702");
	}

	/**
	 * This method overrides the one in the superclass. Called when the server stops
	 * listening for connections.
	 */
	protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
	}
}
//End of EchoServer class
