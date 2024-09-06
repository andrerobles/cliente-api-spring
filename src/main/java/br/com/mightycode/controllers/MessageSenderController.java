package br.com.mightycode.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.mightycode.queue.setup.QueueSetup;

@RestController
public class MessageSenderController {
	private final RabbitTemplate rabbitTemplate;

    public MessageSenderController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message, @RequestParam String queue) {
        if ("one".equals(queue)) {
            rabbitTemplate.convertAndSend(QueueSetup.EXCHANGE_NAME, "routing.key.one", message);
        } else if ("two".equals(queue)) {
            rabbitTemplate.convertAndSend(QueueSetup.EXCHANGE_NAME, "routing.key.two", message);
        }
        return "Message sent to queue " + queue;
    }
}

