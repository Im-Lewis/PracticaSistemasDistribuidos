package es.ssdd.practica.TournamentOrganizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TournamentOrganizerController {
    private Long temId;
    @Autowired
    private TournamentOrganizerRepository organizerRepository;

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Controller functions */
    @GetMapping("/view/organizers")
    public String viewOrganizers(Model model) {
        model.addAttribute("organizers", organizerRepository.findAll());
        return "active_organizers";
    }

    @PostMapping("/organizer/added")
    public String addedOrganizer(Model model, TournamentOrganizer organizer) {
        organizerRepository.save(organizer);
        return "organizer_created_succesfully";
    }

    @GetMapping("/organizer/{num}")
    public String viewOrganizer(Model model, @PathVariable Long num) {
        TournamentOrganizer organizer = organizerRepository.findById(num).get();
        model.addAttribute("organizer", organizer);
        return "view_organizer";
    }

    @GetMapping("/organizer/delete/{num}")
    public String deleteOrganizer(Model model, @PathVariable Long num) {
        TournamentOrganizer organizer = organizerRepository.findById(num).get();
        organizerRepository.delete(organizer);
        return "organizer_deleted_succesfully";
    }

    @GetMapping("organizer/edit/{num}")
    public String editTournamentOrganizer_id(@PathVariable Long num){
        temId = num;
        return "organizer/edited";
    }

    @GetMapping("organizer/edited")
    public String editOrganizer_organizer(TournamentOrganizer organizer){return "edit_organizer";}

    @PostMapping("organizer/edited/update")
    public String editOrganizer_edit(Model model, TournamentOrganizer organizer){
        TournamentOrganizer organizer2 = organizerRepository.findById(temId).get();
        organizer2.setId(temId);
        organizer2.setName(organizer.getName());
        //organizer2.setOrganized_tournament();  Poner el torneo que ha organizado a traves del path
        return "organizer_edited_succesfully";
    }
}

