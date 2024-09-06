package br.com.mightycode.queue.setup;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueSetup {
	// Definindo os nomes das filas
    public static final String QUEUE_ONE = "queue_one";
    public static final String QUEUE_TWO = "queue_two";

    // Definindo o nome do exchange
    public static final String EXCHANGE_NAME = "my_exchange";

    // Filas
    @Bean
    public Queue queueOne() {
    	//TODO: Utilizar o parâmetro como true caso as filas ainda não estejam criadas
        return new Queue(QUEUE_ONE, false);
    }

    @Bean
    public Queue queueTwo() {
    	//TODO: Utilizar o parâmetro como true caso as filas ainda não estejam criadas
        return new Queue(QUEUE_TWO, false);
    }

    // Exchange (será o mesmo para as duas filas)
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    // Bindings (associar fila e exchange com routing keys diferentes)
    @Bean
    public Binding bindingQueueOne(Queue queueOne, TopicExchange exchange) {
        return BindingBuilder.bind(queueOne).to(exchange).with("routing.key.one");
    }

    @Bean
    public Binding bindingQueueTwo(Queue queueTwo, TopicExchange exchange) {
        return BindingBuilder.bind(queueTwo).to(exchange).with("routing.key.two");
    }
}
