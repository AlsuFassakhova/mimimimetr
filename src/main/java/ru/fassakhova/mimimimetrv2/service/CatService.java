package ru.fassakhova.mimimimetrv2.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fassakhova.mimimimetrv2.config.ImageConfig;
import ru.fassakhova.mimimimetrv2.entity.Cat;
import ru.fassakhova.mimimimetrv2.entity.dto.CatDto;
import ru.fassakhova.mimimimetrv2.entity.dto.CatMapper;
import ru.fassakhova.mimimimetrv2.repository.CatRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CatService {
    private final CatRepository catRepository;
    private final ImageConfig imageService;
    private final CatMapper catMapper;

    public List<Cat> findAllCats() {
        return catRepository.findAll();
    }

    @Transactional
    public void initCats() {
        Map<String, String> imageFiles = imageService.getFilesMap();

        for (String name : imageFiles.keySet()) {
            Cat cat = new Cat();
            cat.setVotes(0);
            cat.setName(name);
            cat.setImageUrl("/" + imageFiles.get(name));

            saveCat(cat);
        }
    }

    @Transactional
    public void increaseVotesValue(Long catId) {
        if (catId != null) {
            Optional<Cat> catOptional = catRepository.findById(catId);
            if (catOptional.isPresent()) {
                catRepository.incrementVotes(catOptional.get().getCatId());
            } else {
                throw new EntityNotFoundException();
            }
        }
    }

    public void saveCat(Cat cat) {
        catRepository.save(cat);
    }

    public List<CatDto> getTopCats() {
        List<Cat> cats = catRepository.findTopTenByVotesDesc(PageRequest.of(0, 10));
        List<CatDto> catsDto = new ArrayList<>();

        for (Cat cat : cats) {
            catsDto.add(catMapper.entityToDto(cat));
        }
        return catsDto;
    }
}
