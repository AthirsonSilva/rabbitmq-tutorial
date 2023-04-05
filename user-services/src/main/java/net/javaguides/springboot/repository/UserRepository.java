package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, Integer> {
}
