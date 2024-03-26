package ru.fassakhova.mimimimetrv2.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.fassakhova.mimimimetrv2.entity.Pair;
import ru.fassakhova.mimimimetrv2.entity.Vote;
import ru.fassakhova.mimimimetrv2.entity.dto.CatDto;
import ru.fassakhova.mimimimetrv2.service.CatService;
import ru.fassakhova.mimimimetrv2.service.PairService;
import ru.fassakhova.mimimimetrv2.service.VoteService;

import java.util.List;
import java.util.Random;

@Controller
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;
    private final CatService catService;
    private final PairService pairService;

    @PostMapping("/voting")
    public String catVoting(@ModelAttribute("name") String nickName,
                            @ModelAttribute("catId") Long catId,
                            Model model, HttpSession session) {
        session.setAttribute("name", nickName);

        String user = (String) session.getAttribute("name");
        catService.increaseVotesValue(catId);

        List<Vote> votes = voteService.getByUserName(user);
        List<Pair> pairs = pairService.findAllPairs();

        if (votes.isEmpty()) {
            Pair pair = pairs.get(new Random().nextInt(0, pairs.size() - 1));
            voting(model, pair, user);
            return "voting";
        }

        for (Pair pair : pairs) {
            for (Vote vote : votes) {
                if (!vote.getPair().equals(pair)) {
                    voting(model, pair, nickName);
                    return "voting";
                }
            }
        }
        List<CatDto> cats = catService.getTopCats();
        model.addAttribute("cats", cats);

        return "top";
    }

    private void voting(Model model, Pair pair, String user) {
        voteService.addNewVote(pair, user);
        model.addAttribute("firstCat", pair.getFirstCat());
        model.addAttribute("secondCat", pair.getSecondCat());
    }
}
