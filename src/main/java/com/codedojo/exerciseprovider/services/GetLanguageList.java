package com.codedojo.exerciseprovider.services;

import com.codedojo.exerciseprovider.model.language.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class GetLanguageList {
    JpaRepository<Language, Long> languageRepository;

    public GetLanguageList(JpaRepository<Language, Long> languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> getLanguages() {
        return languageRepository.findAll();
    }
}
