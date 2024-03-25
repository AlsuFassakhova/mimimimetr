package ru.fassakhova.mimimimetrv2.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.fassakhova.mimimimetrv2.entity.User;
import ru.fassakhova.mimimimetrv2.entity.VotePair;

import java.util.List;
import java.util.Objects;

@Controller
public class VotePairController {

    @GetMapping("/voting")
    public String chooseCat(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (Objects.isNull(user)) {
            return "welcome";
        }

        List<VotePair> pairs = (List<VotePair>) session.getAttribute("pairs");

        if (!pairs.isEmpty()) {

            System.out.println("все ок, достаем пары");
            for (VotePair pair : pairs) {
                model.addAttribute("firstCat", pair.getFirstCat());
                model.addAttribute("secondCat", pair.getSecondCat());

                pairs.remove(pair);
                return "voting";
            }
        }

        System.out.println("пары закончились");
        return "redirect:/cats/top";
    }

}
