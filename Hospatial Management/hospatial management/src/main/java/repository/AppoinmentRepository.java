package repository;

import Model.Appoinment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppoinmentRepository extends JpaRepository<Appoinment, Long> {
}
