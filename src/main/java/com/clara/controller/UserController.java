// funcionalidad del controlador para gestionar usuarios
// se usa para definir endpoints REST
// Controlador REST para gestionar usuarios
package com.clara.controller;

import com.clara.dto.UserRequestDTO;
import com.clara.dto.UserResponseDTO;
import com.clara.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/crearUser")
    public ResponseEntity<UserResponseDTO> crearUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO response = userService.crearUser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/listarUser")
    public ResponseEntity<List<UserResponseDTO>> listarUser() {
        List<UserResponseDTO> lista = userService.listarUser();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> buscarUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.buscarUser(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUser(@PathVariable Long id) {
        userService.eliminarUser(id);
        return ResponseEntity.ok("Usuario con ID " + id + " eliminado correctamente");
    }
}
