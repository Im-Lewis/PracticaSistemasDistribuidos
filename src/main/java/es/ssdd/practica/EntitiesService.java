package es.ssdd.practica;

import es.ssdd.practica.Tournament.Tournament;
import es.ssdd.practica.User.User;
import es.ssdd.practica.TournamentOrganizer.TournamentOrganizer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EntitiesService {
    private Map<Long, Tournament> tournamentsHashMap = new ConcurrentHashMap<>();
    private Map<Long, TournamentOrganizer> organizersHashMap = new ConcurrentHashMap<>();
    private Map<String, User> usersHashMap = new ConcurrentHashMap<>();

    private AtomicLong tournament_id = new AtomicLong();
    private AtomicLong organizer_id = new AtomicLong();

    /*
    @PostConstruct
    public void init() {

        Tournament tournament1 = new Tournament("Torneo-1", "20/04/23", "11:00", "Pinto");
        Tournament tournament2 = new Tournament("Torneo-2", "27/04/23", "12:00", "Valdemoro");
        Tournament tournament3 = new Tournament("Torneo-3", "5/05/23", "10:00", "Albacete");

        createTournament(tournament1);
        createTournament(tournament2);
        createTournament(tournament3);

        TournamentOrganizer organizer1 = new TournamentOrganizer("Luis");
        TournamentOrganizer organizer2 = new TournamentOrganizer("Jaime");
        TournamentOrganizer organizer3 = new TournamentOrganizer("Ataulfo");

        createOrganizer(organizer1);
        createOrganizer(organizer2);
        createOrganizer(organizer3);

        User user1 = new User("00000000L", "Jose", "Perez");
        User user2 = new User("11111111L", "Cristiano", "Ronaldo");
        User user3 = new User("22222222L", "Lionel", "Messi");
        User user4 = new User("33333333L", "Fernando", "Alonso");
        User user5 = new User("44444444L", "Carlos", "Sainz");
        User user6 = new User("55555555L", "Rafa", "Nadal");

        createUser(user1);
        createUser(user2);
        createUser(user3);
        createUser(user4);
        createUser(user5);
        createUser(user6);

        tournament1.setOrganizer(organizer1);
        tournament2.setOrganizer(organizer2);
        tournament3.setOrganizer(organizer3);

        tournament1.getParticipants_list().add(user1);
        tournament1.getParticipants_list().add(user2);
        tournament2.getParticipants_list().add(user3);
        tournament2.getParticipants_list().add(user4);
        tournament3.getParticipants_list().add(user3);
        tournament3.getParticipants_list().add(user4);
        tournament3.getParticipants_list().add(user5);
        tournament3.getParticipants_list().add(user6);

        user1.getParticipating_in().add(tournament1);
        user2.getParticipating_in().add(tournament1);
        user3.getParticipating_in().add(tournament2);
        user4.getParticipating_in().add(tournament2);
        user3.getParticipating_in().add(tournament3);
        user4.getParticipating_in().add(tournament3);
        user5.getParticipating_in().add(tournament3);
        user6.getParticipating_in().add(tournament3);

        organizer1.setOrganized_tournament(tournament1);
        organizer2.setOrganized_tournament(tournament2);
        organizer3.setOrganized_tournament(tournament3);
    }

     */

/*--------------------------------------------------------------------------------------------------------------------*/
/* Functions to create tournaments, organizers and  participants */
    public Tournament createTournament(Tournament tournament){
        long tem = tournament_id.incrementAndGet();
        tournament.setId(tem);
        tournamentsHashMap.put(tem, tournament);
        return tournament;
    }
    public TournamentOrganizer createOrganizer(TournamentOrganizer organizer){
        long tem = organizer_id.incrementAndGet();
        organizer.setId(tem);
        organizersHashMap.put(tem, organizer);
        return organizer;
    }
    public User createUser (User user){
        String tem = user.getDNI();
        usersHashMap.put(tem, user);
        return user;
    }

/*--------------------------------------------------------------------------------------------------------------------*/
/* Functions to get all instances of the entities */
    public Collection<Tournament> getAllTournaments(){
    return tournamentsHashMap.values();
}
    public Collection<TournamentOrganizer> getAllOrganizers(){
        return organizersHashMap.values();
    }
    public Collection<User> getAllUsers(){
        return usersHashMap.values();
    }

/*--------------------------------------------------------------------------------------------------------------------*/
/* Functions to get an instance of the entities by id */
    public Tournament getTournamentById(Long id){ return tournamentsHashMap.get(id); }
    public TournamentOrganizer getOrganizerById(Long id){ return organizersHashMap.get(id); }
    public User getUserById(String DNI){ return usersHashMap.get(DNI); }

/*--------------------------------------------------------------------------------------------------------------------*/
/* If the maps contains an instance */
    public boolean containsTournament(Long id){ return tournamentsHashMap.containsKey(id); }
    public boolean containsOrganizer(Long id){ return organizersHashMap.containsKey(id); }
    public boolean containsUser(String DNI){ return usersHashMap.containsKey(DNI); }

/*--------------------------------------------------------------------------------------------------------------------*/
    /* Functions to delete instances of the entities */
    public Tournament deleteTournament(Long id){ return tournamentsHashMap.remove(id); }
    public TournamentOrganizer deleteOrganizer(Long id){ return organizersHashMap.remove(id); }
    public User deleteUser(String DNI){ return usersHashMap.remove(DNI); }

/*--------------------------------------------------------------------------------------------------------------------*/
/* Functions to edit instances of the entities */
    public Tournament editTournament(Long id, Tournament tournament){
        tournamentsHashMap.put(id, tournament);
        return tournament;
    }
    public TournamentOrganizer editOrganizer(Long id, TournamentOrganizer organizer){
        organizersHashMap.put(id, organizer);
        return organizer;
    }
    public User editUser(String DNI, User user){
        usersHashMap.put(DNI, user);
        return user;
    }

}
