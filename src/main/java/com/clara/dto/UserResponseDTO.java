// su utiliza para enviar datos al cliente
package com.clara.dto;

import lombok.Data;

@Data
public class UserResponseDTO { // usar para enviar datos al cliente
   private Long id;
   private String nombre;
   private Integer edad;
   private String correo;
}
