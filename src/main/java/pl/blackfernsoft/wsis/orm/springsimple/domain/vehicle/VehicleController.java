package pl.blackfernsoft.wsis.orm.springsimple.domain.vehicle;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.blackfernsoft.wsis.orm.springsimple.domain.vehicle.exception.CarNotFoundException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class VehicleController {

    private final CarRepository carRepository;

    @GetMapping
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @GetMapping("{carId}")
    public Car findById(@PathVariable(name = "carId") Long carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Car not found", carId));
    }

    @PostMapping
    public Car create(@RequestBody @Valid Car car) {
        return carRepository.save(car);
    }

    @DeleteMapping
    public void delete(@RequestBody Car car) {
        carRepository.delete(car);
    }
}
