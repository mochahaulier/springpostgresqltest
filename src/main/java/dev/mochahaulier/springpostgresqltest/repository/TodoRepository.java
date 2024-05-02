package dev.mochahaulier.springpostgresqltest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.mochahaulier.springpostgresqltest.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
