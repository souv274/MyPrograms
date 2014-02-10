import java.util.Hashtable;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

    
public class JMSTestMessageSender {

    public void send() 
    {
          Context context = null;
          Connection connection = null;
          MessageProducer sender = null;
          MessageConsumer consumer = null;
          
          try {
             context = new InitialContext();
             //ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
             
             Properties properties = new Properties();
             properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
             properties.put(Context.URL_PKG_PREFIXES, "org.jnp.interfaces");
             properties.put(Context.PROVIDER_URL, "jnp://192.168.131.129:1299");
             InitialContext jndiContext = new InitialContext(properties);

             //[2] Look up connection factory and queue.
             ConnectionFactory factory = (ConnectionFactory)jndiContext.lookup("UIL2XAConnectionFactory");
            
             
             connection = factory.createConnection();
             connection.start();
             
             Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
             Destination destination = (Destination) context.lookup("topic1");
             sender = session.createProducer(destination);
             sender.send(session.createTextMessage("Hello World!"));
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
             try {
                if (sender != null) sender.close();
                if (connection != null) connection.close();
                if (context != null) context.close();
             } catch (Exception e) {
        	 e.printStackTrace();
        	 
             }
          }
    }
    
    public void receive() 
    {
	Context context = null;
	      Connection connection = null;
	      MessageConsumer receiver = null;
	      try {
	         context = new InitialContext();
	         ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
	         connection = factory.createConnection();
	         Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	         Destination destination = (Destination) context.lookup("topic1");

	         receiver = session.createConsumer(destination);
	         receiver.setMessageListener(new MessageListener() {
	            public void onMessage(Message message) {
	               TextMessage text = (TextMessage) message;
	               try {
	                  System.out.println("Received message: " + text.getText());
	               } catch (JMSException e) {
	               }
	            }
	         });

	         connection.start();
	      } catch (Exception e) {
	      }
    }

    public static void main(String[] args) {
	JMSTestMessageSender jmsSender = new JMSTestMessageSender();
	System.out.println("Sending mesages : ");
        jmsSender.send();
        System.out.println("Reeiving messages");
        jmsSender.receive();
    }
}