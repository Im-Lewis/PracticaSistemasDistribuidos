package es.ssdd.practica;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RequestMapping("/rest/tournaments")
@RestController
public class TournamentsRestController {
    private Map<Long, Tournament> tournamentsHashMap = new ConcurrentHashMap<>();

    private AtomicLong lastId = new AtomicLong(2);

    @GetMapping("/")
    public ResponseEntity getAll() {
        return new ResponseEntity<>(tournamentsHashMap.values(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getElementById(@PathVariable Long id) {
        if(tournamentsHashMap.containsKey(id))
            return new ResponseEntity<>(tournamentsHashMap.get(id), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Tournament createtournament(@RequestBody Tournament tournament){
        long id = lastId.incrementAndGet();
        tournament.setId(id);
        tournamentsHashMap.put(id, tournament);
        return tournament;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tournament> removeElementById(@PathVariable Long id){
        Tournament tem = tournamentsHashMap.remove(id);
        return new ResponseEntity<>(tem, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tournament> updateElementById(@RequestBody Tournament tournament, @PathVariable Long id){
        Tournament tempTournament = tournamentsHashMap.get(id);
        if(tempTournament!=null){
            tournamentsHashMap.put(id, tournament);
            return new ResponseEntity<>(tournament, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
