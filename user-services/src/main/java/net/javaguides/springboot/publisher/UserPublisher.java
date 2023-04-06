package net.javaguides.springboot.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.javaguides.springboot.dto.UserPayload;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserPublisher {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String userRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public void publish(UserPayload userPayload){
        log.info("Sending message {} to exchange {} with routing key {}", userPayload, exchange, userRoutingKey);

        rabbitTemplate.convertAndSend(exchange, userRoutingKey, userPayload);
    }
}
