package modulo03.ProjetoLocadora.Services.Contracts;

import modulo03.ProjetoLocadora.Entidades.Locadora.RentalContract;
import modulo03.ProjetoLocadora.Entidades.Pessoas.Person;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Vehicle;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface RentalContractService {
    RentalContract findRentalByCustomer(String customerCpf);
    BigDecimal calculateRentalValue(LocalDateTime rentalDate, LocalDateTime returnDate, Vehicle vehicle);
    boolean validateContract(RentalContract contrato);
    boolean createRentalContract(Vehicle vehicle, Person customer, LocalDateTime rentalDate, LocalDateTime returnDate, String returnAddress);
}

