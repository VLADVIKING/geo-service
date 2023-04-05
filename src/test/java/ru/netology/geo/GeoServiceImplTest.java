package ru.netology.geo;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GeoServiceImplTest {

    GeoServiceImpl geoService = new GeoServiceImpl();

    @Test
    void locationByIp() {

        Location expect = new Location("New York", Country.USA, null, 0);
        Location result = geoService.byIp("96.0.0.1");
        assertEquals(expect.getCountry(), result.getCountry());
        assertEquals(expect.getCity(), result.getCity());
        assertEquals(expect.getStreet(), result.getStreet());
        assertEquals(expect.getBuiling(), result.getBuiling());
    }

}