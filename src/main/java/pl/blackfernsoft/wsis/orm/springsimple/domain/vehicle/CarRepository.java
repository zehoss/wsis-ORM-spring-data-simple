package pl.blackfernsoft.wsis.orm.springsimple.domain.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
