package modulo03.ProjetoLocadora.Services.impl;

import modulo03.ProjetoLocadora.Entidades.Pessoas.Employee;
import modulo03.ProjetoLocadora.Entidades.Pessoas.IndividualPerson;
import modulo03.ProjetoLocadora.Entidades.Pessoas.LegalPerson;
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
        if (!(findPerson(identity) instanceof IndividualPerson)) {
            personRepository.savePerson(person);
            return true;
        } else if (!(findPerson(identity) instanceof LegalPerson)){
            personRepository.savePerson(person);
            return true;
        } else if (!(findPerson(identity) instanceof Employee)){
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
