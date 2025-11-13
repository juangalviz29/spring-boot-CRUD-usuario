// se usa para transferir datos entre el cliente y el servidor
package com.clara.dto; // DTO: Data Transfer Object

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO { // usar para recibir datos del cliente
    @Size(min = 2, max = 50) // valida que el tamaño del nombre esté entre 2 y 50 caracteres
    private String nombre;
    @Positive // valida que la edad sea un número positivo
    @Min(18) // valida que la edad mínima sea 18
    @Max(100) // valida que la edad máxima sea 100
    private Integer edad;
    @Email // valida que el correo tenga un formato válido
    private String correo;
}
