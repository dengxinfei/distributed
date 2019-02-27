package com.dking.activeMQ.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 *  模拟消息同步发送，与消息异步发送的原理
 *
 *   1. 事务模式下，消息都是异步发送(不管是持久化消息，还是非持久化消息)
 *   2. 非事务模式下，非持久化消息是异步发送，持久化消息是同步发送的。
 *
 *   1. 非持久化的消息都是异步发送
 *   2. 持久化的消息在事务模式下异步发送，在非事务模式下同步发送。
 *
 *   但是可以通过配置设置是否异步发送
 *   connectionFactory.setUseAsyncSend(true); //设置异步发送
 */
public class JMSQueueAsynProducer {


    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        ((ActiveMQConnectionFactory) connectionFactory).setUseAsyncSend(true); //设置异步发送

        Connection connection = null;
        try {
            //(1) 创建一个连接
            connection = connectionFactory.createConnection();
            connection.start();

            //(2) 创建SESSION
            Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);


            //(3) 创建队列
            Destination destination = session.createQueue("myQueue");

            //(4)创建生产者
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            producer.setTimeToLive(100000);

            //(5)发送消息
            TextMessage message = session.createTextMessage("Hello Dking");
            producer.send(message);



        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if(null != connection){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }






}
