
package ru.fassakhova.mimimimetrv2.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fassakhova.mimimimetrv2.entity.Pair;
import ru.fassakhova.mimimimetrv2.service.CatService;
import ru.fassakhova.mimimimetrv2.service.PairService;
import ru.fassakhova.mimimimetrv2.service.VoteService;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@Controller
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;
    private final CatService catService;
    private final PairService pairService;

    @GetMapping("/")
    public String voting(HttpSession session, Model model) {
        String userName = (String) session.getAttribute("name");
        if (Objects.isNull(userName)) {
            return "welcome";
        }

        List<Pair> pairs = pairService.findUnvotedPairsByUsername(userName);

        if (pairs.isEmpty()) {
            model.addAttribute("cats", catService.getTopCats());
            return "top";
        }

        Pair pair = pairs.get(new Random().nextInt(pairs.size()));
        model.addAttribute("pair", pair);
        return "voting";
    }

    @PostMapping("/")
    public String catVoting(@ModelAttribute("catId") Long catId,
                            @ModelAttribute("pairId") Long pairId,
                            HttpSession session) {

        String user = (String) session.getAttribute("name");
        if (Objects.isNull(user)) {
            return "welcome";
        }

        catService.increaseVotesValue(catId);
        voteService.addNewVote(pairId, user);

        return "redirect:/";
    }
}