package modulo03.ProjetoLocadora.services.Contracts;

import modulo03.ProjetoLocadora.models.Veiculos.Car;
import modulo03.ProjetoLocadora.models.Veiculos.Vehicle;


import java.math.BigDecimal;
import java.util.List;

public interface VehicleService {
    Vehicle findVehicleByName(String name);

    Vehicle findVehicleByLicense(String licensePlate);
    boolean addVehicle(Vehicle vehicle);
    boolean removeVehicle(String licensePlate);
    boolean editVehicle(String name, String model, String licensePlate, BigDecimal rentalPrice, String size);
    BigDecimal setDailyRentalPriceForCar(String licensePlate);
    List<Car> listCarsInAlphabeticalOrder();
}

