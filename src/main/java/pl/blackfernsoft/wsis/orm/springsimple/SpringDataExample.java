package pl.blackfernsoft.wsis.orm.springsimple;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.blackfernsoft.wsis.orm.springsimple.domain.vehicle.Car;
import pl.blackfernsoft.wsis.orm.springsimple.domain.vehicle.CarRepository;

import java.util.List;

@Slf4j
@AllArgsConstructor
@SpringBootApplication
public class SpringDataExample implements CommandLineRunner {

    private final CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataExample.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Car car = new Car();
        car.setName("Fiat");
        car.setPlates("DW1234");

        carRepository.save(car);
        log.info("Car in DB {}", car);

        List<Car> carList = carRepository.findAll();
        log.info("All cars {}", carList);
    }
}
