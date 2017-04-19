package pip;

import pip.course.Course;
import pip.course.assignment.Assignment;
import pip.contact.Contact;
import pip.event.Event;
import java.io.*;
import java.util.ArrayList;
import pip.note.Notes;
public class DeSerializationClassName implements Serializable{
//    public static void main(String[] args){
//      DisplayContacts();
//    }
   
    public static void DisplayContacts(){
        ArrayList<String> Contactarraylist= new ArrayList<String>();
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
        for(String eventname: Contactarraylist){
            ReadFile.ReadContact(eventname);
        }
   }
   public static ArrayList<Contact> SearchContacts(String name){
     ArrayList<String> Contactarraylist= new ArrayList<String>();
     ArrayList<Contact> results = new ArrayList<Contact>();
        try
        {
            FileInputStream fis = new FileInputStream("contact.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Contactarraylist = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
             return null;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return null;
          }
        for(String eventname: Contactarraylist){
            Contact s = null;
            try {
               FileInputStream fileIn = new FileInputStream(eventname.toLowerCase());
               ObjectInputStream in = new ObjectInputStream(fileIn);
               s = (Contact) in.readObject();
               in.close();
               fileIn.close();
            }catch(IOException i) {
               i.printStackTrace();
               return null;
            }catch(ClassNotFoundException c) {
               System.out.println("Contact class not found");
               c.printStackTrace();
               return null;
            }
            if(eventname.contains(name)){
              results.add(ReadFile.ReadContact(eventname));
            }
            else if(((s.getEmail().toLowerCase()).contains(name)) || (name.contains(s.getEmail().toLowerCase()))){
              results.add(ReadFile.ReadContact(eventname));
            }
            else if((s.getNumber().contains(name)) || (name.contains(s.getNumber().toLowerCase()))){
              results.add(ReadFile.ReadContact(eventname));
            }
            else if(((s.getRelationship().toLowerCase()).contains(name)) || (name.contains(s.getRelationship().toLowerCase()))){
              results.add(ReadFile.ReadContact(eventname));
            }
            else if(((s.getAddress().toLowerCase()).contains(name)) || (name.contains(s.getAddress().toLowerCase()))){
              results.add(ReadFile.ReadContact(eventname));
            }
            

        }
        return results;

    }
   public static void DisplayEvents(){
        ArrayList<String> Eventarraylist= new ArrayList<String>();
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
        for(String event: Eventarraylist){
            ReadFile.ReadEvent(event);
        }
   }
   public static ArrayList<Event> SearchEvent(String name){
     ArrayList<String> Eventarraylist= new ArrayList<String>();
     ArrayList<Event> results= new ArrayList<Event>();
        try
        {
            FileInputStream fis = new FileInputStream("event.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Eventarraylist = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
             return null;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return null;
          }
        for(String eventname: Eventarraylist){
            Event e = null;
            try {
               FileInputStream fileIn = new FileInputStream(eventname.toLowerCase());
               ObjectInputStream in = new ObjectInputStream(fileIn);
               e = (Event) in.readObject();
               in.close();
               fileIn.close();
            }catch(IOException i) {
               i.printStackTrace();
               return null;
            }catch(ClassNotFoundException c) {
               System.out.println("Contact class not found");
               c.printStackTrace();
               return null;
            }
            if(eventname.contains(name)){
              results.add(ReadFile.ReadEvent(eventname));
            }
            else if(((e.getDescription().toLowerCase()).contains(name)) || (name.contains(e.getDescription().toLowerCase()))){
              results.add(ReadFile.ReadEvent(eventname));
            }
        }
        return results;
   }

    public static ArrayList<Notes> DisplayNotes(){
        ArrayList<String> Notesarraylist= new ArrayList<String>();
        ArrayList<Notes> results= new ArrayList<Notes>();
        try
        {
            FileInputStream fis = new FileInputStream("notes.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Notesarraylist = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
             return null;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return null;
          }
        for(String notesname: Notesarraylist){
            results.add(ReadFile.ReadNotes(notesname));
        }
        return results;
   }
   public static ArrayList<Notes> SearchNotes(String name){
     ArrayList<String> Notesarraylist= new ArrayList<String>();
     ArrayList<Notes> results = new ArrayList<Notes>();
        try
        {
            FileInputStream fis = new FileInputStream("notes.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Notesarraylist = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
             return null;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return null;
          }
        for(String eventname: Notesarraylist){
            Notes n = null;
            try {
               FileInputStream fileIn = new FileInputStream(eventname.toLowerCase());
               ObjectInputStream in = new ObjectInputStream(fileIn);
               n = (Notes) in.readObject();
               in.close();
               fileIn.close();
            }catch(IOException i) {
               i.printStackTrace();
               return null;
            }catch(ClassNotFoundException c) {
               System.out.println("Contact class not found");
               c.printStackTrace();
               return null;
            }
            if(eventname.contains(name)){
              results.add(ReadFile.ReadNotes(eventname));
            }
            else if(((n.getContent().toLowerCase()).contains(name)) || (name.contains(n.getContent().toLowerCase()))){
              results.add(ReadFile.ReadNotes(eventname));
            }
        }
        if(results.isEmpty()){
            System.out.println("empty");
            return null;
        }
        return results;
   }

    public static void DisplayCourse(){
        ArrayList<String> Coursearraylist= new ArrayList<String>();
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
        for(String coursename: Coursearraylist){
            System.out.println(coursename);
        }
   }
   public static ArrayList<Course> SearchCourse(String name){
     ArrayList<String> Coursearraylist= new ArrayList<String>();
     ArrayList<Course> results= new ArrayList<Course>();
        try
        {
            FileInputStream fis = new FileInputStream("course.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Coursearraylist = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
             return null;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return null;
          }
        for(String eventname: Coursearraylist){
            Course course = null;
            try {
               FileInputStream fileIn = new FileInputStream(eventname.toLowerCase());
               ObjectInputStream in = new ObjectInputStream(fileIn);
               course = (Course) in.readObject();
               in.close();
               fileIn.close();
            }catch(IOException i) {
               i.printStackTrace();
               return null;
            }catch(ClassNotFoundException e) {
               System.out.println("Contact class not found");
               e.printStackTrace();
               return null;
            }
            String courseId = course.getId()+"";
            if(eventname.contains(name)){
              results.add(ReadFile.ReadCourse(eventname));
            }
            else if(((course.getProfessorName().toLowerCase()).contains(name)) || (name.contains(course.getProfessorName().toLowerCase()))){
              results.add(ReadFile.ReadCourse(eventname));
            }
            else if(((course.getSemester().toLowerCase()).contains(name)) || (name.contains(course.getSemester().toLowerCase()))){
              results.add(ReadFile.ReadCourse(eventname));
            }
            else if(((course.getDescription().toLowerCase()).contains(name)) || (name.contains(course.getDescription().toLowerCase()))){
              results.add(ReadFile.ReadCourse(eventname));
            }
            else if(((course.getFriendsInClass().toLowerCase()).contains(name)) || (name.contains(course.getFriendsInClass().toLowerCase()))){
              results.add(ReadFile.ReadCourse(eventname));
            }
            else if((courseId.contains(name)) || (name.contains(courseId))){
              results.add(ReadFile.ReadCourse(eventname));
            } 
        }
        return results;
   }

      
    public static void DisplayAssignment(){
        ArrayList<String> Assignmentarraylist= new ArrayList<String>();
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
        for(String assignmentname: Assignmentarraylist){
            System.out.println(assignmentname);
        }
   }
   
   public static ArrayList<Assignment> SearchAssignment(String name){
     ArrayList<String> Assignmentarraylist= new ArrayList<String>();
     ArrayList<Assignment> results= new ArrayList<Assignment>();
        try
        {
            FileInputStream fis = new FileInputStream("assignment.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Assignmentarraylist = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
             return null;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return null;
          }
        for(String eventname: Assignmentarraylist){
            Assignment assignment = null;
            try {
               FileInputStream fileIn = new FileInputStream(eventname.toLowerCase());
               ObjectInputStream in = new ObjectInputStream(fileIn);
               assignment = (Assignment) in.readObject();
               in.close();
               fileIn.close();
            }catch(IOException i) {
               i.printStackTrace();
               return null;
            }catch(ClassNotFoundException e) {
               System.out.println("Contact class not found");
               e.printStackTrace();
               return null;
            }
            String points = assignment.getPoints()+"";
            String Courseid = assignment.getCourseID()+"";
            if(eventname.contains(name)){
              results.add(ReadFile.ReadAssignment(eventname));
            }
            else if(((assignment.getName().toLowerCase()).contains(name)) || (name.contains(assignment.getName().toLowerCase()))){
              results.add(ReadFile.ReadAssignment(eventname));
            }
            else if(((assignment.getRequirements().toLowerCase()).contains(name)) || (name.contains(assignment.getRequirements().toLowerCase()))){
              results.add(ReadFile.ReadAssignment(eventname));
            }
            else if((points.contains(name)) || (name.contains(points))){
              results.add(ReadFile.ReadAssignment(eventname));
            }
            else if((Courseid.contains(name)) || (name.contains(Courseid))){
              results.add(ReadFile.ReadAssignment(eventname));
            }
        }
        
       return results;
   }


}