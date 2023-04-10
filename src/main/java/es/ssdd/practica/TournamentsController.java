package es.ssdd.practica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TournamentsController {

    @Autowired
    TournamentService tournamentService;

/*--------------------------------------------------------------------------------------------------------------------*/
/* Controller functions */

    @PostMapping("/tournament/added")
    public String addedTournament(Model model, Tournament tournament) {
        tournamentService.createTournament(tournament);
        return "tournament_created_succesfully";
    }

    @GetMapping("/view/tournaments")
    public String viewTournaments(Model model) {
        model.addAttribute("tournaments", tournamentService.getAll());
        return "active_tournaments";
    }

    @GetMapping("/tournament/{num}")
    public String viewTournament(Model model, @PathVariable Long num) {
        Tournament tournament = tournamentService.getTournamentById(num);
        model.addAttribute("tournament", tournament);
        return "view_tournament";
    }
}
