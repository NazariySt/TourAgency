package services.implementations;

import model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import repository.HotelRepository;
import services.HotelService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HotelServiceImpl implements HotelService {

    HotelRepository hotelRepository;

    @Autowired
    public void setHotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> getHotelsByCountry(String country) {
        return hotelRepository.findAll().stream().filter(hotel -> hotel.getCountry().equals(country))
                .sorted(Comparator.comparing(Hotel::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllCountries() {
        return hotelRepository.findAll().stream().map(Hotel::getCountry)
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    @Override
    public void addHotel(String hotelName, String hotelCountry) {
        hotelRepository.addHotel(hotelName, hotelCountry);
    }

    @Override
    public Hotel getHotelById(Integer hotelId) {
        return hotelRepository.findHotelById(hotelId);
    }
}
