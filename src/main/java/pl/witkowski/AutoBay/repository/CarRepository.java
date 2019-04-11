package pl.witkowski.AutoBay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.witkowski.AutoBay.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

    Car findCarById(Long id);
}
