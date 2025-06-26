package lt.caeli.veryNiceApp.nice.dto.auth;


import lt.caeli.veryNiceApp.nice.model.Role;
import lt.caeli.veryNiceApp.nice.model.User;

public class UserMapper {

    public static RegisterResponseDTO toRegisterResponseDTO(User user) {
        return new RegisterResponseDTO(
            user.getUsername(),
            user.getRoles()
                .stream()
                .map(Role::getName)
                .toList()
        );
    }

    public static LoginResponseDTO toLoginResponseDTO(User user) {
        return new LoginResponseDTO(
            user.getUsername(),
            user.getRoles()
                .stream()
                .map(Role::getName)
                .toList()
        );
    }
}
