package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute("users", userService.getUserList());
        return "users";
    }

    @PostMapping("/add")
    public String registerUser(@ModelAttribute User user, Model model) {
        userService.addUser(user);
        System.out.println("Added User: " + user.toString());
        model.addAttribute("userForm", new User());
        model.addAttribute("users", userService.getUserList());
        return "users";
    }
}
