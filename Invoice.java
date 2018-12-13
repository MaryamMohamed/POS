/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import java.util.ArrayList;

/**
 *
 * @author 1300180
 */
public class Invoice {
    
    private int invoice_id;
private String customer_name;
private int customer_id;
private String employee_name;
private int employee_id;
private String item_name;
private double item_price;
private int item_quantity;
private final String invoiceFileName = "Invoices.txt";
public static ArrayList<Invoice> invoices = new ArrayList<Invoice>();

//constructors
FileManger  FManager  = new FileManger ();

public Invoice(){
}
    public Invoice(int invoice_id, String customer_name, int customer_id, String employee_name, int employee_id, String item_name, double item_price, int item_quantity) {   
        this.invoice_id = invoice_id;
        this.customer_name = customer_name;
        this.customer_id = customer_id;
        this.employee_name = employee_name;
        this.employee_id = employee_id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_quantity = item_quantity;
    }

//setter & getter
    public int getInvoice_id() {
        return invoice_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public double getItem_price() {
        return item_price;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }

//methods
//total
//public double total()
//{
//    double result=0;
//    for(int i=0;  ;i++)
//   {
//       result= (this.item_price * this.item_quantity)+ result;
//   }
//        return result;
//
//} 
    
//    public boolean commitToFile() {
//        return FManager.write(items_name, item_name, true)
//    }
    /*int invoice_id, String customer_name, int customer_id, String employee_name, int employee_id, String item_name, double item_price, int item_quantity*/
     private String getInvoiceData(){
        return this.customer_name + "@" + this.customer_name  + "@" + this.customer_id + "@" + this.employee_name + "@" + this.employee_id + "@" + this.item_name + "@" + this.item_price + "@" + this.item_quantity ;
    }
    
    
    public boolean addInvoice() {
        
        
        if(FManager.write( getInvoiceData(),invoiceFileName, true))
            return true;
        else
            return false;
        /*
        loadFromFile();
        Customers.add(this);
        return commitToFile();
                */
    }
    
    
    public void commitToFile() {
         FManager.write( invoices.get(0).GetInvoiceData(),invoiceFileName,false);
         for(int i=1; i<invoices.size();i++){
             FManager.write( invoices.get(i).GetInvoiceData(),invoiceFileName,true);
         }
        
    }
    public void loadFromFile() {
        invoices = (ArrayList<Invoice>) (Object) FManager.read(invoiceFileName);
    }


    private int getInvoiceIndex(int id) {
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getInvoice_id() == invoice_id) {
                return i;
            }
        }

        return -1;
    }
//display
    public String displayAllInvoices() {
        loadFromFile();
        String S = "\nAll Invoices Data:\n";
        for (Invoice x : invoices) {
            S = S + x.toString();
        }
        return S;
    }
//delete
     public void deleteCustomer(int id) {
        loadFromFile();
        int index = getInvoiceIndex(id);

        if (index != -1) 
            invoices.remove(index);
        commitToFile();
    }
     
     private String GetInvoiceData(){
        return  this.invoice_id + "@" + this.customer_name + "@" + this.customer_id  + "@" + this.employee_name + "@" + this.employee_id + "@" + this.item_name + "@" + this.item_price + "@" + this.item_quantity;
    }
}
