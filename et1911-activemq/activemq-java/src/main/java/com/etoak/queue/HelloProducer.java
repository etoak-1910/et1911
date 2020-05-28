package com.etoak.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 创建生产者
 * @author 
 *
 */
public class HelloProducer {

	public static void main(String[] args) throws JMSException {
		
		//创建ConnectionFactory(用户名, 密码, 链接地址)
		ConnectionFactory factory = new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		
		//通过ConnectionFactory创建Connection
		Connection connection = factory.createConnection();
		//调用start()方法
		connection.start();
		//创建session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//通过session创建Destination(消费来源)
		Queue helloQueue = session.createQueue("hello");
		
		//通过session创建消息生产者
		MessageProducer producer = session.createProducer(helloQueue);
		
		//通过session创建消息
		TextMessage msg = session.createTextMessage("这是第一个Hello World");
		
		//使用消息发送者发送消息
		producer.send(msg);
		producer.close();
		session.close();
		connection.close();
		System.out.println("ok");
		
		
	}

}
