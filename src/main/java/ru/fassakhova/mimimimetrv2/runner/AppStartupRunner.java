package ru.fassakhova.mimimimetrv2.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.fassakhova.mimimimetrv2.service.CatService;
import ru.fassakhova.mimimimetrv2.service.PairService;

@Component
@RequiredArgsConstructor
public class AppStartupRunner implements ApplicationRunner {

    private final CatService catService;
    private final PairService pairService;

    @Override
    public void run(ApplicationArguments args){
        if (catService.findAllCats().isEmpty()) {
            catService.initCats();
        }
        if (pairService.findAllPairs().isEmpty()) {
            pairService.generatePairs();
        }
    }
}