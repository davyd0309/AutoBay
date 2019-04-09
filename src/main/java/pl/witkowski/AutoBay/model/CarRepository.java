package pl.witkowski.AutoBay.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

    Car findCarById(Long id);
}
