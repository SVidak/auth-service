package com.nwp.pmf.services.customer;

import com.nwp.pmf.dto.CarDTO;
import com.nwp.pmf.entities.Car;
import com.nwp.pmf.entities.User;
import com.nwp.pmf.repositories.CarRepository;
import com.nwp.pmf.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            car.setType(carDTO.getType());
            car.setTransmission(carDTO.getTransmission());
            car.setPrice(carDTO.getPrice());
            car.setDescription(carDTO.getDescription());
            car.setColor(carDTO.getColor());
            car.setYear(carDTO.getYear());
            car.setSold(false);
            car.setImage(carDTO.getImage().getBytes());
            car.setUser(optionalUser.get());
            carRepository.save(car);
            return true;
        }
        return false;
    }

    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCardDTO).collect(Collectors.toList());
    }

    @Override
    public CarDTO getCarById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        return optionalCar.map(Car::getCardDTO).orElse(null);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public boolean updateCar(Long id, CarDTO carDTO) throws IOException {
        Optional<Car> optionalCar = carRepository.findById(id);
        if(optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setName(carDTO.getName());
            car.setBrand(carDTO.getBrand());
            car.setPrice(carDTO.getPrice());
            car.setDescription(carDTO.getDescription());
            car.setColor(carDTO.getColor());
            car.setYear(carDTO.getYear());
            car.setColor(carDTO.getColor());
            if (carDTO.getImage() != null)
                car.setImage(carDTO.getImage().getBytes());
            carRepository.save(car);
            return true;
        }
        return false;
    }

    @Override
    public List<CarDTO> findAllByUserId(Long id) {
        return carRepository.findAllByUserId(id).stream().map(Car::getCardDTO).collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> searchCarsByName(String name) {
        return carRepository.findAllByNameContainingIgnoreCase(name).stream().map(Car::getCardDTO).collect(Collectors.toList());
    }
}
