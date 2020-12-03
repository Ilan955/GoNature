package Client;

import javafx.application.Application;

import javafx.stage.Stage;
import logic.*;

import java.util.Vector;
import GUI.*;

public class ClientUI extends Application {
	public static ClientController chat; // only one instance
	public  static baseGuiController aFrame;
	
	public static void main(String args[]) throws Exception {
		launch(args);
	} // end main

	@Override
	public void start(Stage primaryStage) throws Exception {
		chat = new ClientController("localhost", 5555);
		aFrame=new baseGuiController();
		aFrame.start(primaryStage);
		
	}

}
