package ru.netology.i18n;

import ru.netology.entity.Country;

public class LocalizationServiceImplMock implements LocalizationService {

    private String value;
    @Override
    public String locale(Country country) {
        return "Добро пожаловать";
    }


}
