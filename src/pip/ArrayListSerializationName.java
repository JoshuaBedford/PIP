package pip;

import java.util.*;
import java.io.*;
public class ArrayListSerializationName{
  public static ArrayList<String> Contactal=new ArrayList<String>();
  public static ArrayList<String> Contactarraylist= new ArrayList<String>();
  public static ArrayList<String> Evental = new ArrayList<String>();
  public static ArrayList<String> Eventarraylist= new ArrayList<String>();
  public static ArrayList<String> Notesal=new ArrayList<String>();
  public static ArrayList<String> Notesarraylist= new ArrayList<String>();
  public static ArrayList<String> Courseal = new ArrayList<String>();
  public static ArrayList<String> Coursearraylist= new ArrayList<String>();
  public static ArrayList<String> Assignmental=new ArrayList<String>();
  public static ArrayList<String> Assignmentarraylist= new ArrayList<String>();
  
   public static void AddContact(String contactname){
        try
        {
            FileInputStream fis = new FileInputStream("contact.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Contactarraylist = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
             return;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
        for(String tmp: Contactarraylist){
            Contactal.add(tmp);
        }        
        Contactal.add(contactname);
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
   public static void AddEvent(String eventtitle){
        try
        {
            FileInputStream fis = new FileInputStream("event.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Eventarraylist = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
             return;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
        for(String tmp: Eventarraylist){
            Evental.add(tmp);
        }        
        Evental.add(eventtitle);
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
   public static void AddNotes(String notesname){
        try
        {
            FileInputStream fis = new FileInputStream("notes.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Notesarraylist = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
             return;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
        for(String tmp: Notesarraylist){
            Notesal.add(tmp);
        }        
        Notesal.add(notesname);
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
   public static void AddCourse(String coursename){
        try
        {
            FileInputStream fis = new FileInputStream("course.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Coursearraylist = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
             return;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
        for(String tmp: Coursearraylist){
            Courseal.add(tmp);
        }        
        Courseal.add(coursename);
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
  public static void AddAssignment(String assignmentname){
        try
        {
            FileInputStream fis = new FileInputStream("assignment.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Assignmentarraylist = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
             return;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
        for(String tmp: Assignmentarraylist){
            Assignmental.add(tmp);
        }        
        Assignmental.add(assignmentname);
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