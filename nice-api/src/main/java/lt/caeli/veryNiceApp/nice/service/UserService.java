package lt.caeli.veryNiceApp.nice.service;

import lt.caeli.veryNiceApp.nice.exception.GenericValidationException;
import lt.caeli.veryNiceApp.nice.model.Role;
import lt.caeli.veryNiceApp.nice.model.User;
import lt.caeli.veryNiceApp.nice.repository.RoleRepository;
import lt.caeli.veryNiceApp.nice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public User addUser(String username, String password) {
        Optional<User> maybeDuplicateUser = userRepository.findByUsername(username);

        if (maybeDuplicateUser.isPresent()) {
            throw new GenericValidationException("User with username \"" + username + "\" already exists.");
        }

        Role defaultRole = roleRepository.findByName("ROLE_USER");
        User user = new User(username, passwordEncoder.encode(password), List.of(defaultRole));
        userRepository.save(user);

        return user;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}
