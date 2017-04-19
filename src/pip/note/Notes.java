package pip.note;

import java.util.*;
import java.text.SimpleDateFormat;
import pip.ArrayListSerializationName;
import pip.WriteFile;

public class Notes implements java.io.Serializable {
  private String Title;
  private Date DateCreated;
  private String Content;
  private int ID;
  
  public Notes(String Title, Date DateCreated, String Content){
      // initialize notes.
      this.Title = Title;
      this.DateCreated = DateCreated;
      this.Content = Content;
      this.ID = ID;
  }
  
  public Notes(){
   // Initialize empty notes object.   
  }
  
  public void fillWithConsole(){
      Scanner console = new Scanner(System.in);
      System.out.println("Enter the title of the notes");
      this.Title = console.nextLine();
      this.DateCreated = new Date();
      SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, MMMM-dd 'at' hh:mm a z");
      System.out.println("Date Created - " + dateFormatter.format(DateCreated));
      System.out.println("Enter the content");
      String line = console.nextLine();
      while (!(line).equals("")){
        this.Content += line+"\n             ";
        line = console.nextLine();
      }
      System.out.println("Enter the id");
      this.ID = console.nextInt();
      ArrayListSerializationName.AddNotes(this.Title+"notes.ser");
      WriteFile.writeNotes(this.Title,this.DateCreated,this.Content,this.ID);   
  }
  
  public String getTitle() {
        return this.Title;
  }
  
  public Date getDateCreated(){
      return this.DateCreated;
  }
  
  public String getContent(){
      return Content;
  } 
  
  public int getID(){
      return ID;
  }
  
  public void setTitle(String title) {
        this.Title = title;
  }
  
  public void setDateCreated(Date dateCreated){
      this.DateCreated = dateCreated;
  }
  
  public void setContent(String content){
      this.Content = content;
  } 
  
  public void setID(int id){
      this.ID = id;
  }
}