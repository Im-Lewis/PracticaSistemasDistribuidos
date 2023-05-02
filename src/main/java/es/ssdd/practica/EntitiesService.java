package es.ssdd.practica;

import es.ssdd.practica.Tournament.Tournament;
import es.ssdd.practica.Tournament.TournamentsRepository;
import es.ssdd.practica.TournamentOrganizer.TournamentOrganizerRepository;
import es.ssdd.practica.User.User;
import es.ssdd.practica.TournamentOrganizer.TournamentOrganizer;
import es.ssdd.practica.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class EntitiesService {
    @Autowired
    private TournamentsRepository tournamentsRepository;
    @Autowired
    private TournamentOrganizerRepository organizerRepository;
    @Autowired
    private UserRepository userRepository;

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Functions for tournaments */
    public Collection<Tournament> getAllTournaments(){
        return tournamentsRepository.findAll();
    }
    public Optional<Tournament> getTournamentById(Long id){
        return tournamentsRepository.findById(id);
    }
    public boolean containsTournament(long id){
        return tournamentsRepository.existsById(id);
    }
    public Tournament createTournament(Tournament tournament){
        tournamentsRepository.save(tournament);
        return tournament;
    }
    public Tournament editTournament(Tournament tournament){
        tournamentsRepository.save(tournament);
        return tournament;
    }
    public Optional<Tournament> deleteTournament(Long id){
        Optional<Tournament> tournament = getTournamentById(id);
        tournamentsRepository.deleteById(id);
        return tournament;
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Functions for tournaments organizers */
    public Collection<TournamentOrganizer> getAllOrganizers(){
        return organizerRepository.findAll();
    }
    public Optional<TournamentOrganizer> getOrganizerById(Long id){
        return organizerRepository.findById(id);
    }
    public boolean containsOrganizer(long id){
        return organizerRepository.existsById(id);
    }
    public TournamentOrganizer createOrganizer(TournamentOrganizer organizer){
        organizerRepository.save(organizer);
        return organizer;
    }
    public TournamentOrganizer editOrganizer(TournamentOrganizer organizer){
        organizerRepository.save(organizer);
        return organizer;
    }
    public Optional<TournamentOrganizer> deleteOrganizer(Long id){
        Optional<TournamentOrganizer> organizer = getOrganizerById(id);
        organizerRepository.deleteById(id);
        return organizer;
    }


    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Functions for users */
    public Collection<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUserById(String dni){
        return userRepository.findById(dni);
    }
    public boolean containsUser(String dni){
        return userRepository.existsById(dni);
    }
    public User createUser (User user){
        userRepository.save(user);
        return user;
    }
    public User editUser(User user){
        userRepository.save(user);
        return user;
    }
    public Optional<User> deleteUser(String dni){
        Optional<User> user = getUserById(dni);
        userRepository.deleteById(dni);
        return user;
    }
}
