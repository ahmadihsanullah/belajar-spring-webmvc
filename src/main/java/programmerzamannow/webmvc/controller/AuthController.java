package programmerzamannow.webmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AuthController {
    @PostMapping(path = "/auth/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> login(@RequestParam(name = "username") String username,
                                        @RequestParam(name = "password") String password,
                                        HttpServletResponse response) {
            if("eko".equals(username) && "rahasia".equals(password)){
                Cookie cookie = new Cookie("username", "eko");
                response.addCookie(cookie);
                return ResponseEntity.ok().body("OK");
            }else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("KO");
            }
    }

    @GetMapping(path = "/auth/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUser(@CookieValue(name = "username") String username) {
        if ("eko".equals(username)) {
            return ResponseEntity.ok().body("Hello " + username );
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("KO");
        }

    }
}
