package pip.course.assignment;

import java.util.*;
import java.text.SimpleDateFormat;
import pip.ArrayListSerializationName;
import pip.WriteFile;

public class Assignment implements java.io.Serializable {
  private String CourseID;
  private String CourseName;
  private String ID;
  private String Name;
  private String Requirements;
  private Date DueDate;
  private int Points;
  private int NoteID;
  
  public Assignment(String CourseID, String ID, String Name, String Requirements, Date DueDate, int Points, int NoteID){
    this.CourseID = CourseID;
    this.ID = ID;
    this.Name = Name;
    this.Requirements = Requirements;
    this.DueDate = DueDate;
    this.Points = Points;
    this.NoteID = NoteID;
  }
  
  public Assignment(){
   // initialize empty Assignment   
  }
  
public void fillWithConsole(){
      Scanner console = new Scanner(System.in);
//      int Id;
//      String CourseId;
//      String Name;
//      String Requirements;
//      Date DueDate = new Date();
//      int Points;
//      int NoteId;
      
      System.out.println("Enter the Course ID");
      this.CourseID = console.nextLine();
      System.out.println("Enter the Discription of requirements of the assignment");
      this.Requirements = console.nextLine();
//      System.out.println("Enter the courseId");
//      CourseId = console.nextLine();
      System.out.println("Enter the Due Date");
      
       System.out.println("enter the month");
       int month = console.nextInt();
       System.out.println("enter the date");
       int date = console.nextInt();
       int year = Calendar.getInstance().get(Calendar.YEAR);
       System.out.println("enter hour");
       int hour = console.nextInt();
       System.out.println("enter mins");
       int min =console.nextInt();
       String duedate = month+"-" +date+"-" + year + " "+hour+":"+min+":00";
       try{
         this.DueDate = new SimpleDateFormat("MM-d-yyyy hh:mm:ss", Locale.ENGLISH).parse(duedate);
         System.out.println(duedate);
         }
      catch(Exception e){
         System.out.println("exception");
      }
      System.out.println("Enter the points of the assignment");
      Points = console.nextInt();
      System.out.println("Enter the Note id");
      this.NoteID = console.nextInt();
      ArrayListSerializationName.AddAssignment(this.Name+"assignment.ser");
      WriteFile.writeAssignment(this.CourseID,this.Name,this.Requirements,this.DueDate,this.Points,this.NoteID); 
   }
  
  public String getCourseID() {
        return CourseID;
  }
  
  public String getCourseName() {
        return CourseName;
  }
  
  public String getName(){
      return Name;
  } 
  
  public String getRequirements(){
      return Requirements;
  } 
  public Date getDueDate(){
      return DueDate;
  }
  
  public int getPoints(){
      return Points;
  } 
  
  public int getNoteID(){
      return NoteID;
  }
  
  
  public void setCourseID(String CourseId) {
        this.CourseID = CourseId;
  }
  
  public void setName(String Name){
      this.Name = Name;
  }
  
  public void setRequirements(String Requirements){
      this.Requirements = Requirements;
  } 
  
  public void setDueDate(Date DueDate){
      this.DueDate = DueDate;
  }
  
  public void setPoints(int Points){
      this.Points = Points;
  }
  
  public void setNoteId(int NoteID){
      this.NoteID = NoteID;
  }
}