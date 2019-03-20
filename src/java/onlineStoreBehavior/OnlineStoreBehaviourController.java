package onlineStoreBehavior;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
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
import javax.faces.context.ExternalContext;
import javax.sql.rowset.CachedRowSet;
import orderManagementSystem.*;
/**
 *
 * @author arnasay
 */
@ManagedBean( name = "onlineStoreBehaviourController")
@SessionScoped 

public class OnlineStoreBehaviourController implements Serializable {
    private int numberOfItemsInCart = 0; 
    private Cart cart;
    /**
     * @return the cart
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    
    public void loadComputersContent() throws SQLException {
        new RenderContent().getContentFromDatabase("computers");
    }
    
    public void addFeedback() {

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

        try {
            ec.redirect(ec.getRequestContextPath()
                    + "/feedbackAdded.xhtml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public void addToCart(Computer computer, int quantity) {
        if (computer.getQuantitySelected() != 0) {

            
            if(cart == null) { 
                cart = new Cart();
                cart.addToCart(computer, quantity);
                numberOfItemsInCart += quantity;
                System.out.println("1");
            }
            else {
                cart.addToCart(computer, quantity);
                System.out.println("2");
                numberOfItemsInCart += quantity;
            }
            
//            computer.setQuantitySelected(0);
        }
        
        System.out.println("3s");
    }
    
    /**
     * @return the itemsNumber
     */
    public int getNumberOfItemsInCart() {
        return numberOfItemsInCart;
    }

    /**
     * @param itemsNumber the itemsNumber to set
     */
    public void setNumberOfItemsInCart(int numberOfItemsInCart) {
        this.numberOfItemsInCart = numberOfItemsInCart;
    }
    
    public void incrementNumberOfItemsInCart() {
        this.numberOfItemsInCart++;
    }
    
    public boolean checkIfNoththingLeft(int itemsInStock) {
        return itemsInStock <= numberOfItemsInCart;
    } 
   
    
     public void setVisitsNumberCookie() {
        Cookie visitsNumberCookie = null; //Variable will be used to store the cookie with number of visits
        FacesContext currentContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) currentContext.getExternalContext().getRequest();
        
        //Request user cookies
        Cookie[] userCookies = request.getCookies();
        //Iterate through array with cookies to find a proper one
        if (userCookies != null) {
            for (Cookie cookieItem : userCookies) {
                if (("visitsNumber").equals(cookieItem.getName())) {//find a cookie with number of visits
                    visitsNumberCookie = cookieItem; 
                    break; //We found what we need so we can break the loop
                }
            }
        }
        
        //Check if desired cookie was found on user's machine and if it wasn't set a new cookie
        if (visitsNumberCookie != null) {
            int numberOfVisits = Integer.valueOf(visitsNumberCookie.getValue()); //Get number of visits from cookie
            visitsNumberCookie.setValue(String.valueOf(++numberOfVisits)); //Increment number of visits by 1 and update cookie value
        }
        else { //if no cookies were found create a new one and set numberOfVisits value to 1
            visitsNumberCookie = new Cookie("visitsNumber", "1");
        }
        
        visitsNumberCookie.setMaxAge(240*600*600); //Set max age of cookie to 10000 days 
        HttpServletResponse response = (HttpServletResponse) currentContext.getExternalContext().getResponse();
        
        //add cookie to server response
        response.addCookie(visitsNumberCookie);
    }
    
    public String getVisitsNumberCookie() {
        //First of all create cookie if there's no anything was created or update existing one
        setVisitsNumberCookie();
        
        
        Cookie visitsNumberCookie = null; //Variable will be used to store the cookie with number of visits
        FacesContext currentContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) currentContext.getExternalContext().getRequest();
        
        //Request user cookies
        Cookie[] userCookies = request.getCookies();
        //Iterate through array with cookies to find a proper one
        if (userCookies != null) {
            for (Cookie cookieItem : userCookies) {
                if (("visitsNumber").equals(cookieItem.getName())) {//find a cookie with number of visits
                    visitsNumberCookie = cookieItem; 
                    return visitsNumberCookie.getValue(); 
                }
            } 
        }      

        //If we reached this point it means that no cookies have been created before and we are visiting the website for the first time
        return "1";
    }
}
