package net.javaguides.accountservices.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.javaguides.accountservices.entity.AccountEntity;
import net.javaguides.accountservices.payload.UserPayload;
import net.javaguides.accountservices.repository.AccountRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserConsumer {
    @Value("${rabbitmq.queue.name}")
    private String queue;

    private final AccountRepository repository;

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(UserPayload userPayload){
        log.info("Received message {} from queue {}", userPayload, queue);

        AccountEntity entity = new AccountEntity();

        entity.setUserId(userPayload.getId());
        entity.setUsername(String.format("%s %s", userPayload.getFirstName(), userPayload.getLastName()));
        entity.setRoleId(UUID.randomUUID().toString());

        repository.save(entity);
    }
}
