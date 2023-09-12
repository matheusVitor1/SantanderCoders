package modulo03.ProjetoLocadora.services.impl;

import modulo03.ProjetoLocadora.models.Locadora.RentalContract;
import modulo03.ProjetoLocadora.models.Pessoas.IndividualPerson;
import modulo03.ProjetoLocadora.models.Pessoas.Person;
import modulo03.ProjetoLocadora.models.Veiculos.Vehicle;
import modulo03.ProjetoLocadora.repositories.RentalContractRepository;
import modulo03.ProjetoLocadora.repositories.VehicleRepository;
import modulo03.ProjetoLocadora.services.Contracts.CrudService;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class RentalContractServiceImpl  implements CrudService<RentalContract> {

    private RentalContractRepository rentalContractRepository;
    private VehicleRepository vehicleRepository;

    public RentalContractServiceImpl(RentalContractRepository rentalContractRepository, VehicleRepository vehicleRepository) {
        this.rentalContractRepository = rentalContractRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public boolean add(RentalContract contract) {
        LocalDateTime returnDate = contract.getReturnDate();
        if (returnDate == null) {
            returnDate = RentalContract.UNDEFINED_RETURN_DATE;
        }
        Vehicle vehicle = vehicleRepository.findVehicleByLicensePlate(contract.getVehicle().getLicensePlate());

        BigDecimal amountToPay = calculateRentalValue(contract.getRentalDate(), returnDate, contract.getVehicle(), contract.getCustomer());

        contract.setAmountToPay(amountToPay);

        if (validateContract(contract)) {
            rentalContractRepository.saveRentalRecord(contract);
            contract.getVehicle().setRented(true);
            return true;
        }
        return false;
    }

    public boolean returnVehicleForIndefiniteContract(RentalContract contract, LocalDateTime returnDate) {

        BigDecimal amountToPay = calculateRentalValue(contract.getRentalDate(), returnDate, contract.getVehicle(), contract.getCustomer());

        contract.setReturnDate(returnDate);
        contract.setAmountToPay(amountToPay);

        contract.getVehicle().setRented(false);

        return true;
    }

    public boolean validateContract(RentalContract contract) {
        if (contract.getReturnDate() == RentalContract.UNDEFINED_RETURN_DATE) {
            return true;
        }

        LocalDateTime rentalDate = contract.getRentalDate();
        LocalDateTime returnDate = contract.getReturnDate();
        Vehicle vehicle = contract.getVehicle();

        for (RentalContract existingContract : rentalContractRepository.getAllRentalContracts()) {
            if (existingContract.getVehicle().equals(vehicle)) {
                LocalDateTime existingRentalDate = existingContract.getRentalDate();
                LocalDateTime existingReturnDate = existingContract.getReturnDate();


                if ((rentalDate.isAfter(existingRentalDate) && rentalDate.isBefore(existingReturnDate)) ||
                        (returnDate.isAfter(existingRentalDate) && returnDate.isBefore(existingReturnDate)) ||
                        (rentalDate.isBefore(existingRentalDate) && returnDate.isAfter(existingReturnDate))) {
                    System.out.println("Veículo não está disponível para aluguel no período desejado!");
                    return false;
                }
            }
        }

        return true;
    }


    public BigDecimal calculateRentalValue(LocalDateTime rentalDate, LocalDateTime returnDate, Vehicle vehicle, Person person) {
        if (returnDate.equals(RentalContract.UNDEFINED_RETURN_DATE)) {
            return BigDecimal.ZERO;
        }

        BigDecimal dailyRentalPrice = vehicle.getRentalPricePerDay();
        long dailyRentals = calculateDailyRentals(rentalDate, returnDate);

        BigDecimal contractValue = dailyRentalPrice.multiply(BigDecimal.valueOf(dailyRentals));

        if (person instanceof IndividualPerson && dailyRentals > 5) {
            BigDecimal discount = contractValue.multiply(BigDecimal.valueOf(0.05)); // 5% de desconto
            contractValue = contractValue.subtract(discount);
        } else if (!(person instanceof IndividualPerson) && dailyRentals > 3) {
            BigDecimal discount = contractValue.multiply(BigDecimal.valueOf(0.10)); // 10% de desconto
            contractValue = contractValue.subtract(discount);
        }

        return contractValue;
    }
    private long calculateDailyRentals(LocalDateTime rentalDate, LocalDateTime returnDate) {

        Duration rentalDuration = Duration.between(rentalDate, returnDate);

        long roundedHours = (long) Math.ceil((double) rentalDuration.toMinutes() / 60);

        if (returnDate.isAfter(rentalDate)) {
            roundedHours++;
        }
        long dailyRentals = roundedHours / 24;

        return dailyRentals;
    }

    public List<RentalContract> findRentalByCustomer(String identity) {
        return rentalContractRepository.findRentalByIdentity(identity);
    }

    public RentalContract findRentalByProtocol(int orderNumber) {
        return rentalContractRepository.findRentalByProtocol(orderNumber);
    }

    @Override
    public boolean remove(RentalContract object) {
        return false;
    }

    @Override
    public boolean edit(RentalContract object) {
        return false;
    }


}








