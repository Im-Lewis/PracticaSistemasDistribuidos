package es.ssdd.practica.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private String temDNI;
    @Autowired
    private UserRepository userRepository ;

    /*--------------------------------------------------------------------------------------------------------------------*/
    /* Controller functions */
    @GetMapping("/view/users")
    public String viewUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "active_users";
    }

    @PostMapping("/user/added")
    public String addedUser(Model model, User user) {
        userRepository.save(user);
        return "user_created_succesfully";
    }

    @GetMapping("/user/{dni}")
    public String viewUser(Model model, @PathVariable String dni) {
        User user = userRepository.findById(dni).get();
        model.addAttribute("user", user);
        return "view_user";
    }

    @GetMapping("/user/delete/{dni}")
    public String deleteUser(Model model, @PathVariable String dni){
        User user = userRepository.findById(dni).get();
        userRepository.delete(user);
        return "user_deleted_succesfully";
    }

    @GetMapping("user/edit/{dni}")
    public String editUser_id(@PathVariable String dni){
        temDNI = dni;
        return "user/edited";
    }

    @GetMapping("/user/edited")
    public String editUser_user(User user){ return "edit_user"; }

    @PostMapping("user/edited/update")
    public String editUser_edit(Model model, User user){
        User user2 = userRepository.findById(temDNI).get();
        user2.setDNI(temDNI);
        user2.setName(user.getName());
        user2.setLastName(user.getLastName());
        return "user_edited_succesfully";
    }
}
