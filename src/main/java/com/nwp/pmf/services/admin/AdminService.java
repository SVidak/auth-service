package com.nwp.pmf.services.admin;

import com.nwp.pmf.dto.CarDTO;

import java.io.IOException;
import java.util.List;

public interface AdminService {

    List<CarDTO> getAllCars();

    CarDTO getCarById(Long id);

    void deleteCar(Long id);

    boolean updateCar(Long id, CarDTO carDTO) throws IOException;
}
