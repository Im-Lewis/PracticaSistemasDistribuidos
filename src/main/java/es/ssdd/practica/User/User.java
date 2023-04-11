package es.ssdd.practica.User;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import es.ssdd.practica.Tournament.Tournament;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public interface Basic{};
    public interface Tournaments{};
    @JsonView(Basic.class)
    private String DNI = "-1";
    @JsonView(Basic.class)
    private String name;
    @JsonView(Basic.class)
    private String lastName;
    @JsonView(Tournaments.class)
    private List<Tournament> participating_in = new ArrayList<>();

    public User(String DNI, String name, String lastName) {
        this.DNI = DNI;
        this.name = name;
        this.lastName = lastName;
    }

/*--------------------------------------------------------------------------------------------------------------------*/
/* GETTER AND SETTER FUNCTIONS */
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public List<Tournament> getParticipating_in() {
        return participating_in;
    }
    public void setParticipating_in(List<Tournament> participating_in) {
        this.participating_in = participating_in;
    }
}



