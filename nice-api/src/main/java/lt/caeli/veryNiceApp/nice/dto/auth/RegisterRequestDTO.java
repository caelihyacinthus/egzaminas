package lt.caeli.veryNiceApp.nice.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequestDTO(
    @NotBlank
    @Size(max = 150, message = "Cannot exceed 150 characters.")
    String username,
    String password) {
}
