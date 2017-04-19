package pip;

import java.util.ArrayList;
import java.io.*;
public class CreateFile{
   public CreateFile(){
    ClearContactFile();
    ClearEventFile();
    ClearNotesFile();
    ClearCoursetFile();
    ClearAssignmentFile();
   }
   public static void ClearContactFile(){
       ArrayList<String> Contactal=new ArrayList<String>();
       try{
         FileOutputStream fos= new FileOutputStream("contact.ser");
         ObjectOutputStream oos= new ObjectOutputStream(fos);
         oos.writeObject(Contactal);
         oos.close();
         fos.close();
       }catch(IOException ioe){
            ioe.printStackTrace();
        }
   }
   public static void ClearEventFile(){
       ArrayList<String> Evental=new ArrayList<String>();
       try{
         FileOutputStream fos= new FileOutputStream("event.ser");
         ObjectOutputStream oos= new ObjectOutputStream(fos);
         oos.writeObject(Evental);
         oos.close();
         fos.close();
       }catch(IOException ioe){
            ioe.printStackTrace();
        }
   }
   public static void ClearNotesFile(){
       ArrayList<String> Notesal=new ArrayList<String>();
       try{
         FileOutputStream fos= new FileOutputStream("notes.ser");
         ObjectOutputStream oos= new ObjectOutputStream(fos);
         oos.writeObject(Notesal);
         oos.close();
         fos.close();
       }catch(IOException ioe){
            ioe.printStackTrace();
        }
   }
   public static void ClearCoursetFile(){
       ArrayList<String> Courseal=new ArrayList<String>();
       try{
         FileOutputStream fos= new FileOutputStream("course.ser");
         ObjectOutputStream oos= new ObjectOutputStream(fos);
         oos.writeObject(Courseal);
         oos.close();
         fos.close();
       }catch(IOException ioe){
            ioe.printStackTrace();
        }
   }
   public static void ClearAssignmentFile(){
       ArrayList<String> Assignmental=new ArrayList<String>();
       try{
         FileOutputStream fos= new FileOutputStream("assignment.ser");
         ObjectOutputStream oos= new ObjectOutputStream(fos);
         oos.writeObject(Assignmental);
         oos.close();
         fos.close();
       }catch(IOException ioe){
            ioe.printStackTrace();
        }
   }
   
}