package ru.fassakhova.mimimimetrv2.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fassakhova.mimimimetrv2.entity.dto.CatDto;
import ru.fassakhova.mimimimetrv2.service.CatService;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/cats")
public class CatController {

    private final CatService catService;

    @GetMapping("/top")
    public String getTopCats(Model model) {

        List<CatDto> cats = catService.getTopCats();
        model.addAttribute("cats", cats);

        return "top";
    }

    @PostMapping("/change-votes")
    public String addVote(@RequestParam Long catId) {
        catService.increaseVotesValue(catId);
        return "redirect:/voting";
    }
}
