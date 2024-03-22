package ru.fassakhova.mimimimetrv2.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.fassakhova.mimimimetrv2.entity.User;
import ru.fassakhova.mimimimetrv2.entity.VotePair;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Controller
@RequestMapping

public class VotePairController {

    @PostMapping("/pairs")
    public ModelAndView chooseCat(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if (Objects.isNull(user)) {
            System.out.println("юзер нал");
            return new ModelAndView("welcome");
        }
        List<VotePair> pairs = user.getPairs();

        if(pairs.isEmpty()) {
            System.out.println("пары закончились");
            return new ModelAndView("redirect:/cats/top");
        }
        System.out.println("все ок, достаем пары");
        VotePair pair = pairs.get(0);
        model.addAttribute("firstCat", pair.getFirstCat());
        model.addAttribute("secondCat", pair.getSecondCat());
        pairs.remove(pair);
        System.out.println("идем голосовать");
        return new ModelAndView("vote");
    }

}
