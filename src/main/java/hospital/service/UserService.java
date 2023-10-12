package hospital.service;

import hospital.entity.User;

public interface UserService {
    User findByUserName(String username);
}
