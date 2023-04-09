package es.ssdd.practica;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TournamentsController {

    private List<Tournament> active_tournaments = new ArrayList<>();

/*--------------------------------------------------------------------------------------------------------------------*/
/* Default tournaments */
    public TournamentsController() {
        active_tournaments.add(new Tournament("Torneo-1", "10/10/23",
                "10:10", "Pinto", "Luis"));

        active_tournaments.add(new Tournament("Torneo-2", "11/10/23",
                "11:11", "Valdemoro", "Jaime"));
    }

/*--------------------------------------------------------------------------------------------------------------------*/
/* Controller functions */
    @PostMapping("/tournament/added")
    public String addedTournament(Model model, Tournament tournament) {
        active_tournaments.add(tournament);
        return "tournament_created_succesfully";
    }

    @GetMapping("/view/tournaments")
    public String viewTournaments(Model model) {
        model.addAttribute("tournaments", active_tournaments);
        return "active_tournaments";
    }

    @GetMapping("/tournament/{num}")
    public String viewTournament(Model model, @PathVariable int num) {
        Tournament tournament = active_tournaments.get(num-1);
        model.addAttribute("tournament", tournament);
        return "view_tournament";
    }
}
