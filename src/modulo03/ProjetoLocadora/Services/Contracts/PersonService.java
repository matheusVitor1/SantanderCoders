package modulo03.ProjetoLocadora.Services.Contracts;
import modulo03.ProjetoLocadora.Entidades.Pessoas.Person;


public interface PersonService {
    Person findPerson(String identity);

    boolean addPerson(Person person);

    boolean removePerson(String identity);

    boolean editPerson(String name, String identity, String address);
}
