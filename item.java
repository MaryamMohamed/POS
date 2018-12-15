/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 1300180
 */
public class item implements Serializable {
        private String itemName;
    private String itemID;
    private double itemPrice;
    private Date itemExpiredDate;
    private int quantity;
    
    FileManger  FManager  = new FileManger ();        
    private final String itemsFileName = "items.txt";
    
    public static ArrayList <item> items = new ArrayList <item>();

    public item() {    }
    
    //Constructor
    public item(String itemName, String itemID, double itemPrice, Date itemExpiredDate,int quantity){
        this.itemName = itemName;
        this.itemID = itemID;
        this.itemPrice = itemPrice;
        this.itemExpiredDate = itemExpiredDate;
        this.quantity = quantity;
    }
    
//setters
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemID(String itemID) {
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

    public String getItemID() {
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
    
    //Methods
    
    public boolean additem() {
        
//        if(FManager.write( GetitemData(),itemsFileName, true))
//            return true;
//        else
//            return false;
        loadFromFile();
        items.add(this);
        return commitToFile();
        
                
    }  
    
    public boolean commitToFile() {
        return FManager.write(items.get(0).GetitemData(), itemsFileName, false);/////////////////ناقصة
    }
    
    //////////////////
    public void loadFromFile() {
        items = (ArrayList<item>) (Object) FManager.read(itemsFileName);
    }
    
    private int getItemIndex(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemID().equals(id)) {
                return i;
            }
        }
        return -1;
    }
    
    public item searchItemById(String id) {
        item temp = new item();
        loadFromFile();
        int index = getItemIndex(id);
        if (index != -1) {
            return items.get(index);
        } else {
            return temp;
        }
    }
    
    public ArrayList<item> listItems() {
        loadFromFile();
        return items;
    }
    
    public boolean updateItem() {
        loadFromFile();
        int index = getItemIndex(this.itemID);
        if (index != -1) {
            items.set(index, this);
            return commitToFile();
        }
        return false;
    }
    
    public boolean deleteCourse(String id) {
        loadFromFile();
        int index = getItemIndex(id);
        if (index != -1) {
            items.remove(index);
            return commitToFile();
        }
        return false;
    }
       private String GetitemData(){
        return this.itemID + "@" + this.itemName  + "@" + this.itemPrice + "@" + this.itemExpiredDate + "@" + this.quantity;
    }
    
    
    
    
    
    
    
    
    
//    public ArrayList<item> listitem(){
//        loadfromFile();
//        return items;
//    }
////using array list items is faster in searching than searching in a file
//    private void loadfromFile() {
//        items = (ArrayList<item>)(Object) FManager.read(itemsFileName);
//    }
////for loop to search if the id of the item is found in the array list if found it will return 0 else it will return -1
//    private int getItemIndex (int ID){
//        for (int i=0; i<items.size(); i++)
//            if (items.get(i).getItemID() == ID)
//                return i;
//    return -1;
//    }
////Method to search for the item if it was found in getItemindex so it will have index else it will have -1 
//        public String searchbyitem(int ID){
//            loadfromFile();
//            int index = getItemIndex(ID);
//            if (index != -1)
//                return "\nFOUND" + items.get(index).toString();
//            else
//                return "\nNOT FOUND"; 
//    }
//        
//       
//        public String displayAllgitems() {
//        loadfromFile();
//        String S = "\nAll item Data:\n";
//        for (item x : items) {
//            S = S + x.toString();
//        }
//        return S;
//    }
//  
//        private String GetitemData(){
//        return this.itemID + "@" + this.itemName  + "@" + this.itemPrice + "@" + this.itemExpiredDate + "@" + this.quantity;
//    }
}
