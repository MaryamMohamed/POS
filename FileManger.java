package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tamer A.Yassen
 */
public class FileManger {

    public boolean write(String Query, String FilePath, boolean appendType) {

        PrintWriter writter = null;
        try {
            writter = new PrintWriter(new FileWriter(new File(FilePath), appendType));
            writter.println(Query);
            return true;
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writter.close();
        }
        return false;
    }

    
    
    
    public ArrayList<Object> read(String FilePath) {
        Scanner Reader = null;
        try {
            Reader = new Scanner(new File(FilePath));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        if (FilePath.equals("customer.txt")) {

            ArrayList<Customer> customers = new ArrayList<Customer>();
            Customer x;

            while (Reader.hasNext()) {

                x = new Customer();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

//                x.setID(Integer.parseInt(seprated[0]));
//                x.setFName(seprated[1]);
//                x.setLName(seprated[2]);
//                x.setAge(Integer.parseInt(seprated[3]));
//                x.setLevel(Integer.parseInt(seprated[4]));
//                x.setGPA(Double.parseDouble(seprated[5]));
//
//                if (seprated[6].equals("CS")) {
//                    x.setDept(Main.cs);
//                } else if (seprated[6].equals("IS")) {
//                    x.setDept(Main.is);
//                } else if (seprated[6].equals("IT")) {
//                    x.setDept(Main.it);
//                } else if (seprated[6].equals("SW")) {
//                    x.setDept(Main.sw);
//                }
//
//                x.setUserName(seprated[7]);
//                x.setPass(seprated[8]);

                customers.add(x);
            }

            return (ArrayList<Object>) (Object) customers;

        } else if (FilePath.equals("employee.txt")) {

            ArrayList<employee> employees = new ArrayList<employee>();
            employee x;

            while (Reader.hasNext()) {

                x = new employee();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

//                x.setID(Integer.parseInt(seprated[0]));
//                x.setFName(seprated[1]);
//                x.setLName(seprated[2]);
//                x.setAge(Integer.parseInt(seprated[3]));
//                x.setSalary(Double.parseDouble(seprated[4]));
//                x.setOfficeHours(seprated[5]);
//
//                if (seprated[6].equals("CS")) {
//                    x.setDept(Main.cs);
//                } else if (seprated[6].equals("IS")) {
//                    x.setDept(Main.is);
//                } else if (seprated[6].equals("IT")) {
//                    x.setDept(Main.it);
//                } else if (seprated[6].equals("SW")) {
//                    x.setDept(Main.sw);
//                }
//
//                x.setUserName(seprated[7]);
//                x.setPass(seprated[8]);

                employees.add(x);
            }

            return (ArrayList<Object>) (Object) employees;

        } else if (FilePath.equals("item.txt")) {

            ArrayList<item> items = new ArrayList<item>();
            item x;

            while (Reader.hasNext()) {

                x = new item();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

//                x.setID(Integer.parseInt(seprated[0]));
//                x.setFName(seprated[1]);
//                x.setLName(seprated[2]);
//                x.setAge(Integer.parseInt(seprated[3]));
//                x.setSalary(Double.parseDouble(seprated[4]));
//                x.setacademicHours(seprated[5]);
//
//                if (seprated[6].equals("CS")) {
//                    x.setDept(Main.cs);
//                } else if (seprated[6].equals("IS")) {
//                    x.setDept(Main.is);
//                } else if (seprated[6].equals("IT")) {
//                    x.setDept(Main.it);
//                } else if (seprated[6].equals("SW")) {
//                    x.setDept(Main.sw);
//                }
//
//                x.setUserName(seprated[7]);
//                x.setPass(seprated[8]);

                items.add(x);
            }

            return (ArrayList<Object>) (Object) items;

        } /*else if (FilePath.equals("Employee.txt")) {

            ArrayList<studentAffairsEmp> Employees = new ArrayList<studentAffairsEmp>();
            studentAffairsEmp x;

            while (Reader.hasNext()) {

                x = new studentAffairsEmp();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

                // 1@Shaima@Ali@35@3500.0@SA@SA_1@12345678@
                x.setID(Integer.parseInt(seprated[0]));
                x.setFName(seprated[1]);
                x.setLName(seprated[2]);
                x.setAge(Integer.parseInt(seprated[3]));
                x.setSalary(Double.parseDouble(seprated[4]));

                if (seprated[5].equals("SA")) {
                    x.setDept(Main.sa);
                }

                x.setUserName(seprated[6]);
                x.setPass(seprated[7]);

                Employees.add(x);
            }

            return (ArrayList<Object>) (Object) Employees;

        }*/ 
      /*  else if (FilePath.equals("Courses.txt")) {

            ArrayList<Course> Courses = new ArrayList<Course>();
            Course x;

            while (Reader.hasNext()) {

                x = new Course();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

                // PL2@CS213@100@
                x.setCname(seprated[0]);
                x.setCId(seprated[1]);
                x.setCreditHours(Integer.parseInt(seprated[2]));

                Courses.add(x);
            }

            return (ArrayList<Object>) (Object) Courses;

        } */else {
            return null;
        }

    }

}
