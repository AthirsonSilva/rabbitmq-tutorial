package net.javaguides.accountservice.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.javaguides.accountservice.entity.AccountEntity;
import net.javaguides.accountservice.repository.AccountRepository;
import net.javaguides.accountservice.dto.UserPayload;
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

        entity.setId(UUID.randomUUID().toString());
        entity.setUserId(userPayload.getId());
        entity.setUsername(String.format("%s %s", userPayload.getFirstName(), userPayload.getLastName()));
        entity.setRoleId("1");
        entity.setStatus(StatusEnum.ACTIVE.getStatus());

        repository.save(entity);
    }
}
