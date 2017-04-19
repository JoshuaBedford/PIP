/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pip.contact;

import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import pip.course.ClassesView;
import pip.event.EventsView;
import pip.note.NotesView;

/**
 *
 * @author joshua
 */
public class ContactsView {
    
    public ContactsView(WebEngine engine){
//        System.out.println(engine);
        execute(engine);
    }
    
    public void addListeners(WebEngine webEngine) {
        
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {

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
                
                Document doc = webEngine.getDocument();
                
                Element exit = doc.getElementById("exit-app");
                ((EventTarget) exit).addEventListener("click", exitApp, false);
                
                Element notes = doc.getElementById("view-notes");
                ((EventTarget) notes).addEventListener("click", viewNotes, false);
                
                Element contacts = doc.getElementById("view-contacts");
                ((EventTarget) contacts).addEventListener("click", viewContacts, false);
                
                Element classes = doc.getElementById("view-classes");
                ((EventTarget) classes).addEventListener("click", viewClasses, false);
                
                Element events = doc.getElementById("view-events");
                ((EventTarget) events).addEventListener("click", viewEvents, false);
            }
        });
    }
    
    public void removeListeners(WebEngine webEngine) {
        
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {

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
                
                Document doc = webEngine.getDocument();
                
                Element exit = doc.getElementById("exit-app");
                ((EventTarget) exit).removeEventListener("click", exitApp, false);
                
                Element notes = doc.getElementById("view-notes");
                ((EventTarget) notes).removeEventListener("click", viewNotes, false);
                
                Element contacts = doc.getElementById("view-contacts");
                ((EventTarget) contacts).removeEventListener("click", viewContacts, false);
                
                Element classes = doc.getElementById("view-classes");
                ((EventTarget) classes).removeEventListener("click", viewClasses, false);
                
                Element events = doc.getElementById("view-events");
                ((EventTarget) events).removeEventListener("click", viewEvents, false);
            }
        });
    }
    
//    public static void main(String[] args){
//        launch(args);
//    }

    private void execute(WebEngine webEngine) {
        URL url = getClass().getResource("/pip/contacts.html");
        webEngine.load(url.toExternalForm());
        
        this.addListeners(webEngine);
    }
    
}
