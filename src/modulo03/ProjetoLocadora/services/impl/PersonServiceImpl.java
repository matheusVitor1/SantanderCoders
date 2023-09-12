package modulo03.ProjetoLocadora.services.impl;

import modulo03.ProjetoLocadora.models.Pessoas.Employee;
import modulo03.ProjetoLocadora.models.Pessoas.IndividualPerson;
import modulo03.ProjetoLocadora.models.Pessoas.LegalPerson;
import modulo03.ProjetoLocadora.models.Pessoas.Person;
import modulo03.ProjetoLocadora.repositories.PersonRepository;
import modulo03.ProjetoLocadora.services.Contracts.PersonService;


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
