package lt.caeli.veryNiceApp.nice.controller;

import jakarta.validation.Valid;
import lt.caeli.veryNiceApp.nice.dto.auth.LoginResponseDTO;
import lt.caeli.veryNiceApp.nice.dto.auth.RegisterRequestDTO;
import lt.caeli.veryNiceApp.nice.dto.auth.RegisterResponseDTO;
import lt.caeli.veryNiceApp.nice.dto.auth.UserMapper;
import lt.caeli.veryNiceApp.nice.model.User;
import lt.caeli.veryNiceApp.nice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> registerUser(@Valid @RequestBody RegisterRequestDTO registerRequestDTO) {
        User newUser = userService.addUser(registerRequestDTO.username(), registerRequestDTO.password());

        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                    .replacePath("/api/users/{id}")
                    .buildAndExpand(newUser.getId())
                    .toUri())
            .body(UserMapper.toRegisterResponseDTO(newUser)
            );
    }

    @GetMapping("/me")
    public ResponseEntity<LoginResponseDTO> loginUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        return ResponseEntity.ok(UserMapper.toLoginResponseDTO(user));
    }
}
