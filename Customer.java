/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import java.util.ArrayList;
import java.io.*;
/**
 *
 * @author 1300180
 */
public class Customer extends person{
//////////////
   
     ////////////
    public enum Payment{
         Cash("Customer Cash With Cash"), Credite("Customer Pay With Credite");
         String Pay;
         private Payment(String Pay){
             this.Pay= Pay;
             
         }
    }
    
    public Customer(){
        
    }
    
    public Customer(int ID, String FristName, String LastName, String adress, String PhoneNumber, String pass) {
        super( ID, FristName, LastName, adress, PhoneNumber, pass);
    }
      private final String CustomerFileName = "Customers.txt";
      public static ArrayList<Customer> Customers = new ArrayList<Customer>();


    public boolean addCustomer() {
        
        if(FManager.write( GetCustomertData(),CustomerFileName, true))
            return true;
        else
            return false;
        /*
        loadFromFile();
        Customers.add(this);
        return commitToFile();
                */
    }
    //ID, FristName, LastName, adress, PhoneNumber, pass
    private String GetCustomertData(){
        return this.ID + "@" + this.FristName  + "@" + this.LastName + "@" + this.PhoneNumber + "@" + this.adress;
    }
    
public void loadFromFile() {
        Customers = (ArrayList<Customer>) (Object) FManager.read(CustomerFileName);
    }

 private int getCustomerIndex(int id) {
        for (int i = 0; i < Customers.size(); i++) {
            if (Customers.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
    }
     public Customer searchCustomerById(int id) {
        Customer temp = new Customer();
        loadFromFile();
        int index = getCustomerIndex(id);
        if (index != -1) {
            return Customers.get(index);
        } else {
            return temp;
        }
    }

 
//  public String searchCustomers(int id) {
//        loadFromFile();
//        int index = getCustomerIndex(id);
//        if (index != -1) {
//            return "\nFound ...!" + Customers.get(index).toString();
//        } else {
//            return "\nNot Found ...!";
//        }
//    }
  
  public String displayAllgCustomers() {
        loadFromFile();
        String S = "\nAll Student Data:\n";
        for (Customer x : Customers) {
            S = S + x.toString();
        }
        return S;
    }
  
  
    public void updateCustomer(int oldID, Customer x) {
        loadFromFile();
        int index = getCustomerIndex(oldID);

//        if (index != -1) 
            Customers.set(index, x);

            commitToFile();
        }
    
    
    public void deleteCustomer(int id) {
        loadFromFile();
        int index = getCustomerIndex(id);

        if (index != -1) 
            Customers.remove(index);

             commitToFile();
        

       
    }
  
    public void commitToFile() {
         FManager.write( Customers.get(0).GetCustomertData(),CustomerFileName,false);
         for(int i=1; i<Customers.size();i++){
             FManager.write( Customers.get(i).GetCustomertData(),CustomerFileName,true);
         }
        
    }

    @Override
    
    public String toString() {
        return "\nI'm Eng : " + FristName + " "+ LastName + " "  + "\n" + "ID : " +  ID + " PhoneNumber : " + PhoneNumber + "\n"
                + "Adress : " +  adress +  "\n";
    }
    
    

}
