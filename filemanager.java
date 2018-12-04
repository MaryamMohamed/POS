

package project;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class filemanager {
    // create new folder
    public static File CreateFolder(String FolderName) {
        File Folder = new File(FolderName); // هنا عملت اوبزيكت سميته فولدر من نوع فايل
        return Folder.mkdir() ? Folder : null;
        // هنا رجعتله الفولدر بعت ما عملتله كريات بال 
        //.kdir و دي بعمل بيها دايريكتور او فولدر 
        // و بعدين قولتله لو عملت الفولدر ده رجعهولي و معملتهوش رجعلي 
        // null
    }
    
    // create new file
    public static File CreateFile(String FileName) {
        File file = new File(FileName);
        return file;
    }
    
    // create new file in folder
    public static File CreateNewFileInFolder(String FolderName, String FileName) {
        File file = new File(FolderName, FileName);
        return file;
    }
    
    // open to write in file
    public static BufferedWriter OpenToWrite(String FileName, String Q) {
        try {
            
            FileWriter fileW = new FileWriter(FileName);
            BufferedWriter buffW = new BufferedWriter(fileW);
            buffW.write(Q);
            fileW.close();
            return buffW;
        } catch (IOException e) {
            System.err.println(e);
        }
        return null;
    }
     
     // open file to read
      public static BufferedReader openToRead(String FileName) {
        try {
            FileReader fileR = new FileReader(FileName);
            BufferedReader bufferR = new BufferedReader(fileR);
            bufferR.readLine();
            bufferR.close();
            return bufferR;
        } catch (IOException e) {
            System.err.println(e);
        }
        return null;
    }
      // add new line to file without clearing data
      public static Boolean AddLine(String FileName, String Q) {
          
            try{
                BufferedWriter buffW = new BufferedWriter(new FileWriter(FileName,true));
                buffW.write(Q);
                buffW.newLine();;
                buffW.close();
                return true;
            }
            catch(IOException e){
                System.err.println(e);
            }
            return false;
    }
      // add line in file and clearing previuse data
    public static Boolean AddLineWithoutAppend(String FileName, String Q) {
        try{
            BufferedWriter buffW = new BufferedWriter(new FileWriter(FileName));
            buffW.write(Q);
            buffW.newLine();
            buffW.close();
            return true;
        }
        catch(IOException e){
            System.err.println(e);
        }        
        return false;
    }
    
    public static boolean StringFinder(String FileName, String token) {
        
        File F = new File(FileName);
        try{
            Scanner scan = new Scanner(F);
            while(scan.hasNext())
            {
                String line = scan.nextLine();
                if(line.equals(token)){
                    scan.close();
                    return true;
                }
            }
        }
        catch(FileNotFoundException e){
            System.err.println(e);
        }
        return false;
  }
    
    public static void DeleteFile(String FileName) {
        File file = new File(FileName);
        file.delete();
    }
    
    
    public static synchronized void RemoveLine(String FileName,String token){
        File F = new File(FileName);
        BufferedReader buffR = null;
        String currentLine;
        try {
            while((currentLine = buffR.readLine()) != null){
                
                String trimmedLine = currentLine.trim();
                if(trimmedLine.equals(token)){
                    continue;
                }
            }
            buffR.close();
        } catch (IOException ex) {
            Logger.getLogger(filemanager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

            /*try {
            buffR=new BufferedReader(new FileReader(FileName));
            String Line;
            ArrayList <String> a =new ArrayList<String>();
            while((Line= buffR.readLine())!=null) {
            if (!Line.contains(token)) {
            a.add(Line);
            }
            }
            AddLineWithoutAppend(a,FileName);
            
            }catch (IOException ignored){
            
            }
            if (buffR != null) try {
            buffR.close();
            } catch (IOException ignored) {
            }
        }*/ 
    
    
}
