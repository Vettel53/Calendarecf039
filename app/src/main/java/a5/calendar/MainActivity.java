package a5.calendar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import a5.calendar.model.EventCreation;
import a5.calendar.view.Adapter;

public class MainActivity extends AppCompatActivity {

    /**
     * Entry point for the "first/main activity" view as specified in the assignment details.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate event creation (Reading from CSV)
        EventCreation eventCreate = new EventCreation(this);
        // Debugging (See what events were added)
        eventCreate.printEvents();

        // Instantiate View
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Instantiate Adapter
        Adapter adapter = new Adapter(eventCreate.getEvents(), this);
        recyclerView.setAdapter(adapter);

        // TODO: Instantiate Controller (I think this is the thing for sorting)

        /**
         * NOTE: For my teammates, most of this was extracted/learned-from the slides
         * ("23_Catch_Assets_RecyclerView.pdf" in the class files) and ("25_2nd_Activity.pdf)
         * */

        // TODO: Set sort buttons onClickListeners
        // TODO: UML Diagram

    }
}