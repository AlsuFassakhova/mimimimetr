package ru.fassakhova.mimimimetrv2.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Configuration
public class ImageConfig {
    @Value("${spring.image-source}")
    private String imageSource;

    public Map<String, String> getFilesMap() {
        File resourcesDir = new File(imageSource);
        File[] files = resourcesDir.listFiles();

        assert files != null;

        return Arrays.stream(files)
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(
                        file -> file.getName().replace(".jpg", ""),
                        file -> file.getPath().replace("\\", "/")
                                .substring(file.getPath().indexOf("photos"))
                ));
    }
}

