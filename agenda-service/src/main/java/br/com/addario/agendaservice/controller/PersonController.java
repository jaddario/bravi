package br.com.addario.agendaservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.addario.agendaservice.model.Person;
import br.com.addario.agendaservice.repository.PersonRepository;

@RestController
@RequestMapping({ "/persons" })
public class PersonController {

	private PersonRepository repository;

	public PersonController(PersonRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Person> getAll() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Person> findById(@PathVariable long id) {
		return repository.findById(id).map(person -> ResponseEntity.ok().body(person))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Person create(@RequestBody Person person) {
		return repository.save(person);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Person> update(@PathVariable("id") long id, @RequestBody Person person) {
		return repository.findById(id).map(retrievedPerson -> {
			retrievedPerson.setName(person.getName());
			retrievedPerson.setEmail(person.getEmail());
			retrievedPerson.setPhone(person.getPhone());
			retrievedPerson.setWhatsapp(person.getWhatsapp());
			Person updatedPerson = repository.save(retrievedPerson);
			return ResponseEntity.ok().body(updatedPerson);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		return repository.findById(id).map(retrievedPerson -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
