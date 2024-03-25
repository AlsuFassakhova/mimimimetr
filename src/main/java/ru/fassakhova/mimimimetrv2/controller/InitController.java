package ru.fassakhova.mimimimetrv2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fassakhova.mimimimetrv2.service.InitService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/welcome")
public class InitController {
    private final InitService initService;

    @GetMapping
    public String welcome() {
        initService.init();
        return "welcome";
    }
}