/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.unicauca.publicador_suscriptor.presentation;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import javax.swing.DefaultListModel;
/**
 *
 * Recibe el mensaje
 */
public class Recv {
    
    private static final String QUEUE_NAME = "logs";
    
    static DefaultListModel modeloSuscriptor = new DefaultListModel();
    
    public void init()throws Exception{
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(QUEUE_NAME, "fanout");
    String queueName = channel.queueDeclare().getQueue();
    channel.queueBind(queueName, QUEUE_NAME, "");
   
    modeloSuscriptor.addElement(" Esperando mensaje\n ");        
    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        String message = new String(delivery.getBody(), "UTF-8");
         modeloSuscriptor.addElement(message);
        System.out.println(" [x] Received '" + message + "'");
    };
    
    channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });

    }

    public Recv() {
    }
}
