package modulo03.ProjetoLocadora.models.Pessoas;

public class LegalPerson extends Person {
    private String cnpj;

    public LegalPerson(String name, String cnpj, String address, String password){
        super(name, cnpj, address, password);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "LegalEntity{" +
                "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
