package net.javaguides.springboot.dto;

import lombok.Data;

@Data
public class UserPayload {
    private String id;
    private String firstName;
    private String lastName;
}
