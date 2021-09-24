package nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.service;

import nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.entity.User;
import nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }
}
