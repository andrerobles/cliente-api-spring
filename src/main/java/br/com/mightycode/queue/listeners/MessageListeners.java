package br.com.mightycode.queue.listeners;

import java.util.logging.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import br.com.mightycode.queue.setup.QueueSetup;

public class MessageListeners {
	private Logger logger = Logger.getLogger(MessageListeners.class.getName());
	
	@RabbitListener(queues = QueueSetup.QUEUE_ONE)
    public void receiveMessageFromQueueOne(String message) {
		logger.info("Message received from queue 1: " + message);
    }

    @RabbitListener(queues = QueueSetup.QUEUE_TWO)
    public void receiveMessageFromQueueTwo(String message) {
        logger.info("Message received from queue 2: " + message);
    }
}
