/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author 1300180
 */
public class Admin  extends person{

    public Admin() {

    }

    public Admin(int ID, String FristName, String LastName, String adress, String PhoneNumber, String pass) {
        super(ID, FristName, LastName, adress, PhoneNumber, pass);
    }

    @Override
    public String toString() {
        return "\nI'm Admin : " + FristName + " "+ LastName + " "  + "\n" + "ID : " +  ID + " PhoneNumber : " + PhoneNumber + "\n" + "Adress : " +  adress +  "\n"+ "\t Password: " + pass + "\n";
    }
    
    
//    @Override
//    public boolean login(String userName, String Pass) {
//
//        if (userName.equals("Admin@yahoo.com") && Pass.equals("1234")) {
//            return true;
//        }
//        return false;
//
//    }
    
    
//    public void addNewCustomer(int ID, String FristName, String LastName, String adress, String PhoneNumber, String pass) {
//       Customer x = new Customer(ID, FristName, LastName, adress,PhoneNumber, pass);
//        if (x.addCustomer()) {
//            System.out.println(x.toString() + "Added Successfully");
//        } else {
//            System.out.println("Failed to insert");
//        }
//    }
//    public void displayCustomer() {
//        Customer x = new Customer();
//        System.out.println(x.displayAllgCustomers());
//    }
//
//
//    public void searchForCustomer(int id) {
//        Customer c = new Customer();
//        System.out.println(c.searchCustomerById(id));
//    }
//
//    public void updateCustomer(int oldID, Customer newCustomerValues) {
//        Customer c = new  Customer();
//        c.updateCustomer(oldID, newCustomerValues);
//        System.out.println("Updated Successfully ... !");
//    }
//
//    public void deleteStudent(int Id) {
//        Customer x = new Customer();
//        x.deleteCustomer(Id);
//        System.out.println("deleted Successfully ... !");
//    }
//
// 
//       public void addNewemployee(int ID, String FristName, String LastName, String adress, String PhoneNumber, String pass) {
//        employee x = new employee(ID, FristName, LastName, adress,PhoneNumber, pass);
//        if (x.addemployee()) {
//            System.out.println(x.toString() + "Added Successfully");
//        } else {
//            System.out.println("Failed to insert");
//        }
//    }
//
//    public void displayemployee() {
//        employee x = new employee();
//        System.out.println(x.displayAllgemployees());
//    }
//
//    public void searchForemployee(int id) {
//        employee e = new employee();
//        System.out.println(e.searchemployees(id));
//    }
//
//    public void updateemployee(int oldID, employee newemployeeValues) {
//        employee z = new  employee();
//        z.updateemployee(oldID, newemployeeValues);
//        System.out.println("Updated Successfully ... !");
//    }
//
//    public void deleteemployee(int Id) {
//        employee d = new employee();
//        d.deleteemployee(Id);
//        System.out.println("deleted Successfully ... !");
//    }

    
    
}
