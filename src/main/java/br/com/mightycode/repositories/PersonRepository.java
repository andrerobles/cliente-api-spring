package br.com.mightycode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mightycode.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
