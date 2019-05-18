package application;

import java.io.IOException;

import controller.CommonMethods;
import controller.Server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
				
			FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/home.fxml"));
			AnchorPane root=(AnchorPane)loader.load();
			//Scene scene = new Scene(root,400,450);
			Scene scene = new Scene(root,1200,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.UNDECORATED);

			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	       try {
	            CommonMethods.server=new Server();
	        }catch (IOException e){
	            e.printStackTrace();
	        }

		launch(args);
	}
}
