// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package Server;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

import Client.ClientUI;
import logic.*;
import OCSF.server.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

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
	private Connection conn;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port The port number to connect on.
	 * 
	 */
	public static PreOrderTraveller[] preOrderTravellers = new PreOrderTraveller[5];

	public EchoServer(int port) {
		super(port);
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
//      will decrypte what type of action the server need to do
//      using switch case to simplify the actions the server will make
//      every time the first place in the string array will tell what type of method to triger.
		
		
		int flag=0;
		String st = (String)msg;
		String[] user = null;
		String action =getAction(st);
		String[] result= DecrypteMassege(st);
		System.out.println(action);
		switch (action) {
		
		case "submitVisitor":
			user = CheckForId(result[0]);
			StringBuffer sb = new StringBuffer();
		    for(int i = 0; i < user.length; i++) {
		         sb.append(user[i]);
		         sb.append(" ");
		      }
		      String str = sb.toString();
		      System.out.println(str);
		      this.sendToAllClients(str);
			break;
		case "updateVisitor":
			
			if(updateEmail(result)) {
				user = CheckForId(result[0]);
				StringBuffer sb1 = new StringBuffer();
			    for(int i = 0; i < user.length; i++) {
			         sb1.append(user[i]);
			         sb1.append(" ");
			      }
			      String str2 = sb1.toString();
			      System.out.println(str2);
			      this.sendToAllClients(str2);
			}
			break;	
		case "connectivity":
			StringBuffer sb2 = new StringBuffer();
			sb2.append(getPort());
			sb2.append(" ");
			sb2.append(client);
			String s = sb2.toString();
			this.sendToAllClients(s);
			break;
			
		default:	
			System.out.println("Sorry, don't know what you pressed");
		
		}
		
			
		
		
		
	}
	
	
public String[] CheckForId(String msg) {
	Statement stm;
	String[] s = new String[5];
	try {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM project.visitors WHERE ID=?");
		stm = conn.createStatement();
		ps.setString(1, msg);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
 		{
			 
			 s[0]=rs.getString(1);
			 s[1]=rs.getString(2);
			 s[2]=rs.getString(3);
			 s[3]=rs.getString(4);
			 s[4]=rs.getString(5);
			
		} 
		for(int i =0;i<5;i++)
			System.out.println(s[i]+"\n");
		
		
		
	}catch(SQLException e) {e.printStackTrace();}
	return s;
}

public String[] DecrypteMassege(String msg) {
	String[] gotFromClient = msg.split(" ");
	String[] res= new String[gotFromClient.length-1];
    for(int i = 1; i <gotFromClient.length; i++) {
       res[i-1]=gotFromClient[i];
    }
    return res;
    
}

public String getAction(String msg) {
	String[] result = msg.split(" ");
	return result[0];
}


public boolean updateEmail(String[] msg) {
	Statement stm;
	try {
		PreparedStatement ps = conn.prepareStatement("UPDATE project.visitors SET email=? WHERE ID=?");
		ps.setString(1, msg[1]);
		ps.setString(2, msg[0]);
		ps.executeUpdate();
		return true;
	}catch (SQLException e) {e.printStackTrace();
								return false;}
	
	
	
}



	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());
		
		
		try 
		{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
           // System.out.println("Driver definition succeed");
        } catch (Exception ex) {
        	/* handle the error*/
        	 System.out.println("Driver definition failed");
        	 }
        
        try 
        {
             conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project?serverTimezone=IST","root","");
            System.out.println("Successfuly loged-in");

	}catch (SQLException ex) 
 	    {/* handle any errors*/
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
        }
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
