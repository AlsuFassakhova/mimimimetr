package ru.fassakhova.mimimimetrv2.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fassakhova.mimimimetrv2.entity.Cat;
import ru.fassakhova.mimimimetrv2.service.CatService;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/cats")
public class CatController {

    private final CatService catService;

    @GetMapping("/top")
    public String getTopCats(Model model) {
        List<Cat> cats = catService.getTopCats();
        model.addAttribute("cats", cats);

        return "top";
    }
}
