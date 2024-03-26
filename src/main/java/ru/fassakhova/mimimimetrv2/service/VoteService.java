package ru.fassakhova.mimimimetrv2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fassakhova.mimimimetrv2.entity.Pair;
import ru.fassakhova.mimimimetrv2.entity.Vote;
import ru.fassakhova.mimimimetrv2.repository.VoteRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VoteService {
    private final VoteRepository voteRepository;

    @Transactional
    public void addNewVote(Pair pair, String nickName){
        Vote vote = new Vote();
        vote.setPair(pair);
        vote.setUserName(nickName);
        voteRepository.save(vote);
    }

    public List<Vote> getByUserName(String name){
        return voteRepository.findAllByUserName(name);
    }
}
