package es.ssdd.practica.Tournament;

import com.fasterxml.jackson.annotation.JsonView;
import es.ssdd.practica.TournamentOrganizer.TournamentOrganizer;
import es.ssdd.practica.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tournament {
    public interface Basic{};
    public interface Organizers {};
    public interface Participants {};

    @JsonView(Basic.class)
    private long id = -1;
    @JsonView(Basic.class)
    private String name;
    @JsonView(Basic.class)
    private String date;
    @JsonView(Basic.class)
    private String hour;
    @JsonView(Basic.class)
    private String location;
    @JsonView(Organizers.class)
    private TournamentOrganizer organizer;
    @JsonView(Participants.class)
    private List<User> participants_list = new ArrayList<>();

    public Tournament(String name, String date, String hour, String location) {
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.location = location;
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
    public TournamentOrganizer getOrganizer() {
        return organizer;
    }
    public void setOrganizer(TournamentOrganizer organizer) {
        this.organizer = organizer;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public List<User> getParticipants_list() {
        return participants_list;
    }

    public void setParticipants_list(List<User> participants_list) {
        this.participants_list = participants_list;
    }
}
