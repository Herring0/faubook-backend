package com.herring.faubook.config.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.herring.faubook.config.security.UserDetailsImpl;
import com.herring.faubook.entity.UserEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import static com.herring.faubook.config.SecurityConstants.EXPIRATION_TIME;
import static com.herring.faubook.config.SecurityConstants.SECRET;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        setFilterProcessesUrl("/api/services/user/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {

//            String jsn = req.getReader().lines().collect(Collectors.joining());
//            System.out.println(jsn);
//            System.out.println(req.getParameter("login"));
//            System.out.println(req.getParameter("password"));
//            System.out.println(req.getParameter("cmd"));
//            System.out.println(req.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
            UserDetailsImpl creds = new ObjectMapper()
                    .readValue(req.getInputStream(), UserDetailsImpl.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException {
        String token = JWT.create()
                .withSubject(((UserDetailsImpl) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET.getBytes()));

        String body = ((UserDetailsImpl) auth.getPrincipal()).getUsername() + " " + token;

        res.getWriter().write(body);
        res.getWriter().flush();
    }


}
