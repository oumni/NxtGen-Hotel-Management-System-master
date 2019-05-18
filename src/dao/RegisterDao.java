package dao;

import model.RegisterModel; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;


public class RegisterDao {
	
		private  Connection connect;
		private  Statement statement;
		private  ResultSet resultset;
	
	    String url = "jdbc:mysql://127.0.0.1:3306/mydb";
	    String username = "root";
	    String password = "";
	    
	   
	  public void insertUser(RegisterModel inscript) 
	  {
	  //Get a connection
	  try {
			connect = (Connection) DriverManager.getConnection(url, username, password);
	      }
	  catch(SQLException e) 
	  {
	            System.out.println("Error creating connection to database: " + e);
	  }
  
 
  
	  String sql = "INSERT INTO utilisateur (user,passcode,passVerif,Prenom,nom,adresse,datedenaissance) VALUES (?,?,?,?,?,?,?)";

      try(PreparedStatement statement = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
        	   //Set the parameters to the query
        	           // statement.setString(1, BillModel.getId());
        	            statement.setString(1, inscript.getLogin());
        	            statement.setString(2, inscript.getPass());
        	            statement.setString(4, inscript.getVerif());
        	            statement.setString(3, inscript.getPrenom());
        	            statement.setString(5, inscript.getNom());
        	            statement.setString(6, inscript.getEmail());
        	            statement.setString(7, inscript.getDate());


        	            //Execute the insert
        	            statement.executeUpdate();
        	            
        	            System.out.println("Rows inserted: "+statement.getUpdateCount());
        	            

			 Alert alert = new Alert(AlertType.INFORMATION);	 
			 alert.setTitle("Information Dialog");
			 alert.setHeaderText("Message");
			 alert.setContentText("utilisateur ajouté avec succes");
			 alert.showAndWait();  
        	            
        	     
        	            } catch(SQLException e){
        	            	inscript = null;
        	            System.out.println("Error Creatin hna"+e);
        	        }
        	  try {
                  connect.close();
                  connect = null;
              } catch(SQLException e) {
                  System.out.println("Error closing connection");
              }
}
}
