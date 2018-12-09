/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import java.io.*;
import fileManger.filemanager;
import core.Person;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;

/**
 *
 * @author 1300180
 */
public class customer extends Person{

    public customer(int CID, String CFristName, String CLastName, int CPhoneNumber, String Cadress) {
        super(CID, CFristName, CLastName, CPhoneNumber, Cadress);
    }
    
    @Override
    public String toString() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return "done";
    }


    
    private final String FileCustomerM = "customer.txt";
    static ArrayList<customer> Arr = new ArrayList<customer>();
    static int count = -1;
    static boolean flage = true;
    
    int x= 4;
    //   public void write(Object o) {
    //        customer x = ((customer) o);
    //        Arr.add(x);
    //        doSave();
    //    }
    //    public static void doSave(){
    //        try {
    //            FileOutputStream fileOut = new FileOutputStream("customer.bin");
    //            ObjectOutputStream out = new ObjectOutputStream(fileOut);
    //            out.writeObject(Arr);
    //            out.close();
    //            fileOut.close();
    //        } catch (Exception ee) {
    //            System.err.println("Can't save");
    //        }
    //    }
}
