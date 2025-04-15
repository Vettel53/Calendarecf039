package a5.calendar.model;

public class Event {
    // Might be able to store these all in string? Probably not cause of sorting shit
    private String category;
    private String name;
    private String location;
    private int month;
    private int day;
    private String price;
    private String description;

    public Event(String currLine) {
        // Store the entire line into parts, then store those parts correctly like in Slide 29 in Catch_Assets_RecyclerView
        String[] parts = currLine.split(",");
        this.category = parts[0].trim();
        this.name = parts[1].trim();
        this.location = parts[2].trim();
        this.month = Integer.parseInt(parts[3].trim());
        this.day = Integer.parseInt(parts[4].trim());
        this.price = parts[5].trim();
        this.description = parts[6].trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets a short description of the event used in the main view.
     *
     * @return String of the shortened description
     */
    public String getShortDescription() {
        return getMonth() + "/" +
                getDay() + " " +
                getCategory() + ": " +
                getName();
    }
}
