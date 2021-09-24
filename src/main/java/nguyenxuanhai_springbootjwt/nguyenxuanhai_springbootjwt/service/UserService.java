package nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.service;

import nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User createUser(User user);
}
