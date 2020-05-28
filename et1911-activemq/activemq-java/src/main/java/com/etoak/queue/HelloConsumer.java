package com.etoak.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 创建消费者
 * 
 * @author
 *
 */
public class HelloConsumer {

	public static void main(String[] args) throws JMSException {

		// 创建ConnectionFactory(用户名, 密码, 链接地址)
		ConnectionFactory factory = new ActiveMQConnectionFactory(null, null, "tcp://localhost:61616");

		// 通过ConnectionFactory创建Connection
		Connection connection = factory.createConnection();
		// 调用start()方法
		connection.start();
		// 创建session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 通过session创建Destination(消费来源)
		Queue helloQueue = session.createQueue("hello");

		// 创建消费者
		MessageConsumer consumer = session.createConsumer(helloQueue);

		// 消费消息
		TextMessage text = (TextMessage) consumer.receive();
		System.out.println(text.getText().toString());
		consumer.close();
		session.close();
		connection.close();

	}

}
