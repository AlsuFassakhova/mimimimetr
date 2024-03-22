package ru.fassakhova.mimimimetrv2.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatDto {
    private Long id;
    private String imageUrl;
    private int votes;
}
