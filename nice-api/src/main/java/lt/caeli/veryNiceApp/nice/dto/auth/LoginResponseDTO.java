package lt.caeli.veryNiceApp.nice.dto.auth;

import java.util.List;

public record LoginResponseDTO(String username, List<String> roles) {
}
