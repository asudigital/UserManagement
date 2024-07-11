package springBoot.userManagement.springbootrestfulwebservices.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springBoot.userManagement.springbootrestfulwebservices.entity.User;
import springBoot.userManagement.springbootrestfulwebservices.repository.UserRepository;
import springBoot.userManagement.springbootrestfulwebservices.service.UserService;

import java.util.List;
import java.util.Optional;

@Service

//constructor based dependancy injection
@AllArgsConstructor
public class UserServiceImpl implements UserService {

//UserServiceImpl  bean have only one parameterized constructor @AllArgsConstructor so autowired is not required
    //Instance variable
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return  userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
       return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
      User existingUser = userRepository.findById(user.getId()).get();
      existingUser.setFirstName(user.getFirstName());
      existingUser.setLastName(user.getLastName());
      existingUser.setEmail(user.getEmail());
     return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
