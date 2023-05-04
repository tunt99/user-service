package com.tunt.user.controller;

import com.tunt.user.entity.User;
import com.tunt.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("users")
    public ResponseEntity<List<User>> getUsers(){

        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);

    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id){
        return new ResponseEntity<>(userRepository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("users")
    public ResponseEntity<User> createBook(@RequestBody User user){
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);

    }

    @PutMapping("users/{id}")
    public ResponseEntity<User> updateBook(@PathVariable("id") Integer id, @RequestBody User user){

        User userTemp = userRepository.findById(id).get();
        userTemp.setName(userTemp.getName());
        userTemp.setPhone(userTemp.getPhone());
        return new ResponseEntity<>(userRepository.save(userTemp), HttpStatus.OK);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
        return new ResponseEntity<>("Delete successfully",HttpStatus.OK);
    }
}
