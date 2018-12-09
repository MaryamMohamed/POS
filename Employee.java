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
import static core.customer.Arr;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Employee extends Person{
    
    public Employee(int EID, String EFristName, String ELastName, int EPhoneNumber, String Eadress) {
        super(EID, EFristName, ELastName, EPhoneNumber, Eadress);
    }
    
    @Override
    public String toString() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return "done";
    }

    private final String FileEmplopyeeM = "employee.txt";    
    static ArrayList<Employee> Arr = new ArrayList<Employee>();
    static int count = -1;
    static boolean flage = true;
    int x= 4;
   

    public void write(Object o) {
        Employee x = ((Employee) o);
        Arr.add(x);
        doSave();
    }
    public static void doSave(){
        try {
            FileOutputStream fileOut = new FileOutputStream("employee.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Arr);
            out.close();
            fileOut.close();
        } catch (Exception ee) {
            System.err.println("Can't save");
        }
    }
}
