package net.javaguides.springboot.controller;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.dto.UserPayload;
import net.javaguides.springboot.publisher.UserPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserPublisher userPublisher;

    @PostMapping
    public ResponseEntity<UserPayload> sendJsonMessage(@RequestBody UserPayload userPayload){
        userPayload.setId(UUID.randomUUID().toString());
        userPublisher.publish(userPayload);

        return new ResponseEntity<>(userPayload, null, 201);
    }
}
