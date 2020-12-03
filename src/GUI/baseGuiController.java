package GUI;



import Client.*;
import GUI.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.*;
import java.sql.*;

public class baseGuiController {

	@FXML
	private Button SubButton;

	@FXML
	private Button connectivity;

	@FXML
	private TextField newEmail;

	@FXML
	private Button updateVisitor;

	@FXML
	private TextField newEmail1;

	@FXML
	private TextField firstDISP;

	@FXML
	private TextField phoneDISP;

	@FXML
	private TextField lastDISP;

	@FXML
	private TextField emailDISP;

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("baseGUI.fxml"));
		Scene scene = new Scene(root);
//		scene.getStylesheets().add(getClass().getResource("/GUI/AcademicFrame.css").toExternalForm());
		primaryStage.setTitle("Av Tipus");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	void connectivity(ActionEvent event) {
//Show server details
	}

	@FXML
	void submitVisitor(ActionEvent event) {
//Show visitor information by iD
		System.out.println("D");

	}

	@FXML
	void updateVisitor(ActionEvent event) {
//Enter new mail for visitor
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
