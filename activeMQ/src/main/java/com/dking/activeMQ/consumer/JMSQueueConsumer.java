package com.dking.activeMQ.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 *
 * QUEUE类型的消费者
 *
 * @ClassName JMSQueueConsumer
 * @Author xinfei
 * @Date 2018/7/10 20:25
 **/
public class JMSQueueConsumer {

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
            MessageConsumer consumer = session.createConsumer(destination);

            //(5)发送消息
            TextMessage message = (TextMessage)consumer.receive();
            System.out.println("接收到消息：" + message.getText());

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
