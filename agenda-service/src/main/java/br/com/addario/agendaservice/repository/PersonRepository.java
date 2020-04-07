package br.com.addario.agendaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.addario.agendaservice.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
