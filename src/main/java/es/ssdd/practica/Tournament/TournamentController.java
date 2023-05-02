package es.ssdd.practica.Tournament;

import es.ssdd.practica.EntitiesService;
import es.ssdd.practica.TournamentOrganizer.TournamentOrganizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TournamentController {
    private Long temId;
    @Autowired
    private TournamentsRepository tournamentsRepository;

    @Autowired
    private EntitiesService service;

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Controller functions */
    @GetMapping("/view/tournaments")
    public String viewTournaments(Model model) {
        model.addAttribute("tournaments", tournamentsRepository.findAll());
        return "tournaments_active";
    }

    @PostMapping("/tournament/added")
    public String addedTournament(Model model, Tournament tournament) {
        tournamentsRepository.save(tournament);
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
}

