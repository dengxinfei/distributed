package com.dking.activeMQ.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Topic类型消息的消费
 *
 * @ClassName JMSTopicConsumer
 * @Author xinfei
 * @Date 2018/7/10 20:40
 **/
public class JMSTopicConsumer {


    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");

        Connection connection = null;
        try {
            //(1) 创建一个连接
            connection = connectionFactory.createConnection();
            connection.start();

            //(2) 创建SESSION
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

            //(3) 创建Topic
            Destination destination = session.createTopic("myTopic");

            //(4)创建生产者
            MessageConsumer consumer = session.createConsumer(destination);

            //(5)发送消息
            TextMessage message = (TextMessage)consumer.receive();
            System.out.println("接收到Topic消息：" + message.getText());

            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }


    }
}
