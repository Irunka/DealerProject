package service;

import entity.Car;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CarDealer {
    private String name;
    private final Set<Car> cars = new HashSet<>();


    public CarDealer(String name) {
        this.name = name;

    }

    public boolean addCar(Car car) {

        return cars.add(car);
    }

    public Set<Car> getCars() {

        return cars;
    }


    public Set<Car> getAllByMake(String make) {
        Set<Car> carNew = new HashSet<>();
        for (Car car : this.cars) {

            if (make.equals(car.getMake()))
                carNew.add(car);
        }

        return carNew;
    }

    public Set<Car> getAllByMake(String make, int limit) {
        int k = 1;
        Set<Car> carNew = new HashSet<>();
        for (Car car : this.cars) {
            if (make.equals(car.getMake()) && k <= limit) {
                carNew.add(car);
                k++;
            }
        }

        return carNew;
    }

    public boolean remove(Car car) {

        return cars.remove(car);
    }

    public boolean removeAllByMake(String make) {
        boolean carsWithSelectedMakeExists = false;
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car c = iterator.next();
            if (make.equals(c.getMake())) {
                iterator.remove();
                carsWithSelectedMakeExists = true;
            }
        }
        return carsWithSelectedMakeExists;
    }


    public Set<Car> getAllByVolume(double from, double to) {
        Set<Car> carNew = new HashSet<>();
        for (Car car : this.cars) {
            if (car.getVolume() >= from && car.getVolume() <= to) {
                carNew.add(car);
            }
        }
        return  carNew;
    }

    public Set<Car> getAllByPrice(int from, int to) {
        Set<Car> carNew = new HashSet<>();
        for (Car car : this.cars) {
            if (car.getPrice() >= from && car.getPrice() <= to) {
                carNew.add(car);
            }
        }
        return  carNew;

    }

    public Set<Car> getAllByYear(int from, int to) {
        Set<Car> carNew = new HashSet<>();
        for (Car car : this.cars) {
            if (car.getYear() >= from && car.getYear() <= to) {
                carNew.add(car);
            }
        }
        return  carNew;
    }

    public Set<Car> update(Car oldValue, Car newValue) {
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car c = iterator.next();
            if (c.equals(oldValue)) {
                cars.remove(c);
                cars.add(newValue);
            }
        }
        return  cars.isEmpty()? null:cars;
    }
}
