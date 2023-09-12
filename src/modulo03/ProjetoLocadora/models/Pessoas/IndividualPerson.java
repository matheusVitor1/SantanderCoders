package modulo03.ProjetoLocadora.models.Pessoas;

public class IndividualPerson extends Person {

    public IndividualPerson(String name, String cpf, String address, String password){
        super(name, cpf, address, password);
    }

    @Override
    public String toString() {
        return "Individual{" +
                "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", cpf='" + getIdentity() + '\'' +
                '}';
    }

}
