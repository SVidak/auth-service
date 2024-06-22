package com.nwp.pmf.controllers;

import com.nwp.pmf.dto.CarDTO;
import com.nwp.pmf.services.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/car")
    public ResponseEntity<?> addCar(@ModelAttribute CarDTO carDTO) throws IOException {
        boolean success = customerService.createCar(carDTO);
        if(success) return ResponseEntity.status(HttpStatus.CREATED).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.ok(customerService.getAllCars());
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCarById(id));
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<List<CarDTO>> getCarsById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findAllByUserId(id));
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        customerService.deleteCar(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<?> updateCar(@PathVariable Long id, @ModelAttribute CarDTO carDTO) throws IOException {
        boolean success = customerService.updateCar(id, carDTO);
        if(success) return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchCarByName(@PathVariable String name) {
        return ResponseEntity.ok(customerService.searchCarsByName(name));
    }
}
