package modulo03.ProjetoLocadora.repositories;

import modulo03.ProjetoLocadora.models.Veiculos.Car;
import modulo03.ProjetoLocadora.models.Veiculos.Vehicle;

import java.math.BigDecimal;
import java.util.*;
import java.util.Collections;

public class VehicleRepository {

    private final List<Vehicle> vehicleRepository;
    private final List<Car> carRepository;

    public VehicleRepository() {
        this.vehicleRepository = new ArrayList<>();
        this.carRepository = new ArrayList<>();
    }

    public void saveVehicle(Vehicle vehicle) {
        this.vehicleRepository.add(vehicle);
        if (vehicle instanceof Car) {
            this.carRepository.add((Car) vehicle);
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicleRepository.remove(vehicle);
        if (vehicle instanceof Car) {
            this.carRepository.remove((Car) vehicle);
        }
    }

    public List<Car> listCarsInAlphabeticalOrder() {
        List<Car> cars = new ArrayList<>(carRepository);
        cars.sort(Comparator.comparing(Car::getName));
        return Collections.unmodifiableList(cars);
    }

    public Vehicle findVehicleByName(String name) {
        for (Vehicle vehicle : vehicleRepository) {
            if (vehicle.getName().equalsIgnoreCase(name)|| vehicle.getModel().equalsIgnoreCase(name)) {
                return vehicle;
            }
        }
        return null;
    }

    public Vehicle findVehicleByLicensePlate(String licensePlate) {
        for (Vehicle vehicle : vehicleRepository) {
            if (vehicle.getLicensePlate().equalsIgnoreCase(licensePlate)) {
                return vehicle;
            }
        }
        return null;
    }

    public boolean editVehicle(String name, String model, String licensePlate, BigDecimal rentalPrice, String size) {
        Vehicle vehicle = findVehicleByLicensePlate(licensePlate);
        vehicle.setName(name);
        vehicle.setModel(model);
        vehicle.setLicensePlate(licensePlate);
        vehicle.setRentalPricePerDay(rentalPrice);
        if (vehicle instanceof Car car) {
            car.setSize(size);
        }
        return true;

    }

    public boolean editVehicleAvailability(Vehicle vehicle, boolean isRented) {

        vehicle.setRented(isRented);
        return true;

    }
}