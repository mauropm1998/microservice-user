package com.microservice.User.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.microservice.User.dtos.EmailDto;
import com.microservice.User.models.User;

@Component
public class UserProducer {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Value("${broker.queue.email.name}")
	String routingKey;

	public void publishEmailMessage(User user) {
		EmailDto emailDto = new EmailDto(user.getId(), user.getEmail(), "Cadastro realizado com sucesso!",
				user.getName() + ", seja bem-vindo a nossa plataforma.\n A sua conta foi criada com sucesso!");
		
		rabbitTemplate.convertAndSend("", routingKey, emailDto);
	}

}
