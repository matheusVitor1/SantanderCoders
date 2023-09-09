package modulo03.ProjetoLocadora.Services.impl;

import modulo03.ProjetoLocadora.Entidades.Pessoas.Person;
import modulo03.ProjetoLocadora.Repositories.PersonRepository;
import modulo03.ProjetoLocadora.Services.Contracts.PersonService;


public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person findPerson(String identity) {
        return personRepository.findPersonByIdentity(identity);
    }

    @Override
    public boolean addPerson(Person person) {
        String identity = person.getIdentity();
        if (findPerson(identity) == null) {
            personRepository.savePerson(person);
            return true;
        }
        return false;
    }

    @Override
    public boolean removePerson(String identity) {
        Person person = findPerson(identity);
        if (person != null) {
            personRepository.removePerson(person);
            return true;
        }
        return false;
    }

    @Override
    public boolean editPerson(String name, String identity, String address) {
        Person person = findPerson(identity);
        if (person != null) {
            person.setName(name);
            person.setAddress(address);
            return true;
        }
        return false;
    }
}
