/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 1300180
 */
public class employee extends person implements Serializable {
    private final String employeeFileName = "employee.txt";
    
    private static ArrayList<employee> employees = new ArrayList<employee>();
    
     public  employee() {
    }

    employee(int ID, String FristName, String LastName, String adress, String PhoneNumber, String pass) {
        super(ID, FristName, LastName, adress, PhoneNumber, pass);
    }
    
    public boolean addemployee() {
        if(FManager.write(  GetemployeeData(),employeeFileName, true))
            return true;
        else
            return false;
//        loadFromFile();
//        employees.add(this);
//        return commitToFile();
    }
    
    public boolean commitToFile() {
         return FManager.write( employees.get(0).GetemployeeData(),employeeFileName,false);        
    }
    
    public void loadFromFile() {
        employees = (ArrayList<employee>) (Object) FManager.read(employeeFileName);
    }
    
    private int getemployeeIndex(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getID() == id) {
                return i;
            }
        }
        return -1;
    }    
    
    public employee searchemployeeById(int id) {
        employee temp = new employee();
        loadFromFile();
        int index = getemployeeIndex(id);
        if (index != -1) {
            return employees.get(index);
        } else {
            return temp;
        }
    }
//    
//    public String search(int Id){
//        loadFromFile();
//        int index = getemployeeIndex(Id);
//        if(index == -1){
//            return null;
//        }
//        return employees.get(index).toString();
//    }
    public ArrayList<employee> listEmployees() {
        loadFromFile();
        return employees;
    }

    public boolean updateEmployee() {
        loadFromFile();
        int index = getemployeeIndex(this.ID);
        if (index != -1) {
            employees.set(index, this);
            return commitToFile();
        }
        return false;
    }
    
//    public void updateemployee(int oldID, employee x) {
//        loadFromFile();
//        int index = getemployeeIndex(oldID);
//
////        if (index != -1) 
//           employees.set(index, x);
//
//            commitToFile();
//        }

    public boolean deleteEmployee(int id) {
        loadFromFile();
        int index = getemployeeIndex(id);
        if (index != -1) {
            employees.remove(index);
            return commitToFile();
        }
        return false;
    }

//ID, FristName, LastName, adress, PhoneNumber, pass
    private String GetemployeeData(){
        return this.ID + "@" + this.FristName  + "@" + this.LastName + "@" + this.PhoneNumber + "@" + this.adress;
    }
    
    @Override
    public String toString() {
        return this.ID + "@" + this.FristName  + "@" + this.LastName + "@" + this.PhoneNumber + "@" + this.adress;
//        return "\nI'm Eng : " + FristName + " "+ LastName + " "  + "\n" + "ID : " +  ID + " PhoneNumber : " + PhoneNumber + "\n" + "Adress : " +  adress +  "\n";}
    } 
//  public String searchemployees(int id) {
//        loadFromFile();
//        int index = getemployeeIndex(id);
//        if (index != -1) {
//            return "\nFound ...!" + employees.get(index).toString();
//        } else {
//            return "\nNot Found ...!";
//        }
//    }
//  
//  public String displayAllgemployees() {
//        loadFromFile();
//        String S = "\nAll Student Data:\n";
//        for (employee x : employees) {
//            S = S + x.toString();
//        }
//        return S;
//    }
//    public void deleteemployee(int id) {
//        loadFromFile();
//        int index = getemployeeIndex(id);
//        if (index != -1) 
//            employees.remove(index);
//             commitToFile();  
//    }
//    
//    @Override
//    public boolean login(String userName, String Pass) {
//
//        if (userName.equals("Employee@yahoo.com") && Pass.equals("1234")) {
//            return true;
//        }
//        return false;
//
//    }

}
