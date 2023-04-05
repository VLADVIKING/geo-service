package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalizationServiceImplTest {

    LocalizationService localizationService = new LocalizationServiceImpl();

    @Test
    void localeMessage() {

        String expect = "Welcome";
        String result = localizationService.locale(Country.BRAZIL);
        assertEquals(expect, result);
    }

}