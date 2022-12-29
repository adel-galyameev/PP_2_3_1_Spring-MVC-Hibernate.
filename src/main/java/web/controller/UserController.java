package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(ModelMap model) {

        model.addAttribute("users", userService.listUsers());
        return "users";
    }
    @GetMapping("/users/new")
    public String addNewUser(Model model) {
        model.addAttribute("user",new User());

        return "user_info";

    }
    @PostMapping("/userAdd")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }
    @GetMapping("/users/{id}")
    public String getUser(Model model,@PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "updateUser";
    }

    @PatchMapping("/users/{id}")
    public String update (@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/users/{id}")
    public String delete (@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }


}
