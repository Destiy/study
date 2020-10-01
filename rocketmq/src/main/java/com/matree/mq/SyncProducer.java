package com.matree.mq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author wy
 * @data 2020-08-15 22:19
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        // instantiate with a producer group name
        DefaultMQProducer producer =
                new DefaultMQProducer("firs_rocketMQ_test_product");
        producer.setNamesrvAddr("47.107.119.7:9876");
        // launch the instance
        producer.start();

        for (int i = 0; i < 5; i++) {
            Message message = new Message("TopicTest", "TagA", ("Hello RocketMQ" +
                    i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(message);
            System.out.printf("%s%n", sendResult);
        }
        // shut down
        producer.shutdown();
    }
}