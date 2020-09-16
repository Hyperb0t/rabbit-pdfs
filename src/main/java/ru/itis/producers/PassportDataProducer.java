package ru.itis.producers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import ru.itis.services.PassportGenerator;
import ru.itis.models.Passport;

import java.io.*;
import java.util.concurrent.TimeoutException;

public class PassportDataProducer {

    private final static String EXCHANGE_NAME = "passport_data";

    private final static String EXCHANGE_TYPE = "fanout";

    private final static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        PassportGenerator passportGenerator = new PassportGenerator();
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);
            while (true) {
                Passport p = passportGenerator.generate();
                channel.basicPublish(EXCHANGE_NAME, "",null, mapper.writeValueAsBytes(p));
            }
        } catch (IOException | TimeoutException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
