package ru.fassakhova.mimimimetrv2.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fassakhova.mimimimetrv2.entity.User;
import ru.fassakhova.mimimimetrv2.entity.VotePair;
import ru.fassakhova.mimimimetrv2.entity.dto.UserDTO;
import ru.fassakhova.mimimimetrv2.service.UserService;
import ru.fassakhova.mimimimetrv2.service.VotePairService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final VotePairService votePairService;

    @PostMapping("/start")
    public String newUser(@ModelAttribute UserDTO userDTO, HttpSession session) {

        User user = userService.createNewUser(userDTO);

        if (user == null) {
            return "redirect:/cats/top";
        }

        List<VotePair> pairs = votePairService.shufflePairs();

        session.setAttribute("user", user);
        session.setAttribute("pairs", pairs);

        return "redirect:/voting";
    }
}
