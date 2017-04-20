/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pip;

import pip.note.NotesController;
import pip.contact.Contact;
import java.net.URL;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import static pip.CreateFile.ClearContactFile;
import pip.contact.ContactController;
import pip.course.CourseController;
import pip.event.EventController;
import pip.note.Notes;


/**
 *
 * @author joshuabedford
 */
public class PIP extends Application {
  
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        URL url = getClass().getResource("index.html");
        
        webEngine.load(url.toExternalForm());
        
        root.getChildren().add(webView);
        Scene scene = new Scene(root);
        primaryStage.setTitle("PIP | Personal Information Package");
        primaryStage.setWidth(1024);
        primaryStage.setHeight(768);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
            if (newState == State.SUCCEEDED) {

                EventListener exitApp;
                exitApp = new EventListener() {
                    public void handleEvent(Event ev) {
                        Platform.exit();
                    }
                };

                EventListener viewNotes;
                viewNotes = new EventListener() {
                    public void handleEvent(Event ev) {
                        NotesController view = new NotesController(webEngine);
//                        Platform.exit();
                    }
                };

                EventListener viewContacts;
                viewContacts = new EventListener() {
                    public void handleEvent(Event ev) {
                        ContactController controller = new ContactController(webEngine);
                    }
                };

                EventListener viewClasses;
                viewClasses = new EventListener() {
                    public void handleEvent(Event ev) {
                        CourseController controller = new CourseController(webEngine);
                    }
                };

                EventListener viewEvents;
                viewEvents = new EventListener() {
                    public void handleEvent(Event ev) {
                        EventController view = new EventController(webEngine);
                    }
                };
                
                Document doc = webEngine.getDocument();
                
                Element exit = doc.getElementById("exit-app");
                ((EventTarget) exit).addEventListener("click", exitApp, false);
                
                Element notes = doc.getElementById("view-notes");
                ((EventTarget) notes).addEventListener("click", viewNotes, false);
                
                Element contacts = doc.getElementById("view-contacts");
                ((EventTarget) contacts).addEventListener("click", viewContacts, false);
                
                Element classes = doc.getElementById("view-courses");
                ((EventTarget) classes).addEventListener("click", viewClasses, false);
                
                Element events = doc.getElementById("view-events");
                ((EventTarget) events).addEventListener("click", viewEvents, false);
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialize project
        CreateFile init = new CreateFile();
        launch(args);

//        Contact contact = new Contact();
//        contact.fillWithConsole();

//        DeSerializationClassName deserialize = new DeSerializationClassName();
//        Notes note = new Notes();
//        note.fillWithConsole();
//        
//        deserialize.SearchNotes("History");
    }
  
}
