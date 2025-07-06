package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    public String registerUser(User user){
        if (userRepository.findByemail(user.getEmail()).isPresent()){
            return "Email already registerd ";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
        return "User registerd sucessfull";
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByemail(email);
    }
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
    public void updateUser(User user){
        userRepository.save(user);
    }
}
