package ru.fassakhova.mimimimetrv2.entity.dto;

import org.springframework.stereotype.Component;
import ru.fassakhova.mimimimetrv2.entity.Cat;
@Component
public class CatMapper {

   public CatDto entityToDto(Cat cat){
        CatDto dto = new CatDto();
        dto.setName(cat.getName());
        dto.setImageUrl(cat.getImageUrl());

        return dto;
    }
}
