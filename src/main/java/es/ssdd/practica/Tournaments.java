package es.ssdd.practica;

public class Tournaments {
    private String name;
    private String date;
    private String hour;
    private String location;
    private String organizer;

    private int tounament_id = -1;

    public Tournaments(String name, String date, String hour, String location, String organizer, int tounament_id) {
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.location = location;
        this.organizer = organizer;
        this.tounament_id = tounament_id;
    }

    /* Getter functions */
    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    public String getLocation() {
        return location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public int getTounament_id() {
        return tounament_id;
    }

    /* Setter functions */

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public void setTounament_id(int tounament_id) {
        this.tounament_id = tounament_id;
    }
}
