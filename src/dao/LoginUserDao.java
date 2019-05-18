package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.LoginUserModel;

public class LoginUserDao {
	
	private  Connection connect;
	private  Statement statement;
	private  ResultSet resultset;
	
	String admin_userstore="" ;	           
	String  admin_passstore="";
	
	    String url = "jdbc:mysql://127.0.0.1:3306/mydb";
	    String username = "root";
	    String password = "";
	    Boolean trouvé=false;
	   
 public LoginUserModel create(LoginUserModel LoginModel) throws SQLException 
 {
  //Get a connection
  try {
		connect = (Connection) DriverManager.getConnection(url, username, password);
      }
  catch(SQLException e) 
  {
            System.out.println("Error creating hhhhhconnection to database: " + e);
  }
		String username1=LoginModel.getLogin();
		String password1=LoginModel.getMotDePasse();
		statement=(Statement) connect.createStatement();
    	String query1 ="select user, passcode from mydb.utilisateur where ID='5'";
    	ResultSet rs1 = statement.executeQuery(query1);
    	 while (rs1.next()) {
    		admin_userstore = rs1.getString("user");	           
    		admin_passstore = rs1.getString("passcode");
    	 }
    	 
    	String query2 ="select user, passcode from mydb.utilisateur where ID='2'";
    	ResultSet rs2 = statement.executeQuery(query2);
    	 while (rs2.next()) {
    		String emp_userstore = rs2.getString("user");	           
    		String emp_passstore = rs2.getString("passcode");
    	 }
    	System.out.print("Hello "+admin_userstore+admin_passstore); 

    
           if(username1.equals(admin_userstore) && password1.equals(admin_passstore)){	         	  
        	   trouvé=true;
           }
           else {
          	 Platform.runLater(new Runnable() {
                  @Override
                  public void run() {
                    //  errorlabel.setText("Error! Incorrect Password Or Username");
                  }
              });
          	trouvé=false;
           
  
        	       System.out.println("login successful: "+statement.getUpdateCount());
        	            

 Alert alert = new Alert(AlertType.INFORMATION);	 
 alert.setTitle("Information Dialog");
 alert.setHeaderText("Bill Generation");
 alert.setContentText("Bill generated and saved in database");
 alert.showAndWait();  
     
        	  try {
                  connect.close();
                  connect = null;
              } catch(SQLException e) {
                  System.out.println("Error closing connection");
              }
}
		return LoginModel;

 }}
