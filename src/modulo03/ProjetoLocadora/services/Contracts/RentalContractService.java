package modulo03.ProjetoLocadora.services.Contracts;

import modulo03.ProjetoLocadora.models.Locadora.RentalContract;
import modulo03.ProjetoLocadora.models.Pessoas.Person;
import modulo03.ProjetoLocadora.models.Veiculos.Vehicle;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface RentalContractService {
    RentalContract findRentalByCustomer(String customerCpf);
    BigDecimal calculateRentalValue(LocalDateTime rentalDate, LocalDateTime returnDate, Vehicle vehicle, Person person);
    boolean validateContract(RentalContract contrato);
    boolean createRentalContract(Vehicle vehicle, Person customer, LocalDateTime rentalDate, LocalDateTime returnDate, String returnAddress);
}

