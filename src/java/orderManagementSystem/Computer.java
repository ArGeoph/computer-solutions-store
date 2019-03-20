/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderManagementSystem;
import java.io.Serializable;
import java.util.*;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author arnasay
 */
@SessionScoped
public class Computer implements Serializable {

    private int computerID; //Equal to computer ID in database
    private String name; //Equal to computer ID in database
    private String description; //Equal to computer ID in database
    private String pictureUrl; //Equal to computer ID in database
    private String computerUrl; //Equal to computer ID in database
    private int quantityAvailable; //Equal to computer ID in database
    private int price; //Equal to computer ID in database
    public Map<String, String> components = new HashMap<>(); //Computer components
    public Map<String, String[]> compatibleComponents = new HashMap<>(); //Compatible components
    private boolean isCustomizable;
    private boolean isCustomized;
    private int quantitySelected = 0;
    
    
    public Computer(int computerID, String name, String description, String pictureUrl, String computerUrl, int quantityAvailable, int price, boolean isCustomizable, boolean isCustomized) {
        this.computerID = computerID;
        this.name = name;
        this.description = description;
        this.pictureUrl = pictureUrl;
        this.computerUrl = computerUrl;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
        this.isCustomizable = isCustomizable;
        this.isCustomized = isCustomized;        
    }    
    
    
    /**
     * @return the quantitySelected
     */
    public int getQuantitySelected() {
        return quantitySelected;
    }

    /**
     * @param quantitySelected the quantitySelected to set
     */
    public void setQuantitySelected(int quantitySelected) {
        this.quantitySelected = quantitySelected;
    }
    
    /**
     * @return the compterUrl
     */
    public String getComputerUrl() {
        return computerUrl;
    }

    /**
     * @param compterUrl the compterUrl to set
     */
    public void setComputerUrl(String computerUrl) {
        this.computerUrl = computerUrl;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    
    /**
     * @return the pictureUrl
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * @param pictureUrl the pictureUrl to set
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
    /**
     * @return the isCustomizable
     */
    public boolean getIsCustomizable() {
        return isCustomizable;
    }

    /**
     * @param isCustomizable the isCustomizable to set
     */
    public void setIsCustomizable(boolean isCustomizable) {
        this.isCustomizable = isCustomizable;
    }

    /**
     * @return the isCustomized
     */
    public boolean isIsCustomized() {
        return isCustomized;
    }

    /**
     * @param isCustomized the isCustomized to set
     */
    public void setIsCustomized(boolean isCustomized) {
        this.isCustomized = isCustomized;
    }
    
    /**
     * @return the computerID
     */
    public int getComputerID() {
        return computerID;
    }

    /**
     * @param computerID the computerID to set
     */
    public void setComputerID(int computerID) {
        this.computerID = computerID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the quantityAvailable
     */
    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    /**
     * @param quantityAvailable the quantityAvailable to set
     */
    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the components
     */
    public Map<String, String> getComponents() {
        return components;
    }

    /**
     * @param components the components to set
     */
    public void setComponents(Map<String, String> components) {
        this.components = components;
    }

    /**
     * @return the compatibleComponents
     */
    public Map<String, String[]> getCompatibleComponents() {
        return compatibleComponents;
    }

    /**
     * @param compatibleComponents the compatibleComponents to set
     */
    public void setCompatibleComponents(Map<String, String[]> compatibleComponents) {
        this.compatibleComponents = compatibleComponents;
    }   
}
