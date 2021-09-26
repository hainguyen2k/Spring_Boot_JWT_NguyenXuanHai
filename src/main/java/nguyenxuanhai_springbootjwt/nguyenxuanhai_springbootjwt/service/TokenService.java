package nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.service;

import nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.entity.Token;
import org.springframework.stereotype.Service;

public interface TokenService {
    Token createToken(Token token);

    Token findByToken(String token);
}
