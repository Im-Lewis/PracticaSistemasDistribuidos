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
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EntitiesService {
    @Autowired
    private TournamentsRepository tournamentsRepository;
    @Autowired
    private TournamentOrganizerRepository organizerRepository;
    @Autowired
    private UserRepository userRepository;

    private AtomicLong tournament_id = new AtomicLong(2);

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
        long tem = tournament_id.incrementAndGet();
        tournament.setId(tem);
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
    public TournamentOrganizer getOrganizerById(Long id){
        return organizerRepository.getById(id);
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
    public TournamentOrganizer deleteOrganizer(Long id){
        TournamentOrganizer organizer = getOrganizerById(id);
        organizerRepository.deleteById(id);
        return organizer;
    }


    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Functions for users */
    public Collection<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(String dni){
        return userRepository.getById(dni);
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
    public User deleteUser(String dni){
        User user = getUserById(dni);
        userRepository.deleteById(dni);
        return user;
    }

    public Long getLastId(){
        return tournament_id.incrementAndGet();
    }
}
