package com.rojudo.spring_lab.dto.response;

public record UserResponse(
    Long id,
    String name,
    String email
) {

}