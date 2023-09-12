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

    public List<RentalContract> listRentalRecords() {
        return Collections.unmodifiableList(rentalRecordsRepository);
    }

    public RentalContract findRentalByProtocol(int oderNumbere) {
        for (RentalContract record : rentalRecordsRepository) {
            if (record.getOrderNumber() == oderNumbere) {
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

