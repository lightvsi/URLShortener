package ru.lightvsi.urlshortener.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class GeneratorService {
    public String generate() {
        String generated = RandomStringUtils.randomAlphabetic(5,12);
        return generated;
    }
}
