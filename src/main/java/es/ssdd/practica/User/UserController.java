package es.ssdd.practica.User;

import es.ssdd.practica.EntitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    EntitiesService entitiesService;

/*--------------------------------------------------------------------------------------------------------------------*/
/* Controller functions */
    @PostMapping("/user/added")
    public String addedUser(Model model, User user) {
        entitiesService.createUser(user);
        return "user_created_succesfully";
    }

    @GetMapping("/view/users")
    public String viewUsers(Model model) {
        model.addAttribute("users", entitiesService.getAllUsers());
        return "active_users";
    }

    @GetMapping("/user/{dni}")
    public String viewTournament(Model model, @PathVariable String dni) {
        User user = entitiesService.getUserById(dni);
        model.addAttribute("user", user);
        return "view_user";
    }
}
