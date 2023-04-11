package es.ssdd.practica.TournamentOrganizer;

import com.fasterxml.jackson.annotation.JsonView;
import es.ssdd.practica.EntitiesService;
import es.ssdd.practica.Tournament.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rest/organizers")
@RestController
public class TournamentOrganizerRestController {
    @Autowired
    EntitiesService entitiesService;

    @JsonView(TournamentOrganizer.Basic.class)
    @GetMapping("/")
    public ResponseEntity getAllOrganizers() {
        return new ResponseEntity<>(entitiesService.getAllOrganizers(), HttpStatus.OK);
    }

    interface Organizer_Details extends TournamentOrganizer.Basic, TournamentOrganizer.Tournaments, Tournament.Basic {
    }
    @JsonView(Organizer_Details.class)
    @GetMapping("/{id}")
    public ResponseEntity<TournamentOrganizer> getElementById(@PathVariable Long id) {
        if(entitiesService.containsOrganizer(id))
            return new ResponseEntity<>(entitiesService.getOrganizerById(id), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @JsonView(Organizer_Details.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public TournamentOrganizer createOrganizer(@RequestBody TournamentOrganizer organizer){
        return entitiesService.createOrganizer(organizer);
    }

    @JsonView(Organizer_Details.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<TournamentOrganizer> removeElementById(@PathVariable Long id){
        return new ResponseEntity<>(entitiesService.deleteOrganizer(id), HttpStatus.OK);
    }

    @JsonView(Organizer_Details.class)
    @PutMapping("/{id}")
    public ResponseEntity<TournamentOrganizer> updateElementById(@RequestBody TournamentOrganizer organizer, @PathVariable Long id){
        TournamentOrganizer tempOrganizer = entitiesService.getOrganizerById(id);
        if(tempOrganizer!=null){
            return new ResponseEntity<>(entitiesService.editOrganizer(id, organizer), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

