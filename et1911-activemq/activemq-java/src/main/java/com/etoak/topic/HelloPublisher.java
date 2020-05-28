package com.etoak.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloPublisher {

	public static void main(String[] args) throws JMSException {
		// 1创建ConnectionFactory(用户名, 密码, 链接地址)
		ConnectionFactory factory = new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		// 2通过ConnectionFactory创建Connection
		Connection connection = factory.createConnection();
		// 3调用start()方法
		connection.start();
		// 4创建session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 5创建队列
		Topic topic = session.createTopic("topic");
		// 6通过session创建消息生产者
		MessageProducer producer = session.createProducer(topic);
		// 7通过session创建消息
		MapMessage msg = session.createMapMessage();
		msg.setString("name", "topic msg");
		msg.setInt("id",1);
		// 使用消息发送者发送消息
		producer.send(msg);
		
		producer.close();
		session.close();
		connection.close();

	}

}
