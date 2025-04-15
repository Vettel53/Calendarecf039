package a5.calendar.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import a5.calendar.R;
import a5.calendar.model.Event;

/**
 * This adapter class gives each "Event" data, to the views in the "RecyclerView".
 * Provides a method to update the events after they are sorted.
 */
public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Event> events; // List of events to display
    private Context context; // The current context of the application

    /**
     * Constructor to initialize the Adapter with the list of events from the CSV and the current
     * context.
     *
     * @param events A list of Event objects that will be displayed in the RecyclerView
     * @param context The current context used.
     */
    public Adapter(List<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    /**
     * Called when RecyclerView needs a new ViewHolder for an "event".
     * Inflates the layout for individual event items and creates a ViewHolder instance.
     *
     * @param parent The parent ViewGroup into which the item view will be added.
     * @param viewType The type of view to be created.
     * @return A new ViewHolder instance.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item_layout, parent, false);

        return new ViewHolder(view);
    }

    /**
     * Binds the data for a specific entity in the viewholder
     * Sets event details (Description, etc) and click listeners for the item view.
     *
     * @param holder The ViewHolder to bind the data to.
     * @param position The position of the item in the dataset.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Event event = events.get(position);

        holder.bind(event, context);
    }


    /**
     * Returns the total number of items in the dataset (the class variable "events").
     *
     * @return The size of the events list.
     */
    @Override
    public int getItemCount() {
        return events.size();
    }

    /**
     * This method is used to update the RecyclerView.
     * Must be called each time the events are sorted!
     *
     * @param updatedEvents
     */
    public void updateEvents(List<Event> updatedEvents) {
        this.events = updatedEvents;
        notifyDataSetChanged();
    }

}
