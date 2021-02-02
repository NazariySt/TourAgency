package repository;

import model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel , Integer> {
    @Override
    Optional<Hotel> findById(Integer integer);

    @Override
    List<Hotel> findAll();

    void addHotel(String hotelName, String hotelCountry);

    Hotel findHotelById(Integer id);


}
