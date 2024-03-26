package ru.fassakhova.mimimimetrv2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fassakhova.mimimimetrv2.entity.Cat;
import ru.fassakhova.mimimimetrv2.entity.Pair;
import ru.fassakhova.mimimimetrv2.repository.PairRepository;
import ru.fassakhova.mimimimetrv2.repository.VoteRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PairService {

    private final CatService catService;
    private final PairRepository pairRepository;
    private final VoteRepository voteRepository;

    public List<Pair> findAllPairs() {
        return pairRepository.findAll();
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

    public List<Pair> findUnvotedPairsByUsername(String userName) {
        List<Pair> votedPairs = voteRepository.findPairsByUserName(userName);
        List<Pair> allPairs = findAllPairs();

        allPairs.removeAll(votedPairs);
        return allPairs;
    }
}
