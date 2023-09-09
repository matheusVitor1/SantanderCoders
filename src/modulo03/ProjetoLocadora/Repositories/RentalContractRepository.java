package modulo03.ProjetoLocadora.Repositories;

import modulo03.ProjetoLocadora.Entidades.Locadora.RentalContract;

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

    public List<RentalContract> listRentalRecords() {
        return Collections.unmodifiableList(rentalRecordsRepository);
    }

    public RentalContract findRentalByDate(LocalDateTime date) {
        for (RentalContract record : rentalRecordsRepository) {
            if (record.getRentalDate().isEqual(date)) {
                return record;
            }
        }
        return null;
    }

    public RentalContract findRentalByIdentity(String customerCpf) {
        for (RentalContract record : rentalRecordsRepository) {
            if (record.getCustomer().getIdentity().equalsIgnoreCase(customerCpf)) {
                return record;
            }
        }
        return null;
    }
}

