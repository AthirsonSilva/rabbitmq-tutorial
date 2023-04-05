package net.javaguides.springboot.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.javaguides.springboot.dto.UserPayload;
import net.javaguides.springboot.entity.UserEntity;
import net.javaguides.springboot.helpers.UserMapper;
import net.javaguides.springboot.repository.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserConsumer {
    @Value("${rabbitmq.queue.name}")
    private String queue;

    private final UserRepository userRepository;

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(UserPayload userPayload){
        log.info("Received message {} from queue {}", userPayload, queue);

        UserEntity userEntity = UserMapper.toUserEntity(userPayload);

        userRepository.save(userEntity);
    }
}
