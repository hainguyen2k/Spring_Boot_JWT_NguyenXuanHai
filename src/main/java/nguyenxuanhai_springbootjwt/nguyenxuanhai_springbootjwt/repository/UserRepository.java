package nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.repository;

import nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
