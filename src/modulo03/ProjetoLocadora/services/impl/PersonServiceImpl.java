package modulo03.ProjetoLocadora.services.impl;

import modulo03.ProjetoLocadora.models.Pessoas.Person;
import modulo03.ProjetoLocadora.repositories.PersonRepository;
import modulo03.ProjetoLocadora.services.Contracts.CrudService;


public class PersonServiceImpl implements CrudService<Person> {
    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }



    @Override
    public boolean add(Person person) {
        String identity = person.getIdentity();
        Person existingPerson = findPerson(identity);
        if (existingPerson == null || !person.getClass().equals(existingPerson.getClass())) {
            personRepository.savePerson(person);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Person pessoa) {
        Person person = findPerson(pessoa.getIdentity());
        if (person != null) {
            personRepository.removePerson(person);
            return true;
        }
        return false;
    }

    @Override
    public boolean edit(Person person) {

        if (findPerson(person.getIdentity()) != null) {
            personRepository.editPerson(person);
            return true;
        }
        return false;
    }

    public Person findPerson(String identity) {
        return personRepository.findPersonByIdentity(identity);
    }
}
