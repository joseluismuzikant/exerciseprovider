package com.codedojo.exerciseprovider;


import com.codedojo.exerciseprovider.infrastructure.LanguageRepository;
import com.codedojo.exerciseprovider.model.language.Language;
import com.codedojo.exerciseprovider.services.GetLanguageList;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = ExerciseproviderApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
public class GetLanguageListTest {
    List<Language> expectedLanguages;
    List<Language> servedLanguages;
    GetLanguageList getLanguageList;

    @Autowired
    LanguageRepository languageRepository;

    @Before
    public void setUp() {
        expectedLanguages = new ArrayList<Language>();
        expectedLanguages.add(Language.builder().code("SQL").description("Db query languague").build());
        expectedLanguages.add(Language.builder().code("Python").description("Data Science Language").build());
        expectedLanguages.add(Language.builder().code("Java").description("Backend language").build());
        expectedLanguages.forEach(l -> languageRepository.save(l));
        getLanguageList = new GetLanguageList(languageRepository);

    }

    @Test
    public void when_the_user_enter_the_application_receives_a_list_of_languages() {
        when_we_get_a_language_list();
        then_the_list_has(expectedLanguages);

    }


    private void when_we_get_a_language_list() {
        servedLanguages = getLanguageList.getLanguages();
    }

    private void then_the_list_has(List<Language> expectedLanguages) {
        Assertions.assertTrue(expectedLanguages.equals(servedLanguages));
    }


}
