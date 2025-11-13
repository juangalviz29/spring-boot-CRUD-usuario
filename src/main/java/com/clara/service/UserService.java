// Función: Servicio para gestionar usuarios
// se usa para la lógica de negocio relacionada con usuarios
// 
package com.clara.service;

import org.springframework.stereotype.Service;
import com.clara.dto.UserRequestDTO;
import com.clara.dto.UserResponseDTO;
import com.clara.entity.User;
import com.clara.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor // genera un constructor con los campos 'final'
public class UserService {

    private final UserRepository userRepository; // Inyección de dependencia del repositorio
    @Transactional //abre la transacción si falla, hacce rollback
    public UserResponseDTO crearUser(UserRequestDTO userRequestDTO) {
        // Crear entidad a partir del DTO
        User user = new User();
        user.setNombre(userRequestDTO.getNombre());
        user.setEdad(userRequestDTO.getEdad());
        user.setCorreo(userRequestDTO.getCorreo());

        // Guardar en base de datos
        userRepository.save(user);

        // Crear DTO de respuesta
        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setNombre(user.getNombre());
        response.setEdad(user.getEdad());
        response.setCorreo(user.getCorreo());

        return response;
    }
   @Transactional
    public List<UserResponseDTO> listarUser() {
        List<User> usuarios = userRepository.findAll(); // obtiene los usuarios de la BD
        List<UserResponseDTO> listaDto = new ArrayList<>();

        for (User usuario : usuarios) {
            UserResponseDTO dto = new UserResponseDTO();
            dto.setId(usuario.getId());
            dto.setNombre(usuario.getNombre());
            dto.setEdad(usuario.getEdad());
            dto.setCorreo(usuario.getCorreo());

        listaDto.add(dto);
    }
        return listaDto;
    }
    @Transactional
    public UserResponseDTO buscarUser(Long id) {
        // findById devuelve un Optional (por si no existe)
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        // Convertimos la entidad a DTO de respuesta
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setNombre(user.getNombre());
        dto.setEdad(user.getEdad());
        dto.setCorreo(user.getCorreo());
        return dto;
    }
    @Transactional
    public void eliminarUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar. Usuario no encontrado con ID: " + id);
        }
        userRepository.deleteById(id);
    }
}