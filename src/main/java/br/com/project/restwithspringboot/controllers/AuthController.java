package br.com.project.restwithspringboot.controllers;

import br.com.project.restwithspringboot.repositories.UserRepository;
import br.com.project.restwithspringboot.security.AccountCredencialsVO;
import br.com.project.restwithspringboot.security.jwt.JwtTokenProvider;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserRepository userRepository;

    @ApiOperation("Authenticate a user by credentials")
    @PostMapping(value = "/signin")
    public ResponseEntity signin(@RequestBody AccountCredencialsVO data) {
        try {
            var username = data.getUsername();
            var password = data.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            var user = userRepository.findByUsername(username);
            var token = "";
            if(user != null){
                token = tokenProvider.createToken(username, user.getRoles());
            } else {
                throw new UsernameNotFoundException("Username " + username + " font found!");
            }
            Map<Object, Object> model = new HashMap<>();

            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationServiceException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}
