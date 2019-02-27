package com.dking.activeMQ.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 模拟演示ActiveMQ的生产者发送点对点的消息
 *
 */
public class JMSQueueProducer {


    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");

        Connection connection = null;

        try {
            //(1) 创建一个连接
            connection = connectionFactory.createConnection();
            connection.start();

            //(2) 创建SESSION
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

            //(3) 创建队列
            Destination destination = session.createQueue("myQueue");

            //(4)创建生产者
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);

            //(5)发送消息
            TextMessage message = session.createTextMessage("Hello Dking");
            producer.send(message);
            System.out.println("消息发送成功");
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
