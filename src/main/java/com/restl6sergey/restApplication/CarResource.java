package com.restl6sergey.restApplication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class CarResource {

    private final CarRepository carRepository;

    public CarResource(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public List<CarEntity> retrieveAllCars() {
        return carRepository.findAll();
    }
    @GetMapping("/cars/{id}")
    public CarEntity retrieveCar(@PathVariable int id) {
        Optional<CarEntity> student = carRepository.findById(id);

        if (!student.isPresent())
            throw new CarNotFoundException("id-" + id);
        return student.get();
    }
    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable int id) {
        carRepository.deleteById(id);
    }
    @PostMapping("/cars")
    public ResponseEntity<CarEntity> createCar(@RequestBody CarEntity car) {
        CarEntity savedCar = carRepository.save(car);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCar.getCarId()).toUri();

        return ResponseEntity.created(location).build();
    }
    @PutMapping("/cars/{id}")
    public ResponseEntity<CarEntity> updateCar(@RequestBody CarEntity car, @PathVariable int id) {

        Optional<CarEntity> carOptional = carRepository.findById(id);

        if (!carOptional.isPresent())
            return ResponseEntity.notFound().build();

        car.setCarId(id);

        carRepository.save(car);

        return ResponseEntity.noContent().build();
    }
}
