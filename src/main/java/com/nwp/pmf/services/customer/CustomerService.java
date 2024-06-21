package com.nwp.pmf.services.customer;

import com.nwp.pmf.dto.CarDTO;

import java.io.IOException;

public interface CustomerService {

    boolean createCar(CarDTO carDTO) throws IOException;
}
