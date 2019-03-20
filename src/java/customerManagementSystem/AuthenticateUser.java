/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerManagementSystem;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import databaseOperations.*;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.sql.rowset.CachedRowSet;

@ManagedBean( name = "authenticateUser")
@SessionScoped 
/**
 *
 * @author arnasay
 */
public class AuthenticateUser implements Serializable  {  
    private String login;
    private String password;
    private boolean isUserAuthenticated = false;
    private CachedRowSet userInfo;
    private String loginErrorMessage = "";
    private String passwordErrorMessage = "";
    
    public String authenticateUser() throws SQLException {
        
       if (DatabaseCheckLoginAndPassword.checkLogin(login)) {
           userInfo = DatabaseCheckLoginAndPassword.checkPassword(login, password);
           
           if (userInfo != null) {
               isUserAuthenticated = true;
               loginErrorMessage = "";
               passwordErrorMessage = "";
               System.out.println("1");
               
               return "index";
           }
           else {
               System.out.println("2");
               loginErrorMessage = "";
               passwordErrorMessage = "Password is incorrect. Try again";
               
               return null;
           }
       }
       else {
            loginErrorMessage = "Login is incorrect. Try again";
            password = "";
            System.out.println("3");
            
            return null;
       }
    }
    
    /**
     * @return the loginErrorMessage
     */
    
    public void logout() {
        isUserAuthenticated = false;
        userInfo = null;
        
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        
        try {
            ec.redirect(ec.getRequestContextPath()
                    + "/index.xhtml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    
    
    
    public String getLoginErrorMessage() {
        return loginErrorMessage;
    }

    /**
     * @param loginErrorMessage the loginErrorMessage to set
     */
    public void setLoginErrorMessage(String loginErrorMessage) {
        this.loginErrorMessage = loginErrorMessage;
    }   
    
    /**
     * @return the isUserAuthenticated
     */
    public boolean isIsUserAuthenticated() {
        return isUserAuthenticated;
    }

    /**
     * @param isUserAuthenticated the isUserAuthenticated to set
     */
    public void setIsUserAuthenticated(boolean isUserAuthenticated) {
        this.isUserAuthenticated = isUserAuthenticated;
    }

    /**
     * @return the rowSet
     */
    public CachedRowSet getUserInfo() {
        return userInfo;
    }

    /**
     * @param rowSet the rowSet to set
     */
    public void setUserInfo(CachedRowSet rowSet) {
        this.userInfo = rowSet;
    } 
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

 
    
    /**
     * @return the passwordErrorMessage
     */
    public String getPasswordErrorMessage() {
        return passwordErrorMessage;
    }

    /**
     * @param passwordErrorMessage the passwordErrorMessage to set
     */
    public void setPasswordErrorMessage(String passwordErrorMessage) {
        this.passwordErrorMessage = passwordErrorMessage;
    }   
}