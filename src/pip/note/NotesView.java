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
import pip.contact.ContactsView;
import pip.course.ClassesView;
import pip.event.EventsView;

/**
 *
 * @author joshua
 */
public class NotesView {

    private WebEngine webEngine;
    
    public NotesView(WebEngine engine){
//        System.out.println(engine);
        
        index(engine);
    }
    
    public void addListeners(WebEngine webEngine) {
        
        webEngine.getLoadWorker().stateProperty().addListener((ObservableValue<? extends Worker.State> observable, Worker.State oldState, Worker.State newState) -> {
            if (newState == Worker.State.SUCCEEDED) {

                Document doc = webEngine.getDocument();
                
                EventListener exitApp;
                exitApp = new EventListener() {
                    public void handleEvent(Event ev) {
                        Platform.exit();
                    }
                };

                EventListener viewNotes;
                viewNotes = new EventListener() {
                    public void handleEvent(Event ev) {
                        NotesView view = new NotesView(webEngine);
//                        Platform.exit();
                    }
                };

                EventListener newNote;
                newNote = new EventListener() {
                    public void handleEvent(Event ev) {
//                        NotesView view = new NotesView(webEngine);
                        create();
//                        Platform.exit();
                    }
                };

                EventListener viewContacts;
                viewContacts = new EventListener() {
                    public void handleEvent(Event ev) {
                        ContactsView view = new ContactsView(webEngine);
                    }
                };

                EventListener viewClasses;
                viewClasses = new EventListener() {
                    public void handleEvent(Event ev) {
                        ClassesView view = new ClassesView(webEngine);
                    }
                };

                EventListener viewEvents;
                viewEvents = new EventListener() {
                    public void handleEvent(Event ev) {
                        EventsView view = new EventsView(webEngine);
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
////                        NotesView.this.search(noteData);
//                    }
//                };
                
                
                Element exit = doc.getElementById("exit-app");
                ((EventTarget) exit).addEventListener("click", exitApp, false);
                
                Element notes = doc.getElementById("view-notes");
                ((EventTarget) notes).addEventListener("click", viewNotes, false);
                
                Element create = doc.getElementById("new-note");
                ((EventTarget) create).addEventListener("click", newNote, false);
                
                Element contacts = doc.getElementById("view-contacts");
                ((EventTarget) contacts).addEventListener("click", viewContacts, false);
                
                Element classes = doc.getElementById("view-classes");
                ((EventTarget) classes).addEventListener("click", viewClasses, false);
                
                Element events = doc.getElementById("view-events");
                ((EventTarget) events).addEventListener("click", viewEvents, false);
                
                
                
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
    
//    public void removeListeners(WebEngine webEngine) {
//        
//        webEngine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
//            if (newState == Worker.State.SUCCEEDED) {
//
//                EventListener exitApp;
//                exitApp = new EventListener() {
//                    public void handleEvent(Event ev) {
//                        Platform.exit();
//                    }
//                };
//
//                EventListener viewNotes;
//                viewNotes = new EventListener() {
//                    public void handleEvent(Event ev) {
//                        NotesView view = new NotesView(webEngine);
////                        Platform.exit();
//                    }
//                };
//
//                EventListener viewContacts;
//                viewContacts = new EventListener() {
//                    public void handleEvent(Event ev) {
//                        ContactsView view = new ContactsView(webEngine);
//                    }
//                };
//
//                EventListener viewClasses;
//                viewClasses = new EventListener() {
//                    public void handleEvent(Event ev) {
//                        ClassesView view = new ClassesView(webEngine);
//                    }
//                };
//
//                EventListener viewEvents;
//                viewEvents = new EventListener() {
//                    public void handleEvent(Event ev) {
//                        EventsView view = new EventsView(webEngine);
//                    }
//                };
//                
//                Document doc = webEngine.getDocument();
//                
//                Element exit = doc.getElementById("exit-app");
//                ((EventTarget) exit).removeEventListener("click", exitApp, false);
//                
//                Element notes = doc.getElementById("view-notes");
//                ((EventTarget) notes).removeEventListener("click", viewNotes, false);
//                
//                Element contacts = doc.getElementById("view-contacts");
//                ((EventTarget) contacts).removeEventListener("click", viewContacts, false);
//                
//                Element classes = doc.getElementById("view-classes");
//                ((EventTarget) classes).removeEventListener("click", viewClasses, false);
//                
//                Element events = doc.getElementById("view-events");
//                ((EventTarget) events).removeEventListener("click", viewEvents, false);
//            }
//        });
//    }
    
    
    private void index(WebEngine webEngine) {
        this.webEngine = webEngine;
        URL url = getClass().getResource("/pip/notes.html");
        this.webEngine.load(url.toExternalForm());
        

        this.webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
                @Override
                public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                    if (newValue == Worker.State.SUCCEEDED) {
                        JSObject windowObject = (JSObject) NotesView.this.webEngine.executeScript("window");
        //                windowObject.setMember("Debug", debug); // insert object

                        windowObject.setMember("NotesView", NotesView.this);
                        windowObject.call("ready"); // execute callback
                    }
                }
            }
        );
        
        
        this.addListeners(webEngine);
    }
    
    private void create(){
        this.webEngine = webEngine;
        URL url = getClass().getResource("/pip/notes-create.html");
        
        this.webEngine.load(url.toExternalForm());

        this.webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
                @Override
                public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                    if (newValue == Worker.State.SUCCEEDED) {
                        JSObject windowObject = (JSObject) NotesView.this.webEngine.executeScript("window");

                        windowObject.setMember("NotesView", NotesView.this);
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
        JSObject windowObject = (JSObject) NotesView.this.webEngine.executeScript("window");
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
