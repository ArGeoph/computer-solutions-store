package onlineStoreBehavior;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import databaseOperations.*;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.*;
import java.sql.SQLException;
import javax.faces.bean.ManagedProperty; //for bean injection
import javax.sql.rowset.CachedRowSet;
import java.util.*;
import orderManagementSystem.*;
/**
 *
 * @author arnasay
 */
@ManagedBean( name = "renderContent")
@SessionScoped

public class RenderContent implements Serializable {
    private static DatabaseContentLoader databaseLoader = new DatabaseContentLoader();
    private static List<Computer> listOfAvailableComputers = new ArrayList<>();
    
    /**
     * @return the listOfAvailableComputers
     */
    public List<Computer> getListOfAvailableComputers() throws SQLException {
//        if (listOfAvailableComputers.isEmpty()) {
//            getContentFromDatabase("computers");
//        }
        return listOfAvailableComputers;
    }

    /**
     * @param listOfAvailableComputers the listOfAvailableComputers to set
     */
    public void setListOfAvailableComputers(List<Computer> listOfAvailableComputers) {
        this.listOfAvailableComputers = listOfAvailableComputers;
    }

    
    public CachedRowSet getContentFromDatabase(String type) throws SQLException {       
        
        CachedRowSet rowSet = databaseLoader.getComputerContent(type); 
        
        if (type.equals("computers") && getListOfAvailableComputers().isEmpty()) {            
           createListOfComputers(rowSet);
           return null;
        }        

        return rowSet;
    }
    
    private void createListOfComputers(CachedRowSet rowSet) throws SQLException  {
        while (rowSet.next()) {
            
            Computer computer = new Computer(rowSet.getInt("computerID"), rowSet.getString("name"), 
                    rowSet.getString("description"), rowSet.getString("pictureUrl"), rowSet.getString("url"),
                    rowSet.getInt("quantity"), rowSet.getInt("price"),
                   rowSet.getBoolean("isCustomizable"),  rowSet.getBoolean("isCustomized"));
            
            //Add components from database to computer components
            computer.components.put("cpu", String.valueOf(rowSet.getInt("cpuID")));
            computer.components.put("ram", String.valueOf(rowSet.getInt("ramID")));
            computer.components.put("hdd", String.valueOf(rowSet.getInt("hddID")));
            computer.components.put("videoCard", String.valueOf(rowSet.getInt("videoCardID")));
            computer.components.put("audioCard", String.valueOf(rowSet.getInt("audioCardID")));
            computer.components.put("display", String.valueOf(rowSet.getInt("displayID")));
            computer.components.put("os", String.valueOf(rowSet.getInt("osID")));
            
            //If computer is customizable add compatible components to the computer 
            if (rowSet.getBoolean("isCustomizable")) {
               String[] compatibleComponents = rowSet.getString("compatibleComponents").split("/");
                
               computer.compatibleComponents.put("cpu", compatibleComponents[0].split(","));
             computer.compatibleComponents.put("ram", compatibleComponents[1].split(","));
                computer.compatibleComponents.put("hdd", compatibleComponents[2].split(","));
                computer.compatibleComponents.put("videoCard", compatibleComponents[3].split(","));
              computer.compatibleComponents.put("audioCard", compatibleComponents[4].split(","));
              computer.compatibleComponents.put("display", compatibleComponents[5].split(","));
               computer.compatibleComponents.put("os",compatibleComponents[6].split(","));
//                cpuID[3, 4]; ramID: [2, 3]; hddID: [2, 3, 4, 5, 6]; audioCardID: [9, 10]; 
//                //videoCardID: [6, 7]; displayID: [2, 3, 4]; OSID: [2, 3]
////                1, 2, 3/1, 2, 3/1, 2, 3/0, 1/0, 1/1, 2, 3/1, 2, 4
            }
            else {
                 computer.compatibleComponents.put("none", null);
            }
            
            getListOfAvailableComputers().add(computer);
        }
    }
}