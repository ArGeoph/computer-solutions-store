package orderManagementSystem;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import databaseOperations.*;
import java.io.Serializable;
import java.util.*;
import javax.sql.rowset.CachedRowSet;

@ManagedBean( name = "cart")
@SessionScoped 

public class Cart implements Serializable {
    private List<Computer> listOfItemsInCart = new ArrayList<>();
    private int total = 0;
    private int numberOfItemsInCart = 0;
    
    
    
    public void addToCart(Computer computer, int quantity)  {
        if (quantity > 0) {
            try {
                Computer computerInCart = (Computer) computer.clone(); //Clone computer object
        
                computerInCart.setQuantityAvailable(quantity);
                computer.setQuantityAvailable(computer.getQuantityAvailable() - quantity);//Update number of avalable computers
                listOfItemsInCart.add(computerInCart); //add new items to cart
                numberOfItemsInCart += quantity; //update number of items in cart 
                total += quantity*computer.getPrice();
            }
            catch(CloneNotSupportedException e) {
               
            }

        }     
    }    
    
    public void deleteFromCart(Computer computer, int quantity) throws CloneNotSupportedException {
        Computer computerInCart = (Computer) computer.clone(); //Clone computer object          
        computerInCart.setQuantityAvailable(quantity);
        computer.setQuantityAvailable(computer.getQuantityAvailable() - quantity);//Update number of avalable computers
        
        listOfItemsInCart.add(computerInCart); //add new items to cart
        numberOfItemsInCart += quantity; //update number of items in cart        
    }
    /**
     * @return the listOfItemsInCart
     */
    public List<Computer> getListOfItemsInCart() {
        return listOfItemsInCart;
    }

    /**
     * @param listOfItemsInCart the listOfItemsInCart to set
     */
    public void setListOfItemsInCart(List<Computer> listOfItemsInCart) {
        this.listOfItemsInCart = listOfItemsInCart;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the numberOfItemsInCart
     */
    public int getNumberOfItemsInCart() {
        return numberOfItemsInCart;
    }

    /**
     * @param numberOfItemsInCart the numberOfItemsInCart to set
     */
    public void setNumberOfItemsInCart(int numberOfItemsInCart) {
        this.numberOfItemsInCart = numberOfItemsInCart;
    }

    
    
    
    
}
