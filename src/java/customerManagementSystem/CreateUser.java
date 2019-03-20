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

@ManagedBean( name = "createUser")
@SessionScoped 
/**
 *
 * @author arnasay
 */
public class CreateUser {  
    private String firstName; 
    private String lastName; 
    private String email; 
    private String login;     
    private String phone; 
    private String password1 = "";    
    private String password2 = ""; 
    private String passwordErrorMessage = "";
    private String address1; 
    private String address2; 
    private String city; 
    private String province = "AB"; 
    private String postalCode; 
    
    
    public String checkIfPasswordsMatch() {
        if (!password1.equals(password2)) {
            passwordErrorMessage = "Passwords do not match! Please check your input";

            return null;
        }
        else {
            passwordErrorMessage = "";

            return null;
        }
    }
  
    
    public String createUser() {
        //check again if passwords match
        try {
            DatabaseCreateUser.createUser(firstName, lastName, email, login, password2, address1, 
                address2, city, province, postalCode, phone);
        }
        catch(SQLException e) {                
            e.printStackTrace();
            return null;
        }

        return "registrationSuccess";
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

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
     /**
     * @return the password1
     */
    public String getPassword1() {
        return password1;
    }

    /**
     * @param password1 the password1 to set
     */
    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    /**
     * @return the password2
     */
    public String getPassword2() {
        return password2;
    }

    /**
     * @param password2 the password2 to set
     */
    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    /**
     * @return the address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * @param address1 the address1 to set
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * @return the address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2 the address2 to set
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }   
}