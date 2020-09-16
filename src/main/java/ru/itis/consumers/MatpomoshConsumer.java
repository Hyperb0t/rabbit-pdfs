package ru.itis.consumers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import ru.itis.services.PdfWriter;
import ru.itis.models.Passport;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MatpomoshConsumer {

    private final static String QUEUE_NAME = "matpomosh_queue";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        ObjectMapper mapper = new ObjectMapper();
        PdfWriter pdfWriter = new PdfWriter();
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.basicQos(3);

            channel.basicConsume(QUEUE_NAME, false, (consumerTag, message) -> {
                try{
                    Passport p = mapper.readValue(message.getBody(), Passport.class);
                    System.out.println("DOING " + p.toString());
                    pdfWriter.writeMatpomoshPdf(p);
                    channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
                    System.out.println("COMPLETED");
                }catch (Exception e) {
                    System.out.println("FAILED");
                    channel.basicReject(message.getEnvelope().getDeliveryTag(), false);
                }
            },
                    consumerTag -> {});

        } catch (IOException | TimeoutException e) {
            throw new IllegalStateException(e);
        }
    }
}
