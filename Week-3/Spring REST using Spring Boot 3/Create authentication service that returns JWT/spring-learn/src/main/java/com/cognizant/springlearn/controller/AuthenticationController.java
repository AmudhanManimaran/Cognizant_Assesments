package com.cognizant.springlearn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.dto.AuthenticationResponse;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    // Fetch the secret from application.properties
    @Value("${jwt.secret}")
    private String secret;

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START: inside authenticate()");
        LOGGER.debug("Received Authorization Header: {}", authHeader);

        // Exception Handling: Ensure the header is valid before substring
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new RuntimeException("Invalid Authorization Header");
        }

        // Step 1: Read Authorization header and decode the username and password
        String base64Credentials = authHeader.substring("Basic".length()).trim();
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);

        final String[] values = credentials.split(":", 2);
        String user = values[0];

        LOGGER.debug("Decoded Username: {}", user);

        // Step 2: Generate token based on the user retrieved
        String token = generateJwtToken(user);

        LOGGER.info("END: inside authenticate()");

        // Step 3: Return the token using the DTO
        return new AuthenticationResponse(token);
    }

    private String generateJwtToken(String user) {
        Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(key)
                .compact();
    }
}