package com.etoak.selector;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class SelectorConsumer {
	//手动创建选择器
	public static final String SELECTOR = "name = 'etoak' and age = 11";

	public static void main(String[] args) throws JMSException {
		
		ConnectionFactory factory = new ActiveMQConnectionFactory(null, null, "tcp://localhost:61616");
		
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Queue queue = session.createQueue("selector");
		//第二个参数传入选择器
		MessageConsumer consumer = session.createConsumer(queue,SELECTOR);
		//传入数据
		TextMessage msg = (TextMessage) consumer.receive();
		
		
		System.out.println(msg.getText().toString());
		
		//客户端签收消息 此时通知队列删除消息
		msg.acknowledge();
	}

}