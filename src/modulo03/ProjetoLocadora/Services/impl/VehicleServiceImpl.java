package modulo03.ProjetoLocadora.Services.impl;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Car;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Vehicle;
import modulo03.ProjetoLocadora.Repositories.VehicleRepository;
import modulo03.ProjetoLocadora.Services.Contracts.VehicleService;

import java.math.BigDecimal;
import java.util.List;

public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle findVehicleByName(String name) {
        return vehicleRepository.findVehicleByName(name);
    }

    @Override
    public Vehicle findVehicleByLicense(String licensePlate) {
        return vehicleRepository.findVehicleByLicensePlate(licensePlate);
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        String licensePlate = vehicle.getLicensePlate();
        if (findVehicleByLicense(licensePlate) == null) {
            vehicleRepository.saveVehicle(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeVehicle(String licensePlate) {
        Vehicle vehicle = findVehicleByLicense(licensePlate);
        if (vehicle != null) {
            vehicleRepository.removeVehicle(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public boolean editVehicle(String name, String model, String licensePlate, BigDecimal rentalPrice, String size) {
        if (findVehicleByLicense(licensePlate) != null) {
            return vehicleRepository.editVehicle(name, model, licensePlate, rentalPrice, size);
        }
        return false;
    }

    @Override
    public BigDecimal setDailyRentalPriceForCar(String size) {
        if (size.equalsIgnoreCase("small")) {
            return BigDecimal.valueOf(100);
        } else if (size.equalsIgnoreCase("medium")) {
            return BigDecimal.valueOf(150);
        } else if (size.equalsIgnoreCase("suv")) {
            return BigDecimal.valueOf(200);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public List<Car> listCarsInAlphabeticalOrder() {
        return vehicleRepository.listCarsInAlphabeticalOrder();
    }
}
