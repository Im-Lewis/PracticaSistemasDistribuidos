package es.ssdd.practica;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TournamentService {

    private Map<Long, Tournament> tournamentsHashMap = new ConcurrentHashMap<>();

    private AtomicLong id = new AtomicLong();

    public Collection<Tournament> getAll(){
        return tournamentsHashMap.values();
    }

/*--------------------------------------------------------------------------------------------------------------------*/
/* Default tournaments */
    Tournament Torneo1 = new Tournament("Torneo-1", "10/10/23",
            "10:10", "Pinto", "Luis");
    Tournament Torneo2 = new Tournament("Torneo-2", "11/10/23",
            "11:11", "Valdemoro", "Jaime");

    public TournamentService(){
        createTournament(Torneo1);
        createTournament(Torneo2);
    }

/*--------------------------------------------------------------------------------------------------------------------*/
/* Function to create a tournament */
    public Tournament createTournament(Tournament tournament){
        long tem = id.incrementAndGet();
        tournament.setId(tem);
        tournamentsHashMap.put(tem, tournament);
        return tournament;
    }

/*--------------------------------------------------------------------------------------------------------------------*/
/* Function to get a tournament by id */
    public Tournament getTournamentById(Long id){
        return tournamentsHashMap.get(id);
    }

/*--------------------------------------------------------------------------------------------------------------------*/
/* If the map contains a tournament or not */
    public boolean containsTournament(Long id){
        return tournamentsHashMap.containsKey(id);
    }

/*--------------------------------------------------------------------------------------------------------------------*/
/* Function to delete a tournament from the map */
    public Tournament deleteTournament(Long id){
        return tournamentsHashMap.remove(id);
    }


/*--------------------------------------------------------------------------------------------------------------------*/
/* Function to add an edited tournament again in the map */
    public Tournament editTournament(Long id, Tournament tournament){
        tournamentsHashMap.put(id, tournament);
        return tournament;
    }
}
