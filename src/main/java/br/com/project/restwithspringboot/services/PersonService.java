package br.com.project.restwithspringboot.services;

import br.com.project.restwithspringboot.data.vos.v1.PersonVO;
import br.com.project.restwithspringboot.exceptions.ResourceNotFoundException;
import br.com.project.restwithspringboot.data.models.Person;
import br.com.project.restwithspringboot.repositories.PersonRepository;
import br.com.project.restwithspringboot.utils.DozerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public PersonVO findById(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO person){
        var entity= DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO person){
        var entity = repository.findById(person.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id){
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        repository.delete(entity);
    }
}
