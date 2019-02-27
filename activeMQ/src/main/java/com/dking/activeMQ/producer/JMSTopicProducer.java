package com.dking.activeMQ.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSTopicProducer {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");

        Connection connection = null;

        try {
            //(1) 创建一个连接
            connection = connectionFactory.createConnection();
            connection.start();

            //(2) 创建SESSION
            Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

            //(3) 创建TOPIC
            Destination destination = session.createTopic("myTopic");

            //(4)创建生产者
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);

            //(5)发送消息
            TextMessage message = session.createTextMessage("Topic: Dking");
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
