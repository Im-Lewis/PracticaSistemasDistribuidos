package es.ssdd.practica.TournamentOrganizer;

import com.fasterxml.jackson.annotation.JsonView;
import es.ssdd.practica.Tournament.Tournament;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class TournamentOrganizer {
    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Interfaces */
    public interface Basic{}
    public interface Tournaments {}

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Atributes */
    @JsonView(Basic.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id = -1;
    @JsonView(Basic.class)
    private String name;
    @JsonView(Tournaments.class)
    @OneToOne(mappedBy = "organizer", cascade = CascadeType.ALL)
    private Tournament organized_tournament;

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Constructor */
    public TournamentOrganizer(String name) {
        this.name = name;
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* GETTER AND SETTER FUNCTIONS */
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Tournament getOrganized_tournament() {
        return organized_tournament;
    }
    public void setOrganized_tournament(Tournament organized_tournament) {
        this.organized_tournament = organized_tournament;
    }
}
