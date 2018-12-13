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
public class employee extends person{
    private ArrayList<employee> employee;
    
     public  employee() {
       
    }

    employee(int ID, String FristName, String LastName, String adress, String PhoneNumber, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    private final String employeeFileName = "employee.txt";
      public static ArrayList<employee> employees = new ArrayList<employee>();

    

      
      
      

    public boolean addemployee() {
        
        if(FManager.write(  GetemployeeData(),employeeFileName, true))
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
    private String GetemployeeData(){
        return this.ID + "@" + this.FristName  + "@" + this.LastName + "@" + this.PhoneNumber + "@" + this.adress;
    }
    
public void loadFromFile() {
        employee = (ArrayList<employee>) (Object) FManager.read(employeeFileName);
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

 
  public String searchemployees(int id) {
        loadFromFile();
        int index = getemployeeIndex(id);
        if (index != -1) {
            return "\nFound ...!" + employees.get(index).toString();
        } else {
            return "\nNot Found ...!";
        }
    }
  
  public String displayAllgemployees() {
        loadFromFile();
        String S = "\nAll Student Data:\n";
        for (employee x : employees) {
            S = S + x.toString();
        }
        return S;
    }
  
  
    public void updateemployee(int oldID, employee x) {
        loadFromFile();
        int index = getemployeeIndex(oldID);

//        if (index != -1) 
           employees.set(index, x);

            commitToFile();
        }
    
    
    public void deleteemployee(int id) {
        loadFromFile();
        int index = getemployeeIndex(id);

        if (index != -1) 
            employees.remove(index);

             commitToFile();
        

       
    }
  
    public void commitToFile() {
         FManager.write( employees.get(0).GetemployeeData(),employeeFileName,false);
         for(int i=1; i<employees.size();i++){
             FManager.write( employees.get(i).GetemployeeData(),employeeFileName,true);
         }
        
    }
        @Override
    
    public String toString() {
        return "\nI'm Eng : " + FristName + " "+ LastName + " "  + "\n" + "ID : " +  ID + " PhoneNumber : " + PhoneNumber + "\n"
                + "Adress : " +  adress +  "\n";}
    

}
