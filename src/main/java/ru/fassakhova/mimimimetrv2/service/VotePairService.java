package ru.fassakhova.mimimimetrv2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fassakhova.mimimimetrv2.entity.Cat;
import ru.fassakhova.mimimimetrv2.entity.User;
import ru.fassakhova.mimimimetrv2.entity.VotePair;
import ru.fassakhova.mimimimetrv2.repository.VotePairRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class VotePairService {

    private final CatService catService;
    private final UserService userService;
    private final VotePairRepository pairRepository;

    public List<VotePair> findAllPairs() {
        return pairRepository.findAll();
    }

    @Transactional
    public List<VotePair> generatePairs(User user) {
        List<VotePair> pairs = new ArrayList<>();

        List<Cat> cats = catService.findAllCats();
        for (int i = 0; i < cats.size(); i++) {
            for (int j = i + 1; j < cats.size(); j++) {
                VotePair pair = new VotePair();
                pair.setFirstCat(cats.get(i));
                pair.setSecondCat(cats.get(j));
                pair.setUser(user);
                Collections.shuffle(pairs, new Random());
                pairRepository.save(pair);
                userService.save(user);
            }
        }
        return pairs;
    }
}
