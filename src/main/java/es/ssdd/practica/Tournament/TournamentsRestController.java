package es.ssdd.practica.Tournament;

import com.fasterxml.jackson.annotation.JsonView;
import es.ssdd.practica.EntitiesService;
import es.ssdd.practica.TournamentOrganizer.TournamentOrganizer;
import es.ssdd.practica.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/tournaments")
@RestController
public class TournamentsRestController {
    @Autowired
    EntitiesService entitiesService;

    @JsonView(Tournament.Basic.class)
    @GetMapping("/")
    public ResponseEntity getAllTournaments() {
        return new ResponseEntity<>(entitiesService.getAllTournaments(), HttpStatus.OK);
    }

    interface Tournaments_Details extends Tournament.Basic, Tournament.Organizers, TournamentOrganizer.Basic,
            Tournament.Participants, User.Basic{
    }

    @JsonView(Tournaments_Details.class)
    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getElementById(@PathVariable Long id) {
        if(entitiesService.containsTournament(id))
            return new ResponseEntity<>(entitiesService.getTournamentById(id), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @JsonView(Tournaments_Details.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Tournament createTournament(@RequestBody Tournament tournament){
        return entitiesService.createTournament(tournament);
    }

    @JsonView(Tournaments_Details.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<Tournament> removeElementById(@PathVariable Long id){
        return new ResponseEntity<>(entitiesService.deleteTournament(id), HttpStatus.OK);
    }

    @JsonView(Tournaments_Details.class)
    @PutMapping("/{id}")
    public ResponseEntity<Tournament> updateElementById(@RequestBody Tournament tournament, @PathVariable Long id){
        Tournament tempTournament = entitiesService.getTournamentById(id);
        if(tempTournament!=null){
            return new ResponseEntity<>(entitiesService.editTournament(id, tournament), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
