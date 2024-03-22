package ru.fassakhova.mimimimetrv2.service;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Setter
@Getter
@Service
public class ImageService {
    @Value("${spring.image-source}")
    private String imageSource;
    @Value(("${spring.image-count}"))
    private Integer imageCount;

    private Map<String, String> getFilesMap() {
        File resourcesDir = new File(imageSource);
        File[] files = resourcesDir.listFiles();

        assert files != null;

        return Arrays.stream(files)
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(
                        File::getName,
                        File::getPath
                ));
    }

    public String getUrlByName(String name){
        Map<String, String> filesMap = getFilesMap();
        return filesMap.get(name+".jpg");
    }
}

