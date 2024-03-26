package ru.fassakhova.mimimimetrv2.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String userLogin(@ModelAttribute("name") String nickName,
                            HttpSession session) {
        session.setAttribute("name", nickName);
        return "redirect:/";
    }
}
