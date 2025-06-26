package lt.caeli.veryNiceApp.nice.dto.auth;

import java.util.List;

public record RegisterResponseDTO(String username, List<String> roles) {
}
