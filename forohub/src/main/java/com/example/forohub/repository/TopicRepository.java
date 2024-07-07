package com.example.forohub.repository;

import com.example.forohub.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Anotación para indicar que esta interfaz es un repositorio
@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    // La interfaz JpaRepository proporciona métodos CRUD predeterminados
}
