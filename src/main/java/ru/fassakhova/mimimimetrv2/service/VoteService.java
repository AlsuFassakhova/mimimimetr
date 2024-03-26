package ru.fassakhova.mimimimetrv2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fassakhova.mimimimetrv2.entity.Pair;
import ru.fassakhova.mimimimetrv2.entity.Vote;
import ru.fassakhova.mimimimetrv2.repository.PairRepository;
import ru.fassakhova.mimimimetrv2.repository.VoteRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VoteService {
    private final VoteRepository voteRepository;
    private final PairRepository pairRepository;

    @Transactional
    public void addNewVote(Long pairId, String nickName) {
        Optional<Pair> pair = pairRepository.findById(pairId);
        if(pair.isPresent()) {
            Vote vote = new Vote();
            vote.setPair(pair.get());
            vote.setUserName(nickName);
            voteRepository.save(vote);
        }
    }
}
