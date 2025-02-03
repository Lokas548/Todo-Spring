package com.mironov.todo.model;

import com.mironov.todo.entity.UserEntity;

public class UserModel {
    private Long id;
    private String username;

    public static UserModel toModel(UserEntity entity){
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        return model;
    }

    public UserModel() {
    }

    public UserModel(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
