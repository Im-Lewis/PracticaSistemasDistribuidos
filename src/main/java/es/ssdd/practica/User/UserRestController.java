package es.ssdd.practica.User;

import com.fasterxml.jackson.annotation.JsonView;
import es.ssdd.practica.EntitiesService;
import es.ssdd.practica.Tournament.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/users")
@RestController
public class UserRestController {
    @Autowired
    private EntitiesService service;

    @JsonView(User.Basic.class)
    @GetMapping("/")
    public ResponseEntity getAllUsers() {
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    interface User_Details extends User.Basic, User.Tournaments, Tournament.Basic {
    }
    @JsonView(User_Details.class)
    @GetMapping("/{dni}")
    public ResponseEntity<User> getElementById(@PathVariable String dni) {
        User op = service.getUserById(dni);
        if(op != null){
            return new ResponseEntity<>(op, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @JsonView(User_Details.class)
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User createOrganizer(@RequestBody User user){
        return service.createUser(user);
    }

    @JsonView(User_Details.class)
    @DeleteMapping("/{dni}")
    public ResponseEntity<User> removeElementById(@PathVariable String dni){
        try{
            User deleted_user = service.deleteUser(dni);
            return new ResponseEntity<>(deleted_user, HttpStatus.OK);
        }
        catch (EmptyResultDataAccessException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @JsonView(User_Details.class)
    @PutMapping("/{dni}")
    public ResponseEntity<User> updateElementById(@RequestBody User updatedUser, @PathVariable String dni){
        if(service.containsUser(dni)){
            updatedUser.setDNI(dni);
            service.editUser(updatedUser);
            return new ResponseEntity(updatedUser, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
