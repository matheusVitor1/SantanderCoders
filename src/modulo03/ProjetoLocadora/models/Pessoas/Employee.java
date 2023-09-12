package modulo03.ProjetoLocadora.models.Pessoas;

public class Employee extends Person {
    private String identification;

    public Employee(String name, String identification, String address, String password){
        super(name, identification, address, password);
        this.identification = identification;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    @Override
    public String toString() {

        return "Employee{" +
                "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", cnpj/cpf='" + identification + '\'' +
                '}';
    }
}
