package com.nwp.pmf.services.customer;

import com.nwp.pmf.dto.CarDTO;
import com.nwp.pmf.entities.Car;
import com.nwp.pmf.entities.User;
import com.nwp.pmf.repositories.CarRepository;
import com.nwp.pmf.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final UserRepository userRepository;

    private final CarRepository carRepository;

    @Override
    public boolean createCar(CarDTO carDTO) throws IOException {
        Optional<User> optionalUser = userRepository.findById(carDTO.getUserId());
        if(optionalUser.isPresent()) {
            Car car = new Car();
            car.setName(carDTO.getName());
            car.setBrand(carDTO.getBrand());
            car.setPrice(carDTO.getPrice());
            car.setDescription(carDTO.getDescription());
            car.setColor(carDTO.getColor());
            car.setColor(carDTO.getColor());
            car.setSold(false);
            car.setYear(carDTO.getYear());
            car.setImage(carDTO.getImage().getBytes());
            car.setUser(optionalUser.get());
            carRepository.save(car);
            return true;
        }
        return false;
    }
}
