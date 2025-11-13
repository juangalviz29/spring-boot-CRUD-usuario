package com.clara.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity // bean semántico (se instancia una solo vez) (singleton) // la instancia por debajo
@Data // genera getters y setters automáticamente
@Table(name = "usuarios") // mapea la clase con la tabla usuarios
public class User { 
    @Id // referencia a una columna llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento
    private Long id;

    @Column(nullable = false) // columna no nula
    private String nombre;

    @Column(nullable = false)
    private Integer edad;

    @Column(nullable = false)
    private String correo;

}   