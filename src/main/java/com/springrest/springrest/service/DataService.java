package com.springrest.springrest.service;
import java.util.List;
import com.springrest.springrest.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface DataService {
    public List<User> getUser();
    public User getUser(long id);
    public User addUser(User user);
    public User updateUser(User user);
    public void deleteUser(long id);
}