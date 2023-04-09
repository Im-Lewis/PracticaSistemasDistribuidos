package es.ssdd.practica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tournament {
    private String name;
    private String date;
    private String hour;
    private String location;
    private String organizer;

/*--------------------------------------------------------------------------------------------------------------------*/
/* GETTER AND SETER FUNCTIONS */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getHour() {
        return hour;
    }
    public void setHour(String hour) {
        this.hour = hour;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getOrganizer() {
        return organizer;
    }
    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

/*--------------------------------------------------------------------------------------------------------------------*/
/* Override toString */
    @Override
    public String toString() {
        return "Torneo [Nombre= " + name + ", Fecha= " + date + ", Hora= " + hour +
                ", Localización= " + location + ", Organizador= " + organizer +"]";
    }
}
