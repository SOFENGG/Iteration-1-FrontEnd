package POS;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Driver extends Application{
	
	private TextField usernameField = new TextField();
	private PasswordField passwordField = new PasswordField();
	private ArrayList<String> userArray = new ArrayList<String>();
	private ArrayList<String> passArray = new ArrayList<String>();
	private Label LabelUser = new Label("Username");
	private Label LabelPass = new Label("Password");
	private GridPane grid = new GridPane();
	private String[] userPass = new String[2];

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		userArray.add("Gary");
		passArray.add("1234");
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL); //Blocks access to other windows until this is closed
		window.setTitle("Cashier Login");
		window.setMinWidth(250);
		window.setResizable(false);
		
		Button LogInButton = new Button(" Log In  ");
		LogInButton.setOnAction(e ->  {
			userPass[0] = usernameField.getText();
			userPass[1] = passwordField.getText();
			if(userArray.contains(userPass[0]) && passArray.contains(userPass[1])){
				try {
					View gui = new View(primaryStage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				window.close();
			}
			else 
				displayAlertBox("yo", "Wrong Password/and or Username");
		});
		
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(10);
		grid.setHgap(8);
		
		
		GridPane.setConstraints(LabelUser, 0, 0);
		GridPane.setConstraints(usernameField, 1, 0);
		
		GridPane.setConstraints(LabelPass, 0, 1);
		GridPane.setConstraints(passwordField, 1, 1);
		GridPane.setConstraints(LogInButton, 2, 1);
		
		grid.getChildren().addAll(LabelUser, LabelPass, usernameField, passwordField, LogInButton);
		
		Scene scene = new Scene(grid);
		window.setScene(scene);
		window.showAndWait();
	}
	
	private void displayAlertBox(String title, String message) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL); //Blocks access to other windows until this is closed
		window.setTitle(title);
		window.setMinWidth(250);
		window.setResizable(false);
		
		Label label = new Label();
		label.setFont(Font.font("Arial", FontWeight.BLACK, 11));
		label.setText(message);
		Button closeButton = new Button("Close the window");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
