package modulo03.ProjetoLocadora.models.Locadora;
import modulo03.ProjetoLocadora.models.Pessoas.Person;
import modulo03.ProjetoLocadora.models.Veiculos.Vehicle;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RentalContract {

    private static Integer lastOrderNumber = 0;
    private Integer orderNumber;

    public static final LocalDateTime UNDEFINED_RETURN_DATE = LocalDateTime.MIN;

    private Vehicle vehicle;
    private Person customer;
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
    private String returnAddress;
    private BigDecimal amountToPay;

    public RentalContract(Vehicle vehicle, Person customer, LocalDateTime rentalDate, LocalDateTime returnDate, String returnAddress, BigDecimal amountToPay) {
        this.orderNumber = ++lastOrderNumber;
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.returnDate = (returnDate != null) ? returnDate : UNDEFINED_RETURN_DATE;
        this.returnAddress = returnAddress;
        this.amountToPay = amountToPay;
    }

    public static Integer getLastOrderNumber() {
        return lastOrderNumber;
    }

    public static void setLastOrderNumber(Integer lastOrderNumber) {
        RentalContract.lastOrderNumber = lastOrderNumber;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public String getReturnAddress() {
        return returnAddress;
    }

    public void setReturnAddress(String returnAddress) {
        this.returnAddress = returnAddress;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public BigDecimal getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(BigDecimal amountToPay) {
        this.amountToPay = amountToPay;
    }

    @Override
    public String toString() {
        String returnDateStr = (returnDate.equals(UNDEFINED_RETURN_DATE)) ? "Data de devolução indefinida" : returnDate.toString();
        return "RentalContract{" +
                "orderNumber=" + orderNumber + '\'' +
                ", vehicle=" + vehicle + '\'' +
                ", customer=" + customer + '\'' +
                ", rentalDate=" + rentalDate + '\'' +
                ", returnDate=" + returnDateStr + '\'' +
                ", valorPago=" + amountToPay +
                '}';
    }
}
