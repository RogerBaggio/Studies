package com.rojudo.spring_lab.service;

import com.rojudo.spring_lab.dto.UserDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class UserService {
    
    private final List<UserDTO> users = new ArrayList<>();
    private Long nextId = 1L;
    
    public List<UserDTO> findAll() {
        return new ArrayList<>(users);
    }
    
    public UserDTO create(String name, String email) {
        // Aqui vão regras de negócio (Validar se único, verificar se vazio, regras de formatação...)       
        UserDTO newUser = new UserDTO(nextId++, name, email);
        users.add(newUser);
        return newUser;
    }
}