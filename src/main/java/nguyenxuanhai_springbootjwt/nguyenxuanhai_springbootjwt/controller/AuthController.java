package nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.controller;

import nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.authen.UserPrincipal;
import nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.entity.Token;
import nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.entity.User;
import nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.service.TokenService;
import nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.service.UserService;
import nguyenxuanhai_springbootjwt.nguyenxuanhai_springbootjwt.ulti.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private TokenService tokenService;
    @PostMapping("/register")
    public User register(@RequestBody User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        return userService.createUser(user);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){

        UserPrincipal userPrincipal =
                userService.findByUsername(user.getUsername());

        if (null == user || !new BCryptPasswordEncoder()
                .matches(user.getPassword(), userPrincipal.getPassword())) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Account or password is not valid!");
        }

        Token token = new Token();
        token.setToken(jwtUtil.generateToken(userPrincipal));

        token.setTokenExpDate(jwtUtil.generateExpirationDate());
        token.setCreatedBy(userPrincipal.getUserId());
        tokenService.createToken(token);

        return ResponseEntity.ok(token.getToken());
    }

}
