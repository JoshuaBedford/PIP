package pip.event;

import java.util.*;
import java.text.SimpleDateFormat;
import pip.ArrayListSerializationName;
import pip.WriteFile;

public class Event implements java.io.Serializable {
  private String EventTitle;
  private Date DateCreated;
  private Date StartTime;
  private Date EndTime;
  private String Description;
  private int ID;

  public Event(String EventTitle, Date DateCreated, Date StartTime, Date EndTime, String Description, int ID) {
        this.EventTitle = EventTitle;
        this.DateCreated = DateCreated;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.Description = Description;
        this.ID = ID;
  }

  public Event() {
        // initialize empty event
  }

  public void fillWithConsole(){
      Scanner console = new Scanner(System.in);
      Date DateCreated;
      Date StartTime = new Date();
      Date EndTime= new Date();
      String Discription;
      int ID;
      System.out.println("Enter the title of the event");
      String eventTitle = console.nextLine();
      System.out.println("Enter the discription");
      Discription = console.nextLine();
      DateCreated = new Date();
       SimpleDateFormat dateFormatter = new SimpleDateFormat("dd:mm:yy h:m:s a z");
      System.out.println("Date Created - " + dateFormatter.format(DateCreated));

       System.out.println("Enter the Start time of the event");
       System.out.println("enter the month in int");
       int month = console.nextInt();
       System.out.println("enter the date");
       int date = console.nextInt();
       System.out.println("enter the year");
       int year = console.nextInt();
       System.out.println("enter hour");
       int hour = console.nextInt();
       System.out.println("enter mins");
       int min =console.nextInt();
       String startTime = month+" " +date+", " + year + " "+hour+":"+min+":00";
       System.out.println("Enter the end time of the event");
       System.out.println("enter the month in int");
       month = console.nextInt();
       System.out.println("enter the date");
       date = console.nextInt();
       System.out.println("enter the year");
       year = console.nextInt();
       System.out.println("Enter the start Time");
       System.out.println("enter hour");
       hour = console.nextInt();
       System.out.println("enter mins");
       min =console.nextInt();
       String endTime = month+" " +date+", " + year + " "+hour+":"+min+":00";
       try{
         StartTime = new SimpleDateFormat("M d,yyyy hh:mm:ss", Locale.ENGLISH).parse(startTime);
         System.out.println(StartTime);
         System.out.println(" to");
         EndTime = new SimpleDateFormat("M d,yyyy hh:mm:ss", Locale.ENGLISH).parse(endTime);
         System.out.println(EndTime);
         }
      catch(Exception e){
         System.out.println("exception");
     }
     System.out.println("Enter the id");
     ID = console.nextInt();
     ArrayListSerializationName.AddEvent(eventTitle+"event.ser");
     WriteFile.writeEvent(eventTitle,DateCreated,StartTime,EndTime,Discription,ID);
  }
  
  public String getEventTitle() {
        return EventTitle;
  }
  
  public Date getDateCreated(){
      return DateCreated;
  }
  
  public Date getStartTime(){
      return StartTime;
  }
  
  public Date getEndTime(){
      return EndTime;
  }
  
  public String getDescription(){
      return Description;
  } 
  
  public void setEventTitle(String eventTitle) {
        this.EventTitle = eventTitle;
  }
  
  public void setDateCreated(Date dateCreated){
      this.DateCreated = dateCreated;
  }
  
  public void setStartTime(Date startTime){
     this.StartTime = startTime;
  }
  
  public void setEndTime(Date endTime){
      this.EndTime = endTime;
  }
  
  public void setDescription(String description){
      this.Description = description;
  } 
}