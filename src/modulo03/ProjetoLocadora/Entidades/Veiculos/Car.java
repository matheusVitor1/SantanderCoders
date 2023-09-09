package modulo03.ProjetoLocadora.Entidades.Veiculos;

import java.math.BigDecimal;

public class Car extends Vehicle {

    private String size;

    public Car(String name, String model, String licensePlate, BigDecimal rentalPricePerDay, String size, boolean isRented) {
        super(name, model, licensePlate, rentalPricePerDay, isRented);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + getName() + '\'' +
                ", model='" + getModel() + '\'' +
                ", licensePlate='" + getLicensePlate() + '\'' +
                ", size='" + getSize() + '\'' +
                ", rented=" + isRented() +
                '}';
    }
}
