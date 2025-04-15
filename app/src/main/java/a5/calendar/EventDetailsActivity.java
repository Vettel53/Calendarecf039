package a5.calendar;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EventDetailsActivity extends AppCompatActivity {

    /**
     * Entry point for the "second activity" view as specified in the assignment details.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail_layout);

        // Set the shortened descrption for each calendar event
        TextView detailsTextView = findViewById(R.id.details_text_view);

        String description = getIntent().getStringExtra("event_description");
        detailsTextView.setText(description);
    }

}
