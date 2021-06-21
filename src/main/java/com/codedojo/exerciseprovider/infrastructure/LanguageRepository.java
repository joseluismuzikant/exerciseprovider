package com.codedojo.exerciseprovider.infrastructure;

import com.codedojo.exerciseprovider.model.language.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

}
