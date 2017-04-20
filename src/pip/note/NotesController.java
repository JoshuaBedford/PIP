/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pip.note;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
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
import pip.ArrayListSerializationName;
import pip.DeSerializationClassName;
import pip.WriteFile;
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
            }
        });
    } 

    /**
     * Loads the index page for Notes, showing all notes.
     * @param webEngine 
     */
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

    /**
     * Display the selected note
     * @param webEngine 
     */
    public void show(Notes note) {
        URL url = getClass().getResource("/pip/notes-show.html");
        this.webEngine.load(url.toExternalForm());
        

        this.webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
                @Override
                public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                    if (newValue == Worker.State.SUCCEEDED) {
                        JSObject windowObject = (JSObject) NotesController.this.webEngine.executeScript("window");

                        windowObject.setMember("NotesController", NotesController.this);
                        
                        windowObject.setMember("note", note);
                        
                        
                        windowObject.call("ready"); // execute callback
                    }
                }
            }
        );
        


    }
    
    /**
     * 
     * Loads the create page for Notes, showing the note create form.
     *
     */
    private void create(){
        this.webEngine = webEngine;
        URL url = getClass().getResource("/pip/notes-create.html");
        
        this.webEngine.load(url.toExternalForm());

        this.webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
                @Override
                public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                    if (newValue == Worker.State.SUCCEEDED) {
                        JSObject windowObject = (JSObject) NotesController.this.webEngine.executeScript("window");

//                        Document doc = webEngine.getDocument();
//                        Element create = doc.getElementById("create-note");
//
//                        EventListener createNote;
//                        createNote = new EventListener() {
//                            public void handleEvent(Event ev) {
//                                System.out.println(doc.getElementById("note-title").value);
//                                System.out.println(doc.getElementById("note-content").value);
//                                System.out.println("creating note....");
////                                Platform.exit();
//                            }
//                        };
//                        
//                        if(((EventTarget) create) != null){
//                            ((EventTarget) create).addEventListener("click", createNote, false);
//                        }

                        windowObject.setMember("NotesController", NotesController.this);
                        windowObject.call("ready"); // execute callback
                    }
                }
            }
        );
        
        
//        this.listeners(webEngine);
    }

    /**
     * Saves a given note to be serialized.
     * @param note 
     */
    public void store(String title, String content){
        // this will store (create) the given note.
        Notes note = new Notes();
        note.setTitle(title);
        note.setContent(content);
        note.setDateCreated(new Date());
        
        ArrayListSerializationName.AddNotes(note.getTitle()+"notes.ser");
        WriteFile.writeNotes(note.getTitle(),note.getDateCreated(),note.getContent(),note.getID());
        
        this.index(webEngine);
    }

    /**
     * Shows the correct form to edit the specified note.
     * @param webEngine 
     */
    private void edit(Notes note){
        // show the form
    }

    /**
     * Updates the specified note with changes.
     * @param note
     */
    private void update(Notes note){
        // this will update (edit) the given note.
    }

    /**
     * Deletes the given note.
     * @param note
     */
    private void destroy(Notes note){
        // this will destroy (delete) the given note.
    }

    /**
     * Print data to console.
     * @param data
     */
    public void print(String data) {
        System.out.println(data);
    }

    /**
     * Searches notes for given term and sets JS object in WebView with results.
     * @param data
     */
    public boolean search(String data) {
        
        DeSerializationClassName deserialize = new DeSerializationClassName();
        
        ArrayList<Notes> notes;
        notes = deserialize.SearchNotes(data);
        this.setMember("notes", notes.toArray());
        return true;
    }

    /**
     * Sets a JS object in WebView.
     * @param name
     * @param notes
     */
    private void setMember(String name, Object[] notes){
        JSObject windowObject = (JSObject) NotesController.this.webEngine.executeScript("window");
        windowObject.setMember(name, notes);
    }

    /**
     * 
     * Retrieves all notes and calls setMember to send to WebView
     *
     */
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
