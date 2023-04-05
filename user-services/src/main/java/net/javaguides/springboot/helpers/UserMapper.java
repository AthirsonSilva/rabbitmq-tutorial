package net.javaguides.springboot.helpers;

import net.javaguides.springboot.dto.UserPayload;
import net.javaguides.springboot.entity.UserEntity;
import org.springframework.beans.BeanUtils;

public class UserMapper {
    public static UserPayload toUserPayload(UserEntity userEntity){
        UserPayload userPayload = new UserPayload();
        BeanUtils.copyProperties(userEntity, userPayload);

        return userPayload;
    }

    public static UserEntity toUserEntity(UserPayload userPayload){
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userPayload, userEntity);

        return userEntity;
    }
}
