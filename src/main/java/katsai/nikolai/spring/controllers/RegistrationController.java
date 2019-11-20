package katsai.nikolai.spring.controllers;


import javax.validation.Valid;

import katsai.nikolai.spring.dto.UserRegistrationDto;
import katsai.nikolai.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        UserRegistrationDto userDto = new UserRegistrationDto();
        model.addAttribute("userDto", userDto);
        return "user/registration";
    }

    @PostMapping("/registration")
    public String register(@Valid UserRegistrationDto userDto,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errorMsg", "Registration failed: passwords do not match or invalid email");
            return registrationPage(model);
        }
        userService.registerNewUserAccount(userDto);
        return "login";
    }
}
