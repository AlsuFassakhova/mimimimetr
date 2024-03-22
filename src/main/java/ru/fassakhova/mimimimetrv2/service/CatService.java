package ru.fassakhova.mimimimetrv2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fassakhova.mimimimetrv2.entity.Cat;
import ru.fassakhova.mimimimetrv2.repository.CatRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CatService {
    private final CatRepository catRepository;
    private final ImageService imageService;

    public List<Cat> findAllCats() {
        return catRepository.findAll();
    }

    public void initCats() {
        System.out.println("Старт инит котов");
        Integer count = imageService.getImageCount();
        for (int i = 1; i <= count; i++) {
            Cat cat = new Cat();
            cat.setVotes(0);
            String name = "cat" + i;
            cat.setName(name);
            cat.setImageUrl(imageService.getUrlByName(name));
            saveCat(cat);
            System.out.println("кот " + cat.getName() + "создан");
        }
    }

    public void increaseVotesValue(Long id) {
        Cat cat = catRepository.findById(id).orElseThrow();
        cat.setVotes(cat.getVotes() + 1);
        catRepository.save(cat);
    }

    public void saveCat(Cat cat) {
        catRepository.save(cat);
    }

    public List<Cat> getTopCats() {
        return catRepository.findTop10ByVotesDesc();
    }
}
