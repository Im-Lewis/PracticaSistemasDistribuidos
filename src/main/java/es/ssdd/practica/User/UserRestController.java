package es.ssdd.practica.User;

import com.fasterxml.jackson.annotation.JsonView;
import es.ssdd.practica.EntitiesService;
import es.ssdd.practica.Tournament.Tournament;
import es.ssdd.practica.TournamentOrganizer.TournamentOrganizer;
import es.ssdd.practica.TournamentOrganizer.TournamentOrganizerRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rest/users")
@RestController
public class UserRestController {
    @Autowired
    EntitiesService entitiesService;

    @JsonView(User.Basic.class)
    @GetMapping("/")
    public ResponseEntity getAllUsers() {
        return new ResponseEntity<>(entitiesService.getAllUsers(), HttpStatus.OK);
    }

    interface User_Details extends User.Basic, User.Tournaments, Tournament.Basic {
    }
    @JsonView(User_Details.class)
    @GetMapping("/{dni}")
    public ResponseEntity<User> getElementById(@PathVariable String dni) {
        if(entitiesService.containsUser(dni))
            return new ResponseEntity<>(entitiesService.getUserById(dni), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @JsonView(User_Details.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public User createOrganizer(@RequestBody User user){
        return entitiesService.createUser(user);
    }

    @JsonView(User_Details.class)
    @DeleteMapping("/{dni}")
    public ResponseEntity<User> removeElementById(@PathVariable String dni){
        return new ResponseEntity<>(entitiesService.deleteUser(dni), HttpStatus.OK);
    }

    @JsonView(User_Details.class)
    @PutMapping("/{dni}")
    public ResponseEntity<User> updateElementById(@RequestBody User user, @PathVariable String dni){
        User tempUser = entitiesService.getUserById(dni);
        if(tempUser!=null){
            return new ResponseEntity<>(entitiesService.editUser(dni, user), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
