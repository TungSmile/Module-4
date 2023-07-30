package com.example.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    private static final String SECRET_KEY = "123456789";
    // key ẩn để giải mã
    private static final long EXPIRE_TIME = 8640000000L;
    // thời gian sống của tk là 2,5h

    public String createToken(Authentication authentication) {
        // truyền xác thực để lọc và tạo token
        User user = (User) authentication.getPrincipal();
        // lấy user từ principal
        return Jwts.builder()
                .setSubject((user.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + EXPIRE_TIME ))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
        // token gồm 3 phần  subject , time life , signature : gồm thuật toán và key ẩn
    }

    public String getUserNameFromJwtToken(String token) {
        // truyền token và giải mã để lấy subject giấu trong token
        String userName = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody().getSubject();
        return userName;
    }


}
