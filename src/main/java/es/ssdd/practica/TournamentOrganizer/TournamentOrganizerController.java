package es.ssdd.practica.TournamentOrganizer;

import es.ssdd.practica.EntitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TournamentOrganizerController {
    @Autowired
    EntitiesService entitiesService;

/*--------------------------------------------------------------------------------------------------------------------*/
/* Controller functions */
    @PostMapping("/organizer/added")
    public String addedOrganizer(Model model, TournamentOrganizer organizer) {
        entitiesService.createOrganizer(organizer);
        return "organizer_created_succesfully";
    }

    @GetMapping("/view/organizers")
    public String viewOrganizers(Model model) {
        model.addAttribute("organizers", entitiesService.getAllOrganizers());
        return "active_organizers";
    }

    @GetMapping("/organizer/{num}")
    public String viewOrganizer(Model model, @PathVariable Long num) {
        TournamentOrganizer organizer = entitiesService.getOrganizerById(num);
        model.addAttribute("organizer", organizer);
        return "view_organizer";
    }
}

