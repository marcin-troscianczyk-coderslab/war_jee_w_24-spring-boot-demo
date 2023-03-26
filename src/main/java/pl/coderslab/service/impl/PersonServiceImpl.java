package pl.coderslab.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Person;
import pl.coderslab.repository.PersonRepository;
import pl.coderslab.service.PersonService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void update(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
