package a5.calendar;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import a5.calendar.controller.EventController;
import a5.calendar.model.Event;
import a5.calendar.model.EventCreation;
import a5.calendar.view.Adapter;

import java.util.List;

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

        // Instantiate Controller
        List<Event> events = eventCreate.getEvents();
        events.sort(EventController.BY_DATE_CATEGORY_NAME);
        adapter.notifyDataSetChanged();

        // Instantiate Buttons
        Button sortByDate = findViewById(R.id.sort_by_date);
        Button sortByName = findViewById(R.id.sort_by_name);
        Button sortByCategory = findViewById(R.id.sort_by_category);

        // Instantiate Button setOnClickListeners
        sortByDate.setOnClickListener(v -> {
            events.sort(EventController.BY_DATE_CATEGORY_NAME);
            adapter.notifyDataSetChanged();
        });

        sortByName.setOnClickListener(v -> {
            events.sort(EventController.BY_NAME_DATE_CATEGORY);
            adapter.notifyDataSetChanged();
        });

        sortByCategory.setOnClickListener(v -> {
            events.sort(EventController.BY_CATEGORY_DATE_NAME);
            adapter.notifyDataSetChanged();
        });
        /**
         * NOTE: For my teammates, most of this was extracted/learned-from the slides
         * ("23_Catch_Assets_RecyclerView.pdf" in the class files) and ("25_2nd_Activity.pdf)
         *
         */

    }
}
