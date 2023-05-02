package es.ssdd.practica.Tournament;

import com.fasterxml.jackson.annotation.JsonView;
import es.ssdd.practica.EntitiesService;
import es.ssdd.practica.TournamentOrganizer.TournamentOrganizer;
import es.ssdd.practica.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/tournaments")
@RestController
public class TournamentsRestController {
    @Autowired
    private EntitiesService service;
    @JsonView(Tournament.Basic.class)
    @GetMapping("/")
    public ResponseEntity getAllTournaments() {
        return new ResponseEntity<>(service.getAllTournaments(), HttpStatus.OK);
    }

    interface Tournaments_Details extends Tournament.Basic, Tournament.Organizers, TournamentOrganizer.Basic,
            Tournament.Participants, User.Basic{}

    @JsonView(Tournaments_Details.class)
    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getElementById(@PathVariable Long id) {
        Optional<Tournament> op = service.getTournamentById(id);
        if(op.isPresent()){
            Tournament tournament = op.get();
            return new ResponseEntity<>(tournament, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @JsonView(Tournaments_Details.class)
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Tournament createTournament(@RequestBody Tournament tournament){
        return service.createTournament(tournament);
    }

    @JsonView(Tournaments_Details.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Tournament>> removeElementById(@PathVariable Long id){
        try{
            Optional<Tournament> deleted_tourament = service.deleteTournament(id);
            return new ResponseEntity<>(deleted_tourament, HttpStatus.OK);
        }
        catch (EmptyResultDataAccessException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @JsonView(Tournaments_Details.class)
    @PutMapping("/{id}")
    public ResponseEntity<Tournament> updateElementById(@RequestBody Tournament updatedTournament, @PathVariable Long id){
        if(service.containsTournament(id)){
            updatedTournament.setId(id);
            service.editTournament(updatedTournament);
            return new ResponseEntity(updatedTournament, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}