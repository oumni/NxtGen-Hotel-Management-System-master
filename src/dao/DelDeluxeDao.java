package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.DeluxeModel;

public class DelDeluxeDao {
	private  Connection connect;
	private  Statement statement;
	private  ResultSet resultset;
	
    private String url = "jdbc:mysql://localhost/mydb";
    private String username = "root";
    private String password = "";
    
    public DeluxeModel del(DeluxeModel deluxemodel)
    {
    	//Get a connection
        try {
                  connect = DriverManager.getConnection(url, username, password);
            }
        catch(SQLException e) 
        {
                  System.out.println("Error creating connection to database");
        }
        String sql = "DELETE FROM rprojectdeluxe where drromno =?";
   	  try(PreparedStatement statement = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
   	  {
   		  statement.setString(1, deluxemodel.getDroomno());
          statement.executeUpdate();
          System.out.println(statement.getUpdateCount());


   	  } catch(SQLException e){
   		deluxemodel = null;
             System.out.println("Error Creating");
         }
   	  
      try {
          connect.close();
          connect = null;
      } catch(SQLException e) {
          System.out.println("Error closing connection");
      }
 return deluxemodel;

     }
    	
    }


