package modulo03.ProjetoLocadora.Services.impl;

import modulo03.ProjetoLocadora.Entidades.Locadora.RentalContract;
import modulo03.ProjetoLocadora.Entidades.Pessoas.Person;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Vehicle;
import modulo03.ProjetoLocadora.Repositories.RentalContractRepository;
import modulo03.ProjetoLocadora.Services.Contracts.RentalContractService;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class RentalContractServiceImpl implements RentalContractService {

    private RentalContractRepository rentalContractRepository;

    public RentalContractServiceImpl(RentalContractRepository rentalContractRepository) {
        this.rentalContractRepository = rentalContractRepository;
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

    @Override
    public RentalContract findRentalByCustomer(String identity) {
        return null;
    }

    @Override
    public BigDecimal calculateRentalValue(LocalDateTime rentalDate, LocalDateTime returnDate, Vehicle vehicle) {

        if (returnDate.equals(RentalContract.UNDEFINED_RETURN_DATE)) {
            return BigDecimal.ZERO;
        }

        BigDecimal dailyRentalPrice = vehicle.getRentalPricePerDay();
        long dailyRentals = calculateDailyRentals(rentalDate, returnDate);
        BigDecimal contractValue = dailyRentalPrice.multiply(BigDecimal.valueOf(dailyRentals));

        return contractValue;
    }

    @Override
    public boolean createRentalContract(Vehicle vehicle, Person customer, LocalDateTime rentalDate, LocalDateTime returnDate, String returnAddress) {
        if (returnDate == null) {
            returnDate = RentalContract.UNDEFINED_RETURN_DATE;
        }

        BigDecimal amountToPay = calculateRentalValue(rentalDate, returnDate, vehicle);

        RentalContract rentalContract = new RentalContract(vehicle, customer, rentalDate, returnDate, returnAddress, amountToPay);

        if (validateContract(rentalContract)) {
            rentalContractRepository.saveRentalRecord(rentalContract);
            vehicle.setRented(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean validateContract(RentalContract contract) {

        if (contract.getRentalDate().isAfter(contract.getReturnDate())) {
            System.out.println("Data de devolução não pode ser anterior à data de locação.");
            return false;
        } else if (contract.getVehicle().isRented()) {
            System.out.println("Veículo já alugado!");
            return false;
        }
        return true;
    }
}








