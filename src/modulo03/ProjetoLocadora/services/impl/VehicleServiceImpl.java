package modulo03.ProjetoLocadora.services.impl;
import modulo03.ProjetoLocadora.models.Veiculos.Car;
import modulo03.ProjetoLocadora.models.Veiculos.Vehicle;
import modulo03.ProjetoLocadora.repositories.VehicleRepository;
import modulo03.ProjetoLocadora.services.Contracts.CrudService;

import java.math.BigDecimal;
import java.util.List;

public class VehicleServiceImpl implements CrudService<Vehicle> {

    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public boolean add(Vehicle vehicle) {
        String licensePlate = vehicle.getLicensePlate();
        if (findVehicleByLicense(licensePlate) == null) {
            vehicleRepository.saveVehicle(vehicle);
            return true;
        }
        return false;
    }


    public boolean remove(Vehicle vehicle) {

        if (vehicle != null) {
            vehicleRepository.removeVehicle(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public boolean edit(Vehicle vehicle) {
        if (findVehicleByLicense(vehicle.getLicensePlate()) != null) {
            return vehicleRepository.editVehicle(vehicle);
        }
        return false;
    }


    public BigDecimal setDailyRentalPriceForCar(String size) {
        if (size.equalsIgnoreCase("pequeno")) {
            return BigDecimal.valueOf(100);
        } else if (size.equalsIgnoreCase("medio")) {
            return BigDecimal.valueOf(150);
        } else if (size.equalsIgnoreCase("suv")) {
            return BigDecimal.valueOf(200);
        }
        return BigDecimal.valueOf(175);
    }

    public List<Car> listCarsInAlphabeticalOrder() {
        return vehicleRepository.listCarsInAlphabeticalOrder();
    }

    public Vehicle findVehicleByName(String name) {
        return vehicleRepository.findVehicleByName(name);
    }

    public Vehicle findVehicleByLicense(String licensePlate) {
        return vehicleRepository.findVehicleByLicensePlate(licensePlate);
    }
}
