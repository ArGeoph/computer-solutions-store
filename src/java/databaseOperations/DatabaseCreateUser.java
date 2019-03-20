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

public class DatabaseCreateUser {
   public static DataSource dataSource;
   
   //createUser
    public static void createUser(String firstName, String lastName, String email,String login, 
            String password, String addressLine1, String addressLine2, String city, String province, 
            String postalCode, String phone) throws SQLException {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("jdbc/addressbook");
           
        }
        catch(Exception e) {
            e.printStackTrace();
        }
       // check whether dataSource was injected by the server
       if ( dataSource == null )
          throw new SQLException( "Unable to obtain DataSource" );

       // obtain a connection from the connection pool
       Connection connection = dataSource.getConnection();

       // check whether connection was successful
       if ( connection == null )
          throw new SQLException( "Unable to connect to DataSource" );

       try
       {           
           PreparedStatement addEntry = connection.prepareStatement("INSERT INTO USERS (firstName, lastName, email, login, password, addressLine1,"
                   + "addressLine2, city, province, postalCode, phone) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" );
           
           addEntry.setString( 1, firstName );
           addEntry.setString( 2, lastName );
           addEntry.setString( 3, email );
           addEntry.setString( 4, login );
           addEntry.setString( 5, password );
           addEntry.setString( 6, addressLine1 );
           addEntry.setString( 7, addressLine2 );
           addEntry.setString( 8, city );
           addEntry.setString( 9, province);
           addEntry.setString( 10, postalCode);
           addEntry.setString( 11, phone);

           addEntry.executeUpdate();
       }
       finally
       {
          connection.close(); // return this connection to pool
       } 
    } 
}
