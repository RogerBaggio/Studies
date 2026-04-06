package com.rojudo.spring_lab.validation;

public interface ValidationGroups {
    
    // Grupo para operações de CRIAÇÃO
    interface OnCreate {}
    
    // Grupo para operações de ATUALIZAÇÃO
    interface OnUpdate {}
    
    // Grupo para operações de PATCH (atualização parcial)
    interface OnPatch {}
}