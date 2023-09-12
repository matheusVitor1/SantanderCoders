package modulo03.ProjetoLocadora.models.Veiculos;

import java.math.BigDecimal;

public abstract class Vehicle {
    private String name;
    private String model;
    private String licensePlate;
    private BigDecimal rentalPricePerDay;
    private boolean isRented;

    public Vehicle(String name, String model, String licensePlate, BigDecimal rentalPricePerDay, boolean isRented) {
        this.name = name;
        this.model = model;
        this.licensePlate = licensePlate;
        this.rentalPricePerDay = rentalPricePerDay;
        this.isRented = isRented;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public BigDecimal getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(BigDecimal rentalPrice) {
        this.rentalPricePerDay = rentalPrice;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
}
