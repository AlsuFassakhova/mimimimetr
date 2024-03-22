package ru.fassakhova.mimimimetrv2.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.fassakhova.mimimimetrv2.entity.User;
import ru.fassakhova.mimimimetrv2.service.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @PostMapping("/start")
    public  ModelAndView newUser(@ModelAttribute("user-name") String name, HttpSession session){

        User user = userService.createNewUser(name);
        session.setAttribute("user", user);

        System.out.println("юзер добавлен в сессию");
        return new ModelAndView("redirect:/pairs");
    }
}
