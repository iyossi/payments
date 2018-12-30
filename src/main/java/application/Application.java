package application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static final String RISK_RESPONSE_ROUTING_KEY = "payment.risk.response";
    public static final String RISK_REQUESTS_ROUTING_KEY = "payment.risk.request";
    static final public String RISK_REQUEST_QUEUE_NAME = "riskRequests";
    static final public String RISK_RESPONSE_QUEUE_NAME = "riskResponses";
    private static final String topicExchangeName = "riskEngine-exchange";
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static String getTopicExchangeName() {
        return topicExchangeName;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        logger.info("Starting");
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    public Queue requestQueue() {
        return new Queue(RISK_REQUEST_QUEUE_NAME, false);
    }


    @Bean
    Binding binding() {
        return BindingBuilder.bind(requestQueue()).to(exchange()).with(RISK_REQUESTS_ROUTING_KEY);
    }

    @Bean
    public Queue responseQueue() {
        return new Queue(RISK_RESPONSE_QUEUE_NAME, false);
    }


    @Bean
    Binding bindingResponse() {
        return BindingBuilder.bind(responseQueue()).to(exchange()).with(RISK_RESPONSE_ROUTING_KEY);
    }
}