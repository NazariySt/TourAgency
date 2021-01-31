package repository;

import model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepo extends JpaRepository<Room , Integer> {

   // @Query("select h. from Hotel h where h.name=?1")
   // List<Room> findRoomByHotel()

}
