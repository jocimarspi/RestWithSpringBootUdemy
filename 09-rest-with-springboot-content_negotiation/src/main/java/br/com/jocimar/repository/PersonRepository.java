package br.com.jocimar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jocimar.data.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
