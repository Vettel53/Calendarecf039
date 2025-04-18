package a5.calendar.controller;

import java.util.Comparator;
import a5.calendar.model.Event;

public class EventController {
    public static final Comparator<Event> BY_DATE_CATEGORY_NAME =
            (a, b) -> {

                int comp = Integer.compare(a.getMonth(), b.getMonth());
                if (comp != 0) {
                    return comp;
                }

                comp = Integer.compare(a.getDay(), b.getDay());
                if (comp != 0) {
                    return comp;
                }

                comp = a.getCategory().compareTo(b.getCategory());
                if (comp != 0) {
                    return comp;
                }

                return a.getName().compareTo(b.getName());
            };

    public static final Comparator<Event> BY_CATEGORY_DATE_NAME =
            (a, b) -> {
                int comp = a.getCategory().compareTo(b.getCategory());
                if (comp != 0) {
                    return comp;
                }

                return BY_DATE_CATEGORY_NAME.compare(a, b);
            };

    public static final Comparator<Event> BY_NAME_DATE_CATEGORY =
            (a, b) -> {
                int comp = a.getName().compareTo(b.getName());
                if (comp != 0) {
                    return comp;
                }

                return BY_DATE_CATEGORY_NAME.compare(a, b);
            };
}
