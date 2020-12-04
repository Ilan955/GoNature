package GUI;



import Client.*;
import GUI.*;
import Server.ServerUI;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.*;
import java.sql.*;

public class baseGuiController {
private ClientController cl;
public boolean waitresponse = false;
	@FXML
	private Button SubButton;

	@FXML
	private Button connectivity;

	@FXML
	private TextField newEmail;

	@FXML
	private Button updateVisitor;
	
	   @FXML
	    private TextField findID;
	   @FXML
	    private Label WelcomeLBL;

	@FXML
	private TextField firstDISP;

	@FXML
	private TextField phoneDISP;

	@FXML
	private TextField lastDISP;

	@FXML
	private TextField emailDISP;
	
	@FXML
	   public Label thePortIsLBL=null;

	 @FXML
	   private Label theIPISLBL=null;

	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("baseGUI.fxml"));
		Image icon = new Image(getClass().getResourceAsStream("titleIcon.png"));
		primaryStage.getIcons().add(icon);
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("baseGui.css").toExternalForm());
		primaryStage.setTitle("Prototypee");
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
		
	}

	@FXML
	void connectivity(ActionEvent event) {
		String s = "connectivity";
		
		ClientUI.aFrame=this;
		ClientUI.chat.accept(s);
	}

	@FXML
	void submitVisitor(ActionEvent event) {
		StringBuffer sb = new StringBuffer();
		/*Appending to the massege that will be send in the first line 
		what type of action will need to commit in server
		*/
		sb.append("submitVisitor");
		ClientUI.aFrame=this;
		String id = findID.getText();
		if(id.equals(""))
			this.findID.setText("EnterID");
		else {
			sb.append(" ");
			sb.append(id);
			String res= sb.toString();
			ClientUI.chat.accept(res);
		}
		
			
	}
	
	
	
	public void GetRepondId(String[] msg) {
		//this methods called after getting the data back from the server.
		if(msg==null) {
			this.findID.setText("InvalidID");
			
		}
		else {
			this.firstDISP.setText(msg[0]);
			this.lastDISP.setText(msg[1]);
			this.emailDISP.setText(msg[3]);
			this.phoneDISP.setText(msg[4]);	
			waitresponse =true;
		}
		
		
	}

	@FXML
	void updateVisitor(ActionEvent event) {
		if(!(waitresponse))
			newEmail.setText("First enter id");
		else {
			StringBuffer sb = new StringBuffer();
			
			
			String email = newEmail.getText();
			String[] check= email.split("@");
			if(check.length==1) {
				 Alert a = new Alert(AlertType.NONE,"You must enter valid email"); 
				 a.setAlertType(AlertType.ERROR);
				 a.show();
			}
			else {
				sb.append("updateVisitor");
				sb.append(" ");
				sb.append(findID.getText());
				sb.append(" ");
				sb.append(email);
				String res= sb.toString();
				ClientUI.chat.accept(res);
			}
			
		}
	}

	public void displayConnection(String[] result) {
		System.out.println(result[0]);
		 String s = "The Port Is : "+result[0];
		 System.out.println(s);
		 Platform.runLater(new Runnable() {
			  @Override
			  public void run() {
				  thePortIsLBL.setVisible(true);
				  theIPISLBL.setVisible(true);
				  thePortIsLBL.setText("The port is: "+result[0]); 
				  theIPISLBL.setText("The host is: "+result[1]);
				  
			  }
			});
		
		
	
	}

}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public void Send(ActionEvent event) throws Exception {
//		String id;
//		FXMLLoader loader = new FXMLLoader();
//
//		id = getID();
//		if (id.trim().isEmpty()) {
//
//			System.out.println("You must enter an id number");
//		} else {
//			ClientUI.chat.accept(id);
//
//			if (ChatClient.s1.getId().equals("Error")) {
//				System.out.println("Student ID Not Found");
//
//			} else {
//				System.out.println("Student ID Found");
//				((Node) event.getSource()).getScene().getWindow().hide(); // hiding primary window
//				Stage primaryStage = new Stage();
//				Pane root = loader.load(getClass().getResource("/gui/StudentForm.fxml").openStream());
//				StudentFormController studentFormController = loader.getController();
//				studentFormController.loadStudent(ChatClient.s1);
//
//				Scene scene = new Scene(root);
//				scene.getStylesheets().add(getClass().getResource("/gui/StudentForm.css").toExternalForm());
//				primaryStage.setTitle("Student Managment Tool");
//
//				primaryStage.setScene(scene);
//				primaryStage.show();
//			}
//		}
//	}
//
//	public void getExitBtn(ActionEvent event) throws Exception {
//		System.out.println("exit Academic Tool");
//	}
//
//	public void loadStudent(Student s1) {
//		this.sfc.loadStudent(s1);
//	}
//
//	public void display(String message) {
//		System.out.println("message");
//
//	}
//
//}
