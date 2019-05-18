package controller;

import model.RegisterModel;
import dao.RegisterDao;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class RegisterController extends CommonMethods{
	
	private Label errorlabel;
	
    @FXML
    private AnchorPane mainloginpane;

    @FXML
    private JFXTextField nomfield;

    @FXML
    private JFXButton registerbtn;

    @FXML
    private JFXProgressBar progressbar;

    @FXML
    private JFXButton minimisebtn;

    @FXML
    private JFXDatePicker datefield;
    
    @FXML
    private JFXButton closebtn;

    @FXML
    private JFXPasswordField passfield;

    @FXML
    private JFXPasswordField passfiel2;

    @FXML
    private JFXTextField prenomfield;

    @FXML
    private JFXTextField loginfield;

    @FXML
    private JFXTextField emailfield;

	    /*
	    @FXML
	    void handleClose(ActionEvent event) {

	    }

	    @FXML
	    void minimiseWindow(ActionEvent event) {

	    }*/

	    public void initialize(URL location, ResourceBundle resources) {
	        disableAllFocus(mainloginpane);
	        page="Register";
            
	        if (CommonMethods.loggedout) {
	            errorlabel.setText("Logged out successfully");
	            errorlabel.setVisible(true);
	            FadeTransition ft=new FadeTransition(Duration.millis(1200), errorlabel);
	            ft.setFromValue(0);
	            ft.setToValue(1);
	            ft.play();
	            ft.setOnFinished(event -> {
	                FadeTransition f=new FadeTransition(Duration.millis(1200), errorlabel);
	                f.setFromValue(1);
	                f.setToValue(0);
	                f.play();
	                f.setOnFinished(event1 -> {
	                    errorlabel.setText("Error! Incorrect Password Or Username");
	                    errorlabel.setVisible(false);
	                });
	            });
	            CommonMethods.loggedout=false;
	        } 

	        customiseWindowButtons(closebtn,minimisebtn);
	        registerbtn.setOnMouseEntered(e -> {
	        	registerbtn.setStyle("-fx-background-color: #FF9A00;");
	        	registerbtn.setEffect(new Bloom(0.85));
	        });
	        	registerbtn.setOnMouseExited(e -> {
	        	registerbtn.setStyle("-fx-background-color:  #FF5722;");
	        	registerbtn.setEffect(new Bloom(1));
	        });

	       /*  errorlabel.setOnMouseReleased(event -> showDialog());
	        moveWindow(mainloginpane);
	        userfield.setOnKeyPressed(event -> fieldListners(event));
	        passfield.setOnKeyPressed(event -> fieldListners(event));*/
	    }


	    @FXML
	    void inscription(ActionEvent event) {
	    	if(passfield.getText().equals(passfiel2.getText()))
	    	{
		    	RegisterModel I = new RegisterModel(loginfield.getText(),passfield.getText(),passfiel2.getText(),prenomfield.getText(),nomfield.getText(),emailfield.getText(),datefield.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		    	RegisterDao d = new RegisterDao();
		    	d.insertUser(I);
	    	}
	    	else
	    	{
	    		 Alert alert = new Alert(AlertType.INFORMATION);	 
				 alert.setTitle("Information Dialog");
				 alert.setHeaderText("erreur mot de passe");
				 alert.setContentText("veuillez resaisir le mot de passe");
				 alert.showAndWait();  
	    	}

	    	
	    }


}
