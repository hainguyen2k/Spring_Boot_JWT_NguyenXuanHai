package nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.repository;

import nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}
