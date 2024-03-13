package com.maven.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private String telefono;
}
