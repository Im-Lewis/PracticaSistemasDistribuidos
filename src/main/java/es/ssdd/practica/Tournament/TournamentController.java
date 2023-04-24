package es.ssdd.practica.Tournament;

import es.ssdd.practica.TournamentsRepository;
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

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Controller functions */

    @PostMapping("/tournament/added")
    public String addedTournament(Model model, Tournament tournament) {
        tournamentsRepository.save(tournament);
        return "tournament_created_succesfully";
    }

    @GetMapping("/view/tournaments")
    public String viewTournaments(Model model) {
        model.addAttribute("tournaments", tournamentsRepository.findAll());
        return "active_tournaments";
    }

    @GetMapping("/tournament/{num}")
    public String viewTournament(Model model, @PathVariable Long num) {
        Tournament tournament = tournamentsRepository.findById(num).get();
        model.addAttribute("tournament", tournament);
        return "view_tournament";
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
        return "edit_tournament";
    }

    @PostMapping("/tournament/edited/update")
    public String editTournament_edit(Model model, Tournament tournament){
        Tournament tournament2 = tournamentsRepository.findById(temId).get();
        tournament2.setId(temId);
        tournament2.setName(tournament.getName());
        tournament2.setDate(tournament.getDate());
        tournament2.setHour(tournament.getHour());
        tournament2.setLocation(tournament.getLocation());
        tournament2.setOrganizer(tournament.getOrganizer());
        tournamentsRepository.delete(tournament);
        tournamentsRepository.save(tournament2);
        return "tournament_edited_succesfully";
    }
}

