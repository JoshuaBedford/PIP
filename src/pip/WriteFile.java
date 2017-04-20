package pip;

import pip.course.Course;
import pip.course.assignment.Assignment;
import pip.contact.Contact;
import pip.event.Event;
import java.io.*;
import java.util.*;
import pip.note.Notes;
public class WriteFile {
 
   public static void writeContact(String name,String Email,String address,Date birthday, String number, String relationship,int noteId) {
      Scanner console = new Scanner(System.in);
      Contact course = new Contact();
      course.setName(name);
      course.setEmail(Email);
      course.setAddress(address);
      course.setBirthday(birthday);
      course.setNumber(number);
      course.setRelationship(relationship);
      course.setNoteID(noteId);
      try {
         FileOutputStream fileOut =
         new FileOutputStream(course.getName()+"contact.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(course);
         out.close();
         fileOut.close();
      }catch(IOException i) {
         i.printStackTrace();
      }
   }
   public static void writeEvent(String EventTitle,Date DateCreated,Date StartTime,Date EndTime, String Discription, int ID) {
      Scanner console = new Scanner(System.in);
      Event e = new Event();
      e.setEventTitle(EventTitle);
      e.setDateCreated(DateCreated);
      e.setStartTime(StartTime);
      e.setEndTime(EndTime);
      e.setDescription(Discription);
      try {
         FileOutputStream fileOut =
         new FileOutputStream(e.getEventTitle()+"event.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
      }catch(IOException i) {
         i.printStackTrace();
      }
   }
   
   
   public static void writeAssignment(String CourseId,String CourseName,String Requirements, Date DueDate,int Points,int NoteId) {
      Scanner console = new Scanner(System.in);
      Assignment assignment = new Assignment();
      assignment.setCourseID(CourseId);
      assignment.setName(CourseName);
      assignment.setRequirements(Requirements);
      assignment.setDueDate(DueDate);
      assignment.setPoints(Points);
      assignment.setNoteId(NoteId);
      try {
         FileOutputStream fileOut =
         new FileOutputStream(assignment.getCourseName()+"assignment.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(assignment);
         out.close();
         fileOut.close();
      }catch(IOException i) {
         i.printStackTrace();
      }
   }

  public static void writeCourse(String CourseId,String CourseName,String ProfessorName,Date Scedule,String Semester,String Discription,String FriendsInClass,int NoteId) {
      Scanner console = new Scanner(System.in);
      Course course = new Course();
      course.setId(CourseId);
      course.setName(CourseName);
      course.setProfessorName(ProfessorName);
      course.setSchedule(Scedule);
      course.setFriendsInClass(FriendsInClass);
      course.setSemester(Semester);
      course.setDescription(Discription);
      course.setNoteId(NoteId);
      try {
         FileOutputStream fileOut =
         new FileOutputStream(course.getCourseName()+"course.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(course);
         out.close();
         fileOut.close();
      }catch(IOException i) {
         i.printStackTrace();
      }
   }


    public static void writeNotes(String Title, Date DateCreated, String Content, int ID) {
      Scanner console = new Scanner(System.in);
      Notes notes = new Notes();
      notes.setTitle(Title);
      notes.setDateCreated(DateCreated);
      notes.setContent(Content);
      notes.setID(ID);
      try {
         FileOutputStream fileOut = new FileOutputStream(notes.getTitle()+"notes.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(notes);
         out.close();
         fileOut.close();
      }catch(IOException i) {
         i.printStackTrace();
      }
   }
}