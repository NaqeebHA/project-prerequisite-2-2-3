package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String addUser(@ModelAttribute User user, Model model) {
        userService.addUser(user);
        model.addAttribute("userForm", new User());
        model.addAttribute("users", userService.getUserList());
        return "users";
    }


    @GetMapping("/edit")
    public String editUser(@RequestParam("id") @ModelAttribute Long id, Model model) {
        model.addAttribute("editUserForm", new User());
        model.addAttribute("id", id);
        model.addAttribute("users", userService.getUserList());
        return "edit";
    }

    @PostMapping("/edited")
    public String postEditUser(@ModelAttribute User newUser, @RequestParam("id") Long id, Model model) {
        userService.updateUserById(id, newUser.getFirstName(), newUser.getLastName(), newUser.getEmail());
        model.addAttribute("userForm", new User());
        model.addAttribute("users", userService.getUserList());
        return "users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id, Model model) {
        userService.deleteUserById(id);
        model.addAttribute("userForm", new User());
        model.addAttribute("users", userService.getUserList());
        return "users";
    }
}
