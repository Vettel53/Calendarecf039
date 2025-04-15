package a5.calendar.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import a5.calendar.EventDetailsActivity;
import a5.calendar.R;
import a5.calendar.model.Event;

/**
 * This ViewHolder class represents a single "event" entity in the main RecyclerView.
 * It also provides the onClickListener for each details button on each "event" entity.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView eventText; // The shortened description text for each "event" item
    private Button detailsButton; // The details button for each "event" item

    /**
     * Constructor for the ViewHolder class. Initializes the components for each "event" item
     * in the ViewHolder.
     *
     * @param itemView The view of the individual event item.
     */
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        // Find and set the instance variables by ID's
        eventText = itemView.findViewById(R.id.event_blurb);
        detailsButton = itemView.findViewById(R.id.details_button);
    }

    /**
     * Binds the event data to the view components and sets up the onClickListener
     * for the details button. The onClickListener calls the EventDetailsActivity
     * and passes the event description through an "Intent".
     *
     * @param event The Event object containing the "event" details to be displayed.
     * @param context The context used for calling/starting the EventDetailsActivity.
     */
    public void bind(Event event, Context context)  {
        // Set the shortended description for the event
        eventText.setText(event.getShortDescription());

        // Set a clicker listener for each details button on each event item
        // Opens EntityDetailsActivity (Called "Second Activity" in the assignment PDF"
        detailsButton.setOnClickListener(e -> {

            Intent intent = new Intent(context, EventDetailsActivity.class);
            intent.putExtra("event_description", event.getDescription());

            // 2nd Activity passes no info, so we start using "startActivity" method.
            context.startActivity(intent);
        });
    }
}
