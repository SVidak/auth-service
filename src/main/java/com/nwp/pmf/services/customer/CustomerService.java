package com.nwp.pmf.services.customer;

import com.nwp.pmf.dto.CarDTO;

import java.io.IOException;
import java.util.List;

public interface CustomerService {

    boolean createCar(CarDTO carDTO) throws IOException;

    List<CarDTO> getAllCars();


    CarDTO getCarById(Long id);

    void deleteCar(Long id);

    boolean updateCar(Long id, CarDTO carDTO) throws IOException;

    List<CarDTO> findAllByUserId(Long id);

    List<CarDTO> searchCarsByName(String name);
}
