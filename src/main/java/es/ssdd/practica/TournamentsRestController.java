package es.ssdd.practica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rest/tournaments")
@RestController
public class TournamentsRestController {
    @Autowired
    TournamentService tournamentService;

    @GetMapping("/")
    public ResponseEntity getAll() {
        return new ResponseEntity<>(tournamentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getElementById(@PathVariable Long id) {
        if(tournamentService.containsTournament(id))
            return new ResponseEntity<>(tournamentService.getTournamentById(id), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Tournament createTournament(@RequestBody Tournament tournament){
        return tournamentService.createTournament(tournament);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tournament> removeElementById(@PathVariable Long id){
        return new ResponseEntity<>(tournamentService.deleteTournament(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tournament> updateElementById(@RequestBody Tournament tournament, @PathVariable Long id){
        Tournament tempTournament = tournamentService.getTournamentById(id);
        if(tempTournament!=null){
            return new ResponseEntity<>(tournamentService.editTournament(id, tournament), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
