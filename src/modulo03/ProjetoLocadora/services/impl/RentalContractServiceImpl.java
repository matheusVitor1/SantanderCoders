package modulo03.ProjetoLocadora.services.impl;

import modulo03.ProjetoLocadora.models.Locadora.RentalContract;
import modulo03.ProjetoLocadora.models.Pessoas.IndividualPerson;
import modulo03.ProjetoLocadora.models.Pessoas.Person;
import modulo03.ProjetoLocadora.models.Veiculos.Vehicle;
import modulo03.ProjetoLocadora.repositories.RentalContractRepository;
import modulo03.ProjetoLocadora.services.Contracts.RentalContractService;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class RentalContractServiceImpl implements RentalContractService {

    private RentalContractRepository rentalContractRepository;

    public RentalContractServiceImpl(RentalContractRepository rentalContractRepository) {
        this.rentalContractRepository = rentalContractRepository;
    }
    @Override
    public RentalContract findRentalByCustomer(String identity) {
        return rentalContractRepository.findRentalByIdentity(identity);
    }


    public RentalContract findRentalByProtocol(int orderNumber) {
        return rentalContractRepository.findRentalByProtocol(orderNumber);
    }

    @Override
    public boolean createRentalContract(Vehicle vehicle, Person customer, LocalDateTime rentalDate, LocalDateTime returnDate, String returnAddress) {
        if (returnDate == null) {
            returnDate = RentalContract.UNDEFINED_RETURN_DATE;
        }

        BigDecimal amountToPay = calculateRentalValue(rentalDate, returnDate, vehicle, customer);

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
        if (contract.getReturnDate() == RentalContract.UNDEFINED_RETURN_DATE){
            return true;
        }

        if (contract.getRentalDate().isAfter(contract.getReturnDate())) {
            System.out.println("Data de devolução não pode ser anterior à data de locação.");
            return false;
        } else if (contract.getVehicle().isRented()) {
            System.out.println("Veículo não está disponível para aluguel!");
            return false;
        }
        return true;
    }

    public boolean returnVehicleForIndefiniteContract(RentalContract contract, LocalDateTime returnDate) {

        BigDecimal amountToPay = calculateRentalValue(contract.getRentalDate(), returnDate, contract.getVehicle(), contract.getCustomer());

        contract.setReturnDate(returnDate);
        contract.setAmountToPay(amountToPay);

        contract.getVehicle().setRented(false);

        return true;
    }


    @Override
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




}








