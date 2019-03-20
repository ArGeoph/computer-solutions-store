package databaseOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import javax.faces.context.*;
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
@ManagedBean( name = "databaseContentLoader")
@SessionScoped 

public class DatabaseContentLoader {
   DataSource dataSource;
   
   // return a ResultSet of entries
    public CachedRowSet getComputerContent(String type) throws SQLException {
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
           
           PreparedStatement databaseQuery;
           if (type.equals("computers")) {
               databaseQuery = connection.prepareStatement("SELECT * FROM computers" );
           }
           else if (type.equals("cpu") || type.equals("ram") || type.equals("hdd") 
                   || type.equals("display") || type.equals("os") || type.equals("audiocard")
                   || type.equals("videocard")) {
               databaseQuery = connection.prepareStatement("SELECT * FROM " + type );
           }
           else {
               throw new IllegalArgumentException();
           }

          CachedRowSet rowSet = new com.sun.rowset.CachedRowSetImpl();
          rowSet.populate(databaseQuery.executeQuery());

          return rowSet;
       }
       finally
       {
          connection.close(); // return this connection to pool
       } 
    } 
}
