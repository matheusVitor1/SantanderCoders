package modulo03.ProjetoLocadora.repositories;

import modulo03.ProjetoLocadora.models.Locadora.RentalContract;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RentalContractRepository {
    private List<RentalContract> rentalRecordsRepository;

    public RentalContractRepository() {
        this.rentalRecordsRepository = new ArrayList<>();
    }

    public void saveRentalRecord(RentalContract obj) {
        this.rentalRecordsRepository.add(obj);
    }

    public void removeRentalRecord(RentalContract obj) {
        this.rentalRecordsRepository.remove(obj);
    }

    public List<RentalContract> getAllRentalContracts() {
        return new ArrayList<>(rentalRecordsRepository);
    }

    public RentalContract findRentalByProtocol(int oderNumbere) {
        for (RentalContract record : rentalRecordsRepository) {
            if (record.getOrderNumber() == oderNumbere) {
                return record;
            }
        }
        return null;
    }

    public List<RentalContract> findRentalByIdentity(String customerCpf) {
        List<RentalContract> matchingContracts = new ArrayList<>();

        for (RentalContract record : rentalRecordsRepository) {
            if (record.getCustomer().getIdentity().equalsIgnoreCase(customerCpf)) {
                matchingContracts.add(record);
            }
        }

        return matchingContracts.isEmpty() ? null : matchingContracts;
    }


}

