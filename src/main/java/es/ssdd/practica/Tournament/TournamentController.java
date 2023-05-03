package es.ssdd.practica.Tournament;

import es.ssdd.practica.EntitiesService;
import es.ssdd.practica.TournamentOrganizer.TournamentOrganizer;
import es.ssdd.practica.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class TournamentController {
    private Long temId;
    @Autowired
    private TournamentsRepository tournamentsRepository;

    @Autowired
    private EntitiesService service;

    @Autowired
    EntityManager entityManager;

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Controller functions */
    @GetMapping("/view/tournaments")
    public String viewTournaments(Model model) {
        model.addAttribute("tournaments", tournamentsRepository.findAll());
        return "tournaments_active";
    }

    @Transactional
    @PostMapping("/tournament/added")
    public String addedTournament(Model model, Tournament tournament) {
        long temId = service.getLastId();
        entityManager.createNativeQuery("INSERT INTO Tournament (id, name, date, hour, location, organizer_id) VALUES (?,?,?,?,?,?)")
                .setParameter(1, temId)
                .setParameter(2, tournament.getName())
                .setParameter(3, tournament.getDate())
                .setParameter(4, tournament.getHour())
                .setParameter(5, tournament.getLocation())
                .setParameter(6, null)
                .executeUpdate();
        //tournamentsRepository.save(tournament);
        return "tournament_created_succesfully";
    }

    @GetMapping("/tournament/{num}")
    public String viewTournament(Model model, @PathVariable Long num) {
        Tournament tournament = tournamentsRepository.findById(num).get();
        model.addAttribute("tournament", tournament);
        if (tournament.getOrganizer()!=null){
            return "tournament_view";
        }
        else{
            return "tournament_view_null_data";
        }

    }

    @GetMapping("/tournament/delete/{num}")
    public String deleteTournament(Model model, @PathVariable Long num) {
        Tournament tournament = tournamentsRepository.findById(num).get();
        tournamentsRepository.delete(tournament);
        return "tournament_deleted_succesfully";
    }

    @GetMapping("/tournament/edit/{num}")
    public String editTournament_id(@PathVariable Long num) {
        temId = num;
        return "/tournament/edited";
    }

    @GetMapping("/tournament/edited")
    public String editTournament_tournament(Tournament tournament){
        return "tournament_edit";
    }

    @PostMapping("/tournament/edited/update")
    public String editTournament_edit(Model model, Tournament tournament){
        Tournament tournament2 = tournamentsRepository.findById(temId).get();
        tournament2.setId(temId);
        tournament2.setName(tournament.getName());
        tournament2.setDate(tournament.getDate());
        tournament2.setHour(tournament.getHour());
        tournament2.setLocation(tournament.getLocation());
        tournamentsRepository.delete(tournament);
        tournamentsRepository.save(tournament2);
        return "tournament_edited_succesfully";
    }

    @GetMapping("/tournament/edit/{id_tour}/organizer/{id_org}/set_organizer")
    public String setOrganizer(Model model, @PathVariable Long id_tour, @PathVariable Long id_org){
        Tournament tournament = tournamentsRepository.findById(id_tour).get();
        TournamentOrganizer organizer = service.getOrganizerById(id_org);
        tournament.setOrganizer(organizer);
        tournamentsRepository.save(tournament);
        return "organizer_added_to_tournament";
    }

    @GetMapping("/tournament/edit/{id_tour}/user/{dni}/set_user")
    public String setUser(Model model, @PathVariable Long id_tour, @PathVariable String dni){
        Tournament tournament = tournamentsRepository.findById(id_tour).get();
        User user = service.getUserById(dni);
        tournament.getParticipants().add(user);
        tournamentsRepository.save(tournament);
        return "user_added_to_tournament";
    }
}

