package com.rojudo.spring_lab.controller;

import com.rojudo.spring_lab.dto.UserDTO;
import com.rojudo.spring_lab.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        //ResponseEntity - controle sobre: Status code, Headers e Body

        List<UserDTO> users = userService.findAll();
        return ResponseEntity.ok(users);  //200 OK com body
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  //Retorna 201 Created
    public UserDTO create(@RequestBody UserDTO user) {
        //@RequestBody converte JSON do request para objeto Java usando Jackson
        return userService.create(user.name(), user.email());
    }
    
    @GetMapping("/hello")
    public String sayHello(@RequestParam(defaultValue = "Mundo") String name) {
        // @RequestParam pega parâmetro da query string: /hello?name=João
        return String.format("Olá, %s! Bem-vindo ao Spring Lab!", name);
    }
}