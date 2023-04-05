package ru.netology.geo;

import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceImplMock implements GeoService {


    @Override
    public Location byIp(String ip) {
        return new Location("Moscow", Country.RUSSIA, null, 0);
    }


    @Override
    public Location byCoordinates(double latitude, double longitude) {
        return null;
    }
}
