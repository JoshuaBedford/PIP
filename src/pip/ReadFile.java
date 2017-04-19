package pip;

import pip.course.Course;
import pip.course.assignment.Assignment;
import pip.contact.Contact;
import pip.event.Event;
import java.io.*;
import java.util.*;
import pip.note.Notes;

public class ReadFile extends Event{
    /*public static void main(String[] args){
      ReadContac("hiscourse.ser");
    }*/

   public static Contact ReadContact(String name) {
      Contact contact = null;
      try {
         FileInputStream fileIn = new FileInputStream(name.toLowerCase());
         ObjectInputStream in = new ObjectInputStream(fileIn);
         contact = (Contact) in.readObject();
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
//      System.out.println("Name: " + contact.getName());
//      System.out.println("Email: "+ contact.getEmail());
//      System.out.println("Address: " + contact.getAddress());
//      System.out.println("Birthday: " +contact.getBirthday());
//      System.out.println("Number: " + contact.getNumber());
//      System.out.println("RelationShip: "+ contact.getRelationship());
//      System.out.println("Note ID: "+ contact.getNoteId());
//      System.out.println();
      
      return contact;
      
   }
   public static Event ReadEvent(String title) {
   title = title.toLowerCase();
      Event event = null;
      try {
         FileInputStream fileIn = new FileInputStream(title.toLowerCase());
         ObjectInputStream in = new ObjectInputStream(fileIn);
         event = (Event) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i) {
         i.printStackTrace();
         return null;
      }catch(ClassNotFoundException c) {
         System.out.println("Event class not found");
         c.printStackTrace();
         return null;
      }
//      System.out.println("Title: " + event.getEventTitle());
//      System.out.println("Date Created: "+ event.getDateCreated());
//      System.out.println("Event Start time: " + event.getStartTime());
//      System.out.println("Event End time: " + event.getEndTime());
//      System.out.println("Discription:-" + event.getDescription());
//      System.out.println();
        return event;
   }
   
   public static Notes ReadNotes(String title) {
   title = title.toLowerCase();
      Notes note = null;
      try {
         FileInputStream fileIn = new FileInputStream(title);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         note = (Notes) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i) {
         i.printStackTrace();
         return null;
      }catch(ClassNotFoundException c) {
         System.out.println("Event class not found");
         c.printStackTrace();
         return null;
      }
//      System.out.println("Notes Title: " + note.getTitle());
//      System.out.println("Date Created: "+ note.getDateCreated());
//      System.out.println("Content: " + note.getContent());
//      System.out.println();

        return note;
   }
   
   public static Course ReadCourse(String name){
    name = name.toLowerCase();
    Course course = null;
      try {
         FileInputStream fileIn = new FileInputStream(name);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         course = (Course) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i) {
         i.printStackTrace();
         return null;
      }catch(ClassNotFoundException e) {
         System.out.println("Event class not found");
         e.printStackTrace();
         return null;
      }
//      System.out.println("Course ID: " + course.getId());
//      System.out.println("Course Name: "+ course.getCourseName());
//      System.out.println("Professor Name: " + course.getProfessorName());
//      System.out.println("Scedule: " + course.getSchedule());
//      System.out.println("Semester: " + course.getSemester());
//      System.out.println("Discription: "+ course.getDescription());
//      System.out.println("Friends in class: " +course.getFriendsInClass());
//      System.out.println();
      
      return course;
   }

    
   public static Assignment ReadAssignment(String name) {
   String courseID = name;
      Assignment assignment = null;
      try {
         FileInputStream fileIn = new FileInputStream(name);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         assignment = (Assignment) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i) {
         i.printStackTrace();
         return null;
      }catch(ClassNotFoundException c) {
         System.out.println("Event class not found");
         c.printStackTrace();
         return null;
      }
//      System.out.println("Assignment ID: " + assignment.getCourseID());
//      System.out.println("Course Id: "+ assignment.getCourseID());
//      System.out.println("Course Name: " + assignment.getCourseName());
//      System.out.println("Requirement/ description: " + assignment.getRequirements());
//      System.out.println("Due Date: " + assignment.getDueDate());
//      System.out.println("Points: "+ assignment.getPoints());
//      System.out.println("NoteId: "+ assignment.getNoteID());
//      System.out.println();
      
      return assignment;
   }

}