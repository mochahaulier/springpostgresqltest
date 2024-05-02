package dev.mochahaulier.springpostgresqltest.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "todos")
@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    private String todoText;
    private Boolean isCompleted;
    private Boolean isImportant;
    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant modifiedDate;
}
