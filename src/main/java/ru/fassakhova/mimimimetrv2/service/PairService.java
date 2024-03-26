package ru.fassakhova.mimimimetrv2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fassakhova.mimimimetrv2.entity.Cat;
import ru.fassakhova.mimimimetrv2.entity.Pair;
import ru.fassakhova.mimimimetrv2.repository.VotePairRepository;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class PairService {

    private final CatService catService;
    private final VotePairRepository pairRepository;

    public List<Pair> findAllPairs() {
        List<Pair> pairs = pairRepository.findAll();
        Collections.shuffle(pairs, new Random());
        return pairs;
    }

    @Transactional
    public void generatePairs() {
        List<Cat> cats = catService.findAllCats();

        for (int i = 0; i < cats.size(); i++) {
            for (int j = i + 1; j < cats.size(); j++) {
                Pair pair = new Pair();
                pair.setFirstCat(cats.get(i));
                pair.setSecondCat(cats.get(j));
                pairRepository.save(pair);
            }
        }
    }
}
