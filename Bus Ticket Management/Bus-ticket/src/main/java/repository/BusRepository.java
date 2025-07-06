package repository;

import model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BusRepository extends JpaRepository<Bus,Long> {
    List<Bus> findByFromLocationAndToLocationAndTravelDate(String from, String to, LocalDate date);
}
