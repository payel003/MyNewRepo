package com.market.project.ws.order.jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.NamingException;

import org.apache.activemq.spring.ActiveMQConnectionFactory;

import com.google.gson.Gson;
import com.market.project.ws.order.entity.Order;
import com.market.project.ws.order.service.OrderService;

public class JmsImpl {
	private static String subject = "VALLYSOFTQ";
	private static String ack = "Topu";
	private OrderService orderService;
	Destination d;
    static Context context;
    static TopicConnection topicConnection;
    Topic topic;
    TopicPublisher tpub;
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public JmsImpl() throws JMSException, NamingException {

		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

		connectionFactory.setBrokerURL("tcp://localhost:61616");

		Connection connection = connectionFactory.createConnection();

		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageConsumer consumer = session.createConsumer(session.createQueue(subject));
		//MessageConsumer consumer = session.createConsumer(session.createQueue("Testqueue"));

		// MessageConsumer consumer =
		// session.createConsumer(session.createTopic("Testtopic"));
		
		//d=session.createTopic(ack);
//		TopicSession tpsession = topicConnection.createTopicSession(true, Session.AUTO_ACKNOWLEDGE);
//        topic = (Topic) context.lookup(ack);
//        tpub=tpsession.createPublisher(topic); 

      

		consumer.setMessageListener(new HelloMessageListener());

	}

	private class HelloMessageListener implements MessageListener {

		@Override

		public void onMessage(Message message) {

			try {
                String type=message.getJMSType();
				TextMessage textMessage = (TextMessage) message;
                
				System.out.println(
						"Consumer " + Thread.currentThread().getName() + " received message: " + textMessage.getText());
				Gson gson = new Gson();
				String jsonString = textMessage.getText();
				Order order = gson.fromJson(jsonString, Order.class);
				if(type.equals("create"))
				orderService.create(order);
				if(type.equals("update"))
				orderService.update(order.getId(), order.getStatus());
//				tpub.publish(message);
				System.out.println("Git Add");

			} catch (JMSException e) {

				e.printStackTrace();

			}

		}

	}

}
