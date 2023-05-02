package es.ssdd.practica.Tournament;

import com.fasterxml.jackson.annotation.JsonView;
import es.ssdd.practica.TournamentOrganizer.TournamentOrganizer;
import es.ssdd.practica.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Tournament {
    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Interfaces */
    public interface Basic{}
    public interface Organizers{}
    public interface Participants{}

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Atributes */
    @JsonView(Basic.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;
    @JsonView(Basic.class)
    private String name;
    @JsonView(Basic.class)
    private String date;
    @JsonView(Basic.class)
    private String hour;
    @JsonView(Basic.class)
    private String location;
    @JsonView(Organizers.class)
    @OneToOne(cascade = CascadeType.ALL)
    private TournamentOrganizer organizer;
    @JsonView(Participants.class)
    @ManyToMany
    private List<User> participants = new ArrayList<>();

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Constructor */
    public Tournament(String name, String date, String hour, String location) {
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.location = location;
        this.organizer = new TournamentOrganizer("");
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
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public TournamentOrganizer getOrganizer() {
        return organizer;
    }
    public void setOrganizer(TournamentOrganizer organizer) {
        this.organizer = organizer;
    }
    public List<User> getParticipants() {
        return participants;
    }
    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}
