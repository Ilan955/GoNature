package GUI;
import GUI.*;
import Client.*;
import Server.ServerUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class PortController {
	    @FXML
	    private TextField portNum;
	    
	    private String getport() {
			return portNum.getText();			
		}
	    @FXML
	    void whenSubmitPort(ActionEvent event) {
	    	String p;
			
			p=getport();
			if(p.trim().isEmpty()) {
				System.out.println("You must enter a port number");
						
			}
			else
			{
				((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				ServerUI.runServer(p);
			}
	    	
	    }
	    public void start(Stage primaryStage) throws Exception {	
			Parent root = FXMLLoader.load(getClass().getResource("loginPort1.fxml"));
					
			Scene scene = new Scene(root);
			primaryStage.setTitle("Port");
			primaryStage.setScene(scene);
			primaryStage.show();		
		}

}
