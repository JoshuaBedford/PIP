/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pip.note;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.Debug;
import netscape.javascript.JSObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import pip.DeSerializationClassName;
import pip.contact.Contact;
import pip.contact.ContactController;
import pip.course.CourseController;
import pip.event.EventController;

/**
 *
 * @author joshua
 */
public class NotesController {

    private WebEngine webEngine;
    
    public NotesController(WebEngine engine){
//        System.out.println(engine);
        
        index(engine);
    }
    
    public void addListeners(WebEngine webEngine) {
        
        webEngine.getLoadWorker().stateProperty().addListener((ObservableValue<? extends Worker.State> observable, Worker.State oldState, Worker.State newState) -> {
            if (newState == Worker.State.SUCCEEDED) {

                Document doc = webEngine.getDocument();
                
                Element exit = doc.getElementById("exit-app");
                Element notes = doc.getElementById("view-notes");
                Element create = doc.getElementById("new-note");
                Element contacts = doc.getElementById("view-contacts");
                Element classes = doc.getElementById("view-courses");
                Element events = doc.getElementById("view-events");
                
                EventListener exitApp;
                exitApp = new EventListener() {
                    public void handleEvent(Event ev) {
                        Platform.exit();
                    }
                };

                EventListener viewNotes;
                viewNotes = new EventListener() {
                    public void handleEvent(Event ev) {
                        NotesController controller = new NotesController(webEngine);
//                        Platform.exit();
                    }
                };

                EventListener viewContacts;
                viewContacts = new EventListener() {
                    public void handleEvent(Event ev) {
                        ContactController controller = new ContactController(webEngine);
                    }
                };

                EventListener viewCourses;
                viewCourses = new EventListener() {
                    public void handleEvent(Event ev) {
                        CourseController controller = new CourseController(webEngine);
                    }
                };

                EventListener viewEvents;
                viewEvents = new EventListener() {
                    public void handleEvent(Event ev) {
                        EventController controller = new EventController(webEngine);
                    }
                };

//                EventListener searchNotes;
//                searchNotes = new EventListener() {
//                    public void handleEvent(Event ev) {
//                        System.out.println(webEvent.getData());
////                        Element noteData;
////                        noteData = doc.getElementById("notes-data");
////                        String temp;
////                        temp = noteData.getAttribute("value");
////                        System.out.println(temp);
////                        NotesController.this.search(noteData);
//                    }
//                };
                
                
                
                
                        if(((EventTarget) exit) != null){
                            ((EventTarget) exit).addEventListener("click", exitApp, false);
                        }
                
                        if(((EventTarget) notes) != null){
                            ((EventTarget) notes).addEventListener("click", viewNotes, false);
                        }
                
                        if(((EventTarget) contacts) != null){
                            ((EventTarget) contacts).addEventListener("click", viewContacts, false);
                        }
                
                        if(((EventTarget) classes) != null){
                            ((EventTarget) classes).addEventListener("click", viewCourses, false);
                        }
                
                        if(((EventTarget) events) != null){
                            ((EventTarget) events).addEventListener("click", viewEvents, false);
                        }
                
                
                
        //Listen for state change
        webEngine.getLoadWorker().stateProperty().addListener((ov, o, n) -> {
            if (Worker.State.SUCCEEDED == n) {
                webEngine.setOnStatusChanged(webEvent -> {

                    //Call value change
//                    onValueChange(webEvent.getData());
                    System.out.println(webEvent.getData());
                });
            }
        });
            }
        });
    }
    
    
    private void index(WebEngine webEngine) {
        this.webEngine = webEngine;
        URL url = getClass().getResource("/pip/notes.html");
        this.webEngine.load(url.toExternalForm());
        

        this.webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
                @Override
                public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                    if (newValue == Worker.State.SUCCEEDED) {
                        JSObject windowObject = (JSObject) NotesController.this.webEngine.executeScript("window");

                        windowObject.setMember("NotesController", NotesController.this);
                        
                        Document doc = webEngine.getDocument();
                        Element create = doc.getElementById("new-note");
                        EventListener newNote;
                        newNote = new EventListener() {
                            public void handleEvent(Event ev) {
        //                        NotesController controller = new NotesController(webEngine);
                                NotesController.this.create();
        //                        Platform.exit();
                            }
                        };
                        if(((EventTarget) create) != null){
                            ((EventTarget) create).addEventListener("click", newNote, false);
                        }

                        NotesController.this.addListeners(webEngine);
                        
                        windowObject.call("ready"); // execute callback
                    }
                }
            }
        );
        


    }
    
    private void create(){
        this.webEngine = webEngine;
        URL url = getClass().getResource("/pip/notes-create.html");
        
        this.webEngine.load(url.toExternalForm());

        this.webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
                @Override
                public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                    if (newValue == Worker.State.SUCCEEDED) {
                        JSObject windowObject = (JSObject) NotesController.this.webEngine.executeScript("window");

                        windowObject.setMember("NotesController", NotesController.this);
                        windowObject.call("ready"); // execute callback
                    }
                }
            }
        );
        
        
//        this.listeners(webEngine);
    }
    
    
    
    public void print(String data) {
        System.out.println(data);
    }
    
    public boolean search(String data) {
        
        DeSerializationClassName deserialize = new DeSerializationClassName();
        
        ArrayList<Notes> notes;
        notes = deserialize.SearchNotes(data);
        this.setMember("notes", notes.toArray());
        return true;
    }
    
    private void setMember(String name, Object[] notes){
        JSObject windowObject = (JSObject) NotesController.this.webEngine.executeScript("window");
//        System.out.println(contact.getName());
        windowObject.setMember(name, notes);
    }
    
    public void getNotes(){
        DeSerializationClassName deserialize = new DeSerializationClassName();
        
        ArrayList<Notes> notes;
        notes = deserialize.DisplayNotes();
        if(!notes.isEmpty()){
            this.setMember("notes", notes.toArray());
        }
        return;
    }
    
    
    
}
