package org.example.quizz.controller;

import org.example.quizz.model.User;
import org.example.quizz.response.ResponseMessage;
import org.example.quizz.service.UserService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        if(userService.existEmail(user.getEmail())){
            return new ResponseEntity<>(new ResponseMessage("Email already exists"), HttpStatus.CONFLICT);
        }
        userService.addUser(user);
        return new ResponseEntity<>(new ResponseMessage("Add new person successfully"), HttpStatus.OK);
    }


}
