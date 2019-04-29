import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.xml.soap.Text;
import java.io.IOException;

/**
 * @创建人 anjie
 * @创建时间 2019/4/28
 * @描述
 */
public class QueueConsumer {
    public static void main(String[] args) throws JMSException, IOException {
        //1.创建连接工厂
        ConnectionFactory factory=new ActiveMQConnectionFactory("tcp://47.98.132.196:61616");
        //2.获取连接
        Connection connection = factory.createConnection();
        //3.启动连接
        connection.start();
        //4.获取session（参数1：是否启动事务；参数2：消息确认模式）
        Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建队列队形
        Queue queue=session.createQueue("test_queue");
        //6.创建消息消费者
        MessageConsumer consumer=session.createConsumer(queue);
        //7.监听消息
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                System.out.println("接受到消息："+textMessage);
            }
        });
        //8.等待键盘输入
        System.in.read();
        //9.关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
