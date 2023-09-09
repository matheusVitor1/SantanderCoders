package modulo03.ProjetoLocadora.Repositories;
import modulo03.ProjetoLocadora.Entidades.Pessoas.Person;


import java.util.*;

public class PersonRepository {
    private List<Person> people;

    public PersonRepository() {
        this.people = new ArrayList<>();
    }

    public void savePerson(Person person) {
        this.people.add(person);
    }

    public void removePerson(Person person) {
        this.people.remove(person);
    }

    public Person findPersonByIdentity(String identity) {
        for (Person person : people) {
            if (person.getIdentity().equalsIgnoreCase(identity)) {
                return person;
            }
        }
        return null;
    }

    public boolean editPerson(String name, String identity, String address) {
        Person person = findPersonByIdentity(identity);
        if (person != null) {
            person.setName(name);
            person.setAddress(address);
            return true;
        }
        return false;
    }
}
