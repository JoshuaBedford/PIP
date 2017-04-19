package pip.course;

import java.util.*;
import java.text.SimpleDateFormat;
import pip.ArrayListSerializationName;
import pip.WriteFile;

public class Course implements java.io.Serializable {
  private String ID;
  private String Name;
  private String ProfessorName;
  private Date Schedule;
  private String Semester;
  private String Description;
  private int NoteID;
  private String FriendsInClass;
  private String Content;
  
  
  public Course(String ID, String Name, String ProfessorName, Date Schedule, String Semester, String Description, int NoteID, String FriendsInClass){
    this.ID = ID;
    this.Name = Name;
    this.ProfessorName = ProfessorName;
    this.Schedule = Schedule;
    this.Semester = Semester;
    this.Description = Description;
    this.NoteID = NoteID;
    this.FriendsInClass = FriendsInClass;
  }
  
  public Course(){
   // initialize an empty course   
  }
  
  public void fillWithConsole(){
      Scanner console = new Scanner(System.in);
//      String Id;
//      String CourseName;
//      String ProfessorName;
//      Date Scedule = new Date();
//      String Semester;
//      String Discription;
//      int NoteId;
      
      System.out.println("Enter the Course name");
      this.Name = console.nextLine();
      System.out.println("Enter the Professor name");
      this.ProfessorName = console.nextLine();
      System.out.println("Enter the Semester");
      this.Semester = console.nextLine();
      System.out.println("Enter the Discription");
      this.Description = console.nextLine();
      System.out.println("Enter the Course ID");
      this.ID = console.nextLine();
      System.out.println("Enter the name of the friends in this class");
      this.Content = "";
      this.FriendsInClass = console.nextLine();
      while (!(FriendsInClass).equals("")){
        Content += FriendsInClass+"\n                  ";
        FriendsInClass = console.nextLine();
      }
      System.out.println("Enter the Start date of course");
      int date = console.nextInt();
      System.out.println("Enter the start month of the course");
      int month = console.nextInt();
      int year = Calendar.getInstance().get(Calendar.YEAR);
       System.out.println("enter Start time hour");
       int hour = console.nextInt();
       System.out.println("enter starttime mins");
       int min =console.nextInt();
       String minute = "";
       if(min<10){
        minute= "0"+min;
       }
       String scedule = month+" " +date+", " + year + " "+hour+":"+minute+":00";;
       try{
        SimpleDateFormat sdf = new SimpleDateFormat("M d,yyyy hh:mm:ss");
         this.Schedule = sdf.parse(scedule);
         System.out.println(this.Schedule);
         }
      catch(Exception e){
         System.out.println("exception");
     }

   
      System.out.println("Enter the NoteID");
      this.NoteID = console.nextInt();
      ArrayListSerializationName.AddCourse(this.Name+"course.ser");
      WriteFile.writeCourse(this.ID,this.Name,this.ProfessorName,this.Schedule,this.Semester,this.Description,this.Content,this.NoteID); 
   }
  
  public String getId() {
        return ID;
  }
  
  public String getCourseName(){
      return Name;
  }
  
  public String getProfessorName(){
      return ProfessorName;
  } 
  
  public Date getSchedule(){
      return Schedule;
  }
  
  public String getSemester(){
      return Semester;
  }
  
  public String getDescription(){
      return Description;
  }
  
  public int getNoteId(){
      return NoteID;
  }
  
  public String getFriendsInClass(){
    return FriendsInClass;
  }
  
  public void setId(String Id) {
        this.ID = Id;
  }
  
  public void setName(String CourseName){
      this.Name = CourseName;
  }
  
  public void setProfessorName(String ProfessorName){
      this.ProfessorName = ProfessorName;
  } 
  
  public void setSchedule(Date Schedule){
      this.Schedule = Schedule;
  }
  
  public void setSemester(String semester){
      this.Semester = semester;
  }
  
  public void setDescription(String Discription){
      this.Description = Discription;
  }
  
  public void setNoteId(int NoteId){
      this.NoteID = NoteId;
  }
  
  public void setFriendsInClass(String FriendsInClass){
       this.FriendsInClass = FriendsInClass;
  }
}