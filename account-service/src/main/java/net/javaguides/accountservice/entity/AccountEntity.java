package net.javaguides.accountservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "account")
public class AccountEntity {
    @Id
    private String id;

    @Field("username")
    private String username;

    @Field("user_id")
    private String userId;

    @Field("role_id")
    private String roleId;

    @Field("status")
    private String status;
}
