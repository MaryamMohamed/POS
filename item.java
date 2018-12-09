/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itemstablefxjava;


import fileManger.filemanager;
import java.util.ArrayList;
import java.util.Date;


public class item {
    private String itemName;
    private int itemID;
    private double itemPrice;
    private Date itemExpiredDate;
    private int quantity;
    private final String itemsFileName = "items.txt";
    public static ArrayList <item> items = new ArrayList <item>();
    //setters
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemExpiredDate(Date itemExpiredDate) {
        this.itemExpiredDate = itemExpiredDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    //getters
    public String getItemName() {
        return itemName;
    }

    public int getItemID() {
        return itemID;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public Date getItemExpiredDate() {
        return itemExpiredDate;
    }

    public int getQuantity() {
        return quantity;
    }
    //Constructor
    public item(String itemName, int itemID, double itemPrice, Date itemExpiredDate,int quantity){
        this.itemName = itemName;
        this.itemID = itemID;
        this.itemPrice = itemPrice;
        this.itemExpiredDate = itemExpiredDate;
        this.quantity = quantity;
    }
    //Methods
    public ArrayList<item> listitem(){
        loadfromFile();
        return items;
    }
//using array list items is faster in searching than searching in a file
    private void loadfromFile() {
        items = (ArrayList<item>)(Object) filemanager.openToRead(itemsFileName);
    }
//for loop to search if the id of the item is found in the array list if found it will return 0 else it will return -1
    private int getItemIndex (int ID){
        for (int i=0; i<items.size(); i++)
            if (items.get(i).getItemID() == ID)
                return i;
    return -1;
    }
//Method to search for the item if it was found in getItemindex so it will have index else it will have -1 
        public String searchbyitem(int ID){
            loadfromFile();
            int index = getItemIndex(ID);
            if (index != -1)
                return "\nFOUND" + items.get(index).toString();
            else
                return "\nNOT FOUND"; 
    }
}
