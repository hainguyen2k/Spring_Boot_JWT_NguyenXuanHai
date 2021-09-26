package nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.service;

import nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.entity.Token;
import nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl  implements TokenService{
    @Autowired
    private TokenRepository tokenRepository;

    public Token createToken(Token token) {
        return tokenRepository.saveAndFlush(token);
    }

    @Override
    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }
}
