package service;

import entity.User;
import exception.NoUserException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.UserRepository;

@Component
public class DeleteUserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserList(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUser(User user) {
        User deletedUser = userRepository.delete(user.getId());
        if (deletedUser == null)
            throw new NoUserException();
    }
}
