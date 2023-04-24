package es.ssdd.practica.Tournament;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Tournament {

    @javax.persistence.Id
    @Id
    private long id;
    private String name;
    private String date;
    private String hour;
    private String location;
    private String organizer;

    public Tournament(String name, String date, String hour, String location, String organizer) {
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.location = location;
        this.organizer = organizer;
    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
