package ru.fassakhova.mimimimetrv2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fassakhova.mimimimetrv2.service.CatService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/welcome")
public class HelloController {
    private final CatService catService;

    @GetMapping
    public String welcome() {
        catService.initCats();

        return "welcome";
    }
}