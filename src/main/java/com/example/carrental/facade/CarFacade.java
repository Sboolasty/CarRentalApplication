package com.example.carrental.facade;


import com.example.carrental.domain.*;
import com.example.carrental.mapper.CarMapper;
import com.example.carrental.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarFacade {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public List<CarDto> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return carMapper.mapToCarDtoList(cars);
    }

    public CarDto getCarDto(final long carId) {
        Car car = carRepository.findById(carId);
        return carMapper.mapToCarDto(car);
    }

    public Car getCar(final long id) {
        return carRepository.findById(id);
    }

    public Long saveCar(final CarDto carDto) {
        Car car = carMapper.mapToCar(carDto);
        carRepository.save(car);
        return car.getId();
    }

    public void deleteCar(final long id) {
        carRepository.deleteById(id);
    }

    public Long updateCarStatus(final long carId, String status) {
        Car car = carRepository.findById(carId);
        car.setStatus(status);

        Car newStatusCar = carRepository.save(car);
        carMapper.mapToCarDto(newStatusCar);
        return newStatusCar.getId();
    }

}