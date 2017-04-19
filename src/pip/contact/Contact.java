package pip.contact;

import java.text.SimpleDateFormat;
import java.util.*;
import pip.ArrayListSerializationName;
import pip.WriteFile;
public class Contact implements java.io.Serializable {
  private String name;
  private String email;
  private String address;
  private Date birthday;
  private String number;
  private String Relationship;
  private int NoteId;
  
  public Contact(String name, String email, String relationship, String address, Date birthday, String number){
      this.name = name;
      this.email = email;
      this.Relationship = relationship;
      this.address = address;
      this.birthday = birthday;
      this.number = number;
  }
  
  public Contact(){
      // initialize empty contact object;
  }
  
  public static void fillWithConsole(){
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
  
  public String getName() {
        return name;
  }
  
  public String getEmail(){
      return email;
  }
  
  public String getRelationship(){
      return Relationship;
  }
  public String getAddress(){
      return address;
  }
  
  public Date getBirthday(){
      return birthday;
  }
  
  public int getNoteId(){
      return NoteId;
  }
  
  public String getNumber(){
      return number;
  } 
  
  public void setName(String name) {
        this.name = name;
  }
  
  public void setEmail(String email){
      this.email = email;
  }
  
  public void setAddress(String address){
     this.address = address;
  }
  
  public void setBirthday(Date birthday){
      this.birthday = birthday;
  }
  
  public void setNumber(String number){
      this.number = number;
  } 
  
  public void setRelationship(String Relationship){
      this.Relationship = Relationship;
  }
  
  public void setNoteID(int NoteId){
      this.NoteId = NoteId;
  }
}