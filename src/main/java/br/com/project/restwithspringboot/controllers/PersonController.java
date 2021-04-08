package br.com.project.restwithspringboot.controllers;

import br.com.project.restwithspringboot.data.vos.v1.PersonVO;
import br.com.project.restwithspringboot.services.PersonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Api(value = "Person Endpoint", tags = {"Person Endpoint"})
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public List<PersonVO> findAll() {
        List<PersonVO> persons =  service.findAll();
        persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
        return persons;
    }

    @GetMapping("/{id}")
    public PersonVO findById(@PathVariable(value="id") Long id) {
        PersonVO personVO = service.findById(id);
        personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return personVO;
    }

    @PostMapping
    public PersonVO create(@RequestBody PersonVO person) {
        PersonVO personVO = service.create(person);
        personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
        return personVO;
    }

    @PutMapping
    public PersonVO update(@RequestBody PersonVO person) {
        PersonVO personVO = service.update(person);
        personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
        return personVO;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
