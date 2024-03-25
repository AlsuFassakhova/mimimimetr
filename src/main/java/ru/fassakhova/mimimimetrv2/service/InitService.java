package ru.fassakhova.mimimimetrv2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitService {
    private final CatService catService;
    private final VotePairService pairService;

    public void init() {
        if (catService.findAllCats().isEmpty()) {
            catService.initCats();
        }
        if (pairService.findAllPairs().isEmpty()) {
            pairService.generatePairs();
        }
    }
}
