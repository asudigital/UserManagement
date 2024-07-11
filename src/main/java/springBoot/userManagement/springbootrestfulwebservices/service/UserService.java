package springBoot.userManagement.springbootrestfulwebservices.service;

import springBoot.userManagement.springbootrestfulwebservices.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long userId);
    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long id);


}
