package a5.calendar.model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * The EventCreation class is responsible for loading event data from the specified CSV file
 * stored in the application's "assets" folder and creating Event objects.
 * This class provides methods for debugging to view and print the created events.
 */
public class EventCreation {
    private AssetManager am; // Asset manager for the assets folder
    private String line; // Stores current line for each line read from the CSV file
    private List<Event> events; // List of Event objects from the CSV file

    /**
     * Constructor for the EventCreation class.
     * Initializes the events ArrayList, loads/reads events from the CSV file, and prints
     * the total number of events created for evaluation.
     *
     * @param context The application's context used to access the assets.
     */
    public EventCreation(Context context) {
        events = new ArrayList<>();

        // Slide 22 in Catch_Assets_RecyclerView says we gotta do this to access assets if in View Class
        am = context.getAssets();

        loadEvents();
        System.out.println("Events created: " + events.size());
    }


    /**
     * Loads/Reads event data from the "events.csv" file located in the assets folder.
     * Each line in the CSV file is used to create an Event object, which is then added to
     * the events list.
     * Prints a message each time a new event is added for evaluation.
     */
    public void loadEvents() {
        try {
            InputStream inStream = am.open("events.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));

            while ((line = reader.readLine()) != null) {
                // Pass the current line through and split it later
                events.add(new Event(line));
                System.out.println("Added new event!");
            }

            // Close BufferedReader
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the list of Event objects created from the CSV file.
     * Primarily used for debugging to check which events were loaded.
     *
     * @return The list of Event objects.
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Prints the short description of each Event object in the events list to the console.
     * Primarily used for debugging to verify the loaded event data.
     */
    public void printEvents() {
        // Loop through all events in the List<Event> events.
        for (Event event : events) {
            System.out.println(event.getShortDescription());
        }
    }
}
