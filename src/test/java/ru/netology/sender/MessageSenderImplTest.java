package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImplMock;
import ru.netology.i18n.LocalizationServiceImplMock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;
import java.util.HashMap;

class MessageSenderImplTest {

    GeoServiceImplMock geoService = Mockito.mock(GeoServiceImplMock.class);
    LocalizationServiceImplMock localizationService = Mockito.mock(LocalizationServiceImplMock.class);
    Map<String, String> headers = new HashMap<>();
    Location location;
    String expect;

    @Test
    void messageSentRussian() {
        Mockito.when(geoService.byIp("172.0.32.11")).thenReturn(location = new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn(expect = "Добро пожаловать");
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        String result = messageSender.send(headers);
        assertEquals(expect, result);
    }

    @Test
    void messageSentEnglish() {
        Mockito.when(geoService.byIp("96.44.183.149")).thenReturn(location = new Location("New York", Country.USA, " 10th Avenue", 32));
        Mockito.when(localizationService.locale(Country.USA)).thenReturn(expect = "Welcome");
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        String result = messageSender.send(headers);
        assertEquals(expect, result);
    }

}