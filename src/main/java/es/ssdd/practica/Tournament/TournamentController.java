package es.ssdd.practica.Tournament;

import es.ssdd.practica.EntitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TournamentController {
    @Autowired
    EntitiesService entitiesService;

/*--------------------------------------------------------------------------------------------------------------------*/
/* Controller functions */
    @PostMapping("/tournament/added")
    public String addedTournament(Model model, Tournament tournament) {
        entitiesService.createTournament(tournament);
        return "tournament_created_succesfully";
    }

    @GetMapping("/view/tournaments")
    public String viewTournaments(Model model) {
        model.addAttribute("tournaments", entitiesService.getAllTournaments());
        return "active_tournaments";
    }

    @GetMapping("/tournament/{num}")
    public String viewTournament(Model model, @PathVariable Long num) {
        Tournament tournament = entitiesService.getTournamentById(num);
        model.addAttribute("tournament", tournament);
        return "view_tournament";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTournament(Model model, @PathVariable Long id){
        Tournament tournament = entitiesService.deleteTournament(id);
        return "tournament_deleted_succesfully";
    }
}
