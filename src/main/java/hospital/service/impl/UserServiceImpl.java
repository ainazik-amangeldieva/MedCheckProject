package hospital.service.impl;

import hospital.entity.User;
import hospital.repository.UserRepository;
import hospital.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUserName(String username) {
        User user = userRepository.findByUserName(username);
        return user ;
    }
}
