package dev.mochahaulier.springpostgresqltest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import dev.mochahaulier.springpostgresqltest.exception.TodoNotFoundException;
import dev.mochahaulier.springpostgresqltest.model.Todo;
import dev.mochahaulier.springpostgresqltest.repository.TodoRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("http://localhost:3000")
public class TodoController {
    // injecting
    @Autowired
    private TodoRepository todoRepository;

    @PostMapping("/todo")
    public Todo postNote(@RequestBody Todo newTodo) {
        return todoRepository.save(newTodo);
    }

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @GetMapping("/todo/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @PutMapping("/todo/{id}")
    public Todo putTodoById(@PathVariable Long id, @RequestBody Todo newTodo) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setTodoText(newTodo.getTodoText());
                    todo.setIsImportant(newTodo.getIsImportant());
                    todo.setIsCompleted(newTodo.getIsCompleted());
                    return todoRepository.save(todo);
                })
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @DeleteMapping("todo/{id}")
    public String delTodoById(@PathVariable Long id) {
        if (!todoRepository.existsById(id)) {
            throw new TodoNotFoundException(id);
        }
        todoRepository.deleteById(id);
        return ("Todo with id " + id + " was deleted!");
    }
}
