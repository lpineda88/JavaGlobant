package com.hermes.msg.controller;

import com.hermes.msg.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hermes.msg.controller.dto.UsersRegisterDTO;

@Controller
@RequestMapping("/register")
public class RegisterUsersController {

    @Autowired
    private UsersService usersService;

    @ModelAttribute("users")
    public UsersRegisterDTO returnNewUserRegisterDTO() {
        return new UsersRegisterDTO();
    }

    @GetMapping
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("users") UsersRegisterDTO registerDTO) {
        usersService.save(registerDTO);
        return "redirect:/register?success";
    }
}
