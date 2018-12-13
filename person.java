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
public abstract class person {
   protected int ID ;
   protected String FristName ;
   protected String LastName ;
   protected String adress ;
   protected String PhoneNumber ;
   protected String pass ;

  FileManger  FManager  = new FileManger ();

    public person() {
    }
   
    public person(int ID, String FristName, String LastName, String adress, String PhoneNumber, String pass) {
        this.ID = ID;
        this.FristName = FristName;
        this.LastName = LastName;
        this.adress = adress;
        this.PhoneNumber = PhoneNumber;
        this.pass = pass;
    }
   
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

    public void setPhoneNumber(String PhoneNumber) {
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
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getPass() {
        return pass;
    }
    @Override
    public abstract String toString();

public boolean login(String userName, String Pass) {
        if (userName.equals("Admin@yahoo.com") && Pass.equals("12345678")) {
            return true;
        }
        return false;
    }
}

//}
//class person {
//    
//}
