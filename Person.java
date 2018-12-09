/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import fileManger.filemanager;
import java.io.Serializable;

/**
 *
 * @author 1300180
 */
public abstract class Person implements Serializable{
   protected int ID ;
   protected String FristName ;
   protected String LastName ;
   protected String adress ;
   protected int PhoneNumber ;
   
   filemanager FM = new filemanager(); 
   public Person(int ID, String FristName, String LastName,int PhoneNumber,String adress) {
        this.ID = ID;
        this.FristName = FristName;
        this.LastName = LastName;
        this.adress = adress;
        this.PhoneNumber = PhoneNumber;
    }
   
   @Override
    public abstract String toString();
   
   
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFristName(String FristName) {
        this.FristName = FristName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public int getID() {
        return ID;
    }

    public String getFristName() {
        return FristName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getAdress() {
        return adress;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }
   
   // public void add (){}
   // public void delete (){}
   // public void update (){}
   // public void list (){}

    
}
