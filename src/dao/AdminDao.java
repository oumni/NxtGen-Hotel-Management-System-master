package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.AdminModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao {
	
	private  Connection connect;
	private  Statement statement;
	private  ResultSet resultset;
	

    String url = "jdbc:mysql://127.0.0.1:3306/mydb?zeroDateTimeBehavior=convertToNull";
    String username = "root";
    String password = "";
    
    ObservableList<AdminModel> list = FXCollections.observableArrayList();

    
    public ObservableList<AdminModel> AfficherUtilisateurs()
    {
    	 try 
    	 {
 			connect = (Connection) DriverManager.getConnection(url, username, password);
 			String sql = "select * from utilisateur,reservation WHERE utilisateur.Id = reservation.idclient";
 			resultset =  connect.createStatement().executeQuery(sql);
 			
 			
 			while(resultset.next())
 			{
 	 			String id = resultset.getString("Id");
 	 			String login = resultset.getString("user");
 	 			String prenom = resultset.getString("Prenom");
 	 			String nom = resultset.getString("nom");
 	 			String email = resultset.getString("adresse");
 	 			String date = resultset.getString("datedenaissance");
 				list.add(new AdminModel(id,login,prenom,nom,email,date));
 	 			System.out.println(resultset.getInt(1)); 

 			}
 			

 	     }
    	 catch(SQLException e) 
    	 {
 	        System.out.println("Error creating connection to database: " + e);
    	 }
    	 
    	 return list;
    	 	 
    }
}
