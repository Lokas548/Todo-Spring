package com.mironov.todo.entity;

import jakarta.persistence.*;


@Entity
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;
    private String title;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "id")
    private UserEntity user;

    public TodoEntity() {}

    public TodoEntity(Long id, String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public Long getTodoId() {
        return todoId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setUser(UserEntity user) {this.user = user;}
}
