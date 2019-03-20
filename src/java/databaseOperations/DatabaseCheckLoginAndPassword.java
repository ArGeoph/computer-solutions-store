package databaseOperations;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.sql.rowset.CachedRowSet;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arnasay
 */
@ManagedBean( name = "databaseCreaseUser")
@SessionScoped 

public class DatabaseCheckLoginAndPassword {
   public static DataSource dataSource;

   //createUser
    public static boolean checkLogin(String login) throws SQLException {    
       Connection connection = getConnection();
       
       try
       {     
           
           PreparedStatement checkUserCredentials = connection.prepareStatement("SELECT * FROM users WHERE login = '" + login + "'");
           CachedRowSet rowSet = new com.sun.rowset.CachedRowSetImpl();
           rowSet.populate(checkUserCredentials.executeQuery());
           
           if (rowSet.size() > 0) {//This means we have a user with the same login
               System.out.println("I'm here");              

               return true;
         
           }
           else {
               System.out.println("I'm there");
               return false;
           }
           
       }
       finally
       {
          connection.close(); // return this connection to pool

       }  
    }        
    
    public static CachedRowSet checkPassword(String login, String password) throws SQLException {     
       Connection connection = getConnection();
       
       try
       {     
           PreparedStatement checkUserCredentials = connection.prepareStatement("SELECT * FROM users WHERE login = \'" + login + "\'");
           CachedRowSet rowSet = new com.sun.rowset.CachedRowSetImpl();
           rowSet.populate(checkUserCredentials.executeQuery());
           
           if (rowSet.size() > 0) {//This means we have a user with the same login
               while (rowSet.next()) {
                   if (password.equals(rowSet.getString("password"))) {
                       return rowSet;
                   }
               }                
           }
           else {
               return null;
           }           
       }
       finally
       {
          connection.close(); // return this connection to pool
       } 
       
       return null;
    }    
    
    //Get database connection
    public static Connection getConnection() throws SQLException {
   
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("jdbc/addressbook");           
        }
        catch(Exception e) {
            e.printStackTrace();
        }
       // check whether dataSource was injected by the server
        if ( dataSource == null ) {
            throw new SQLException( "Unable to obtain DataSource" );
        }
       // obtain a connection from the connection pool
        Connection connection = dataSource.getConnection();

       // check whether connection was successful
       if ( connection == null ) {
          throw new SQLException( "Unable to connect to DataSource" );
       }  
       
       return connection;
    }
}
