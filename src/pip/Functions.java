package pip;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class Functions {
   public static void main(String[] args){
     //setContactDetails();
     //setEventDetails();
     //setNotesDetails();
     //setCourseDetails();
     //setAssighnmentDetails();
     //searchContacts();
     //searchEvent();
     //searchNotes();
     //searchCourse();
//     searchAssignment();
   }
   
   //this function takes the details of the contact to add
   //Sets the attribute like email and name to the Contact object
   public static void setContactDetails(){
      Scanner console = new Scanner(System.in);
      Date DateCreated = new Date();
      Date Birthday = new Date();
      Date EndTime = new Date();
      System.out.println("Enter the name");
      String Name = console.nextLine().toLowerCase();
      while(Name.equals("")){
         System.out.println(" Name cannot be empty Enter the name");
         Name = console.nextLine();
      }

		// email elements
      int count =0;
      int count1 =0;
      System.out.println("Enter the email");
         String Email = console.nextLine();
      while(count ==0 || Email.equals("")){
         if(Email.equals("")){
            System.out.println("email can't be null");
            count1 =1;
         }
         if(count1 != 0){
            System.out.println("Enter a Valid email");
            Email = console.nextLine();
         }
         count1 =1;
         for(int i=0;i<Email.length();i++){
            if(Email.charAt(i)== '@' ){
               count++;
            } 
         }
      }

		// address elements
      System.out.println("Enter the address");
      String Address = console.nextLine();
      while(Address.equals("")){
         System.out.println("Address Name cannot be empty Enter the Address ");
         Address = console.nextLine();
      }
         

      
      // Phone no elements
      System.out.println("Enter the Phone number");
      String PhoneNumber = console.nextLine();
      while(PhoneNumber.equals("") || (PhoneNumber.length() < 10)){
         if(PhoneNumber.equals("")){   
            System.out.println("Number can not be empty");
         }
         if (PhoneNumber.length() < 10){
            System.out.println("The length of the phone number should be 10 or more");
         }
         System.out.println("enter the phone number");
         PhoneNumber = console.nextLine();
      }
      System.out.println("Enter your relation with this person");
      String Relationship= console.nextLine();
      
      //Birthday element
      System.out.println("Enter the birthday");
      System.out.println("enter the month in int");
       int month = console.nextInt();
       if(month<=0 || month>12){
        while(month >0 && month<=12){
          System.out.println("Please enter the month between 1 to 12");
          month = console.nextInt();
        }
       }
       System.out.println("enter the date");
       int date = console.nextInt();
       if(date<=0 || date>31){
        while(date >0 && date<=31){
          System.out.println("Please enter the date between 1 to 31");
          date = console.nextInt();
        }
       }
       System.out.println("enter the year");
       int year = console.nextInt();
       if(year>=Calendar.getInstance().get(Calendar.YEAR)){
        while(year<Calendar.getInstance().get(Calendar.YEAR)){
          System.out.println("Please enter year less then"+Calendar.getInstance().get(Calendar.YEAR));
          year = console.nextInt();
        }
       }
       int hour = 12;
       int min =00;
       String Birthdate = month+" " +date+", " + year + " "+hour+":"+min+":00";
       String endTime = month+" " +(date-1)+", " + year + " "+(hour+23)+":"+(min+59)+":00";

       try{
         Birthday = new SimpleDateFormat("M d,yyyy hh:mm:ss", Locale.ENGLISH).parse(Birthdate);
         EndTime = new SimpleDateFormat("M d,yyyy hh:mm:ss", Locale.ENGLISH).parse(endTime);

         }
      catch(Exception e){
         System.out.println("exception");
     }

      System.out.println("Enter the Note Id");
      int NoteId = console.nextInt();
      String Discription = "Its "+Name+"'s Birthday";
      ArrayListSerializationName.AddContact(Name+"contact.ser");
      int ID = 1;
      WriteFile.writeContact(Name,Email,Address,Birthday,PhoneNumber,Relationship,NoteId);
      Birthdate = month+" " +date+", " + (Calendar.getInstance().get(Calendar.YEAR)) + " "+hour+":"+min+":00";
      endTime = month+" " +(date-1)+", " + (Calendar.getInstance().get(Calendar.YEAR)) + " "+(hour+23)+":"+(min+59)+":00";
 
       try{
         Birthday = new SimpleDateFormat("M d,yyyy hh:mm:ss", Locale.ENGLISH).parse(Birthdate);
          EndTime = new SimpleDateFormat("M d,yyyy hh:mm:ss", Locale.ENGLISH).parse(endTime);
         }
      catch(Exception e){
         System.out.println("exception");
     }
      DateCreated = new Date();
       SimpleDateFormat dateFormatter = new SimpleDateFormat("M d,yyyy hh:mm:ss");
      ArrayListSerializationName.AddEvent(Name+"'s Birthdayevent.ser");
      WriteFile.writeEvent((Name+"'s Birthday"),DateCreated,Birthday,EndTime,Discription, ID);

   }
   
   
   //This function asks for event details and
   //Sets the attributes like event title and date to Event object
   public static void setEventDetails(){
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
   
   //This sets the Notes Details 
   public static void setNotesDetails(){
      Scanner console = new Scanner(System.in);
      String notesTitle;
      Date DateCreated;
      String Content = "";
      int ID;
      System.out.println("Enter the title of the notes");
      notesTitle = console.nextLine();
      DateCreated = new Date();
      SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, MMMM-dd 'at' hh:mm a z");
      System.out.println("Date Created - " + dateFormatter.format(DateCreated));
      System.out.println("Enter the content");
      String line = console.nextLine();
      while (!(line).equals("")){
        Content += line+"\n             ";
        line = console.nextLine();
      }
      System.out.println("Enter the id");
      ID = console.nextInt();
      ArrayListSerializationName.AddNotes(notesTitle+"notes.ser");
      WriteFile.writeNotes(notesTitle,DateCreated,Content,ID); 
   }
   
   
   public static void setCourseDetails(){
      Scanner console = new Scanner(System.in);
      String CourseId;
      String CourseName;
      String ProfessorName;
      Date Scedule = new Date();
      String Semester;
      String Discription;
      int NoteId;
      
      System.out.println("Enter the Course name");
      CourseName = console.nextLine();
      System.out.println("Enter the Professor name");
      ProfessorName = console.nextLine();
      System.out.println("Enter the Semester");
      Semester = console.nextLine();
      System.out.println("Enter the Discription");
      Discription = console.nextLine();
      System.out.println("Enter the Course ID");
      CourseId = console.nextLine();
      System.out.println("Enter the name of the friends in this class");
      String Content = "";
      String friendsInClass = console.nextLine();
      while (!(friendsInClass).equals("")){
        Content += friendsInClass+"\n                  ";
        friendsInClass = console.nextLine();
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
         Scedule = sdf.parse(scedule);
         System.out.println(Scedule);
         }
      catch(Exception e){
         System.out.println("exception");
     }

   
      System.out.println("Enter the NoteID");
      NoteId = console.nextInt();
      ArrayListSerializationName.AddCourse(CourseName+"course.ser");
      WriteFile.writeCourse(CourseId,CourseName,ProfessorName,Scedule,Semester,Discription,Content,NoteId); 
   }
   
   public static void setAssignmentDetails(){
      Scanner console = new Scanner(System.in);
      int AssignmentId;
      String CourseId;
      String CourseName;
      String Requirements;
      Date DueDate = new Date();
      int Points;
      int NoteId;
      
      System.out.println("Enter the Course name");
      CourseName = console.nextLine();
      System.out.println("Enter the Discription of requirements of the assignment");
      Requirements = console.nextLine();
      System.out.println("Enter the courseId");
      CourseId = console.nextLine();
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
         DueDate = new SimpleDateFormat("MM-d-yyyy hh:mm:ss", Locale.ENGLISH).parse(duedate);
         System.out.println(duedate);
         }
      catch(Exception e){
         System.out.println("exception");
      }
      System.out.println("Enter the points of the assignment");
      Points = console.nextInt();
      System.out.println("Enter the Note id");
      NoteId = console.nextInt();
      ArrayListSerializationName.AddAssignment(CourseName+"assignment.ser");
      WriteFile.writeAssignment(CourseId,CourseName,Requirements,DueDate,Points,NoteId); 
   }
   
   public static void searchContacts(){
   Scanner console = new Scanner(System.in);
      System.out.println("Enter the name of the person whose contact you want to search");
      String toSearch = console.nextLine().toLowerCase();
      DeSerializationClassName.SearchContacts(toSearch);
   }
   
   public static void searchEvent(){
   Scanner console = new Scanner(System.in);
      System.out.println("Enter what you want to search");
      String toSearch = console.nextLine().toLowerCase();
      DeSerializationClassName.SearchEvent(toSearch);
   }
   
   public static void searchNotes(){
   Scanner console = new Scanner(System.in);
      System.out.println("Enter what you want to search");
      String toSearch = console.nextLine().toLowerCase();
      DeSerializationClassName.SearchNotes(toSearch);
   }
   
   public static void searchCourse(){
   Scanner console = new Scanner(System.in);
      System.out.println("Enter what you want to search");
      String toSearch = console.nextLine().toLowerCase();
      DeSerializationClassName.SearchCourse(toSearch);
   }
   
   public static void searchAssignment(){
   Scanner console = new Scanner(System.in);
      System.out.println("Enter what you want to search");
      String toSearch = console.nextLine().toLowerCase();
      DeSerializationClassName.SearchAssignment(toSearch);
   }

 }
    