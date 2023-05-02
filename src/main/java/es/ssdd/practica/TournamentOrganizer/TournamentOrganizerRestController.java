package es.ssdd.practica.TournamentOrganizer;

import com.fasterxml.jackson.annotation.JsonView;
import es.ssdd.practica.EntitiesService;
import es.ssdd.practica.Tournament.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/organizers")
@RestController
public class TournamentOrganizerRestController {
    @Autowired
    private EntitiesService service;

    @JsonView(TournamentOrganizer.Basic.class)
    @GetMapping("/")
    public ResponseEntity getAllOrganizers() {
        return new ResponseEntity<>(service.getAllOrganizers(), HttpStatus.OK);
    }

    interface Organizer_Details extends TournamentOrganizer.Basic, TournamentOrganizer.Tournaments, Tournament.Basic {
    }
    @JsonView(Organizer_Details.class)
    @GetMapping("/{id}")
    public ResponseEntity<TournamentOrganizer> getElementById(@PathVariable Long id) {
        Optional<TournamentOrganizer> op = service.getOrganizerById(id);
        if(op.isPresent()) {
            TournamentOrganizer organizer = op.get();
            return new ResponseEntity<>(organizer, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @JsonView(Organizer_Details.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public TournamentOrganizer createOrganizer(@RequestBody TournamentOrganizer organizer){
        return service.createOrganizer(organizer);
    }

    @JsonView(Organizer_Details.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<TournamentOrganizer>> removeElementById(@PathVariable Long id){
        try{
            Optional<TournamentOrganizer> deleted_organizer = service.deleteOrganizer(id);
            return new ResponseEntity<>(deleted_organizer, HttpStatus.OK);
        }
        catch(EmptyResultDataAccessException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @JsonView(Organizer_Details.class)
    @PutMapping("/{id}")
    public ResponseEntity<TournamentOrganizer> updateElementById(@RequestBody TournamentOrganizer updatedOrganizer, @PathVariable Long id){
        if(service.containsOrganizer(id)){
            updatedOrganizer.setId(id);
            service.editOrganizer(updatedOrganizer);
            return new ResponseEntity(updatedOrganizer, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}