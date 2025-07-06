package Service;

import Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public void register(User user) {
        user.setRole("PATIENT");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepo.save(user);

    }

    private class BCryptPasswordEncoder {
        public String encode(String password) {
            return null;
        }

    }
}
