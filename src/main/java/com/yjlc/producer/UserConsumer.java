//package com.yjlc.producer;
//
///**
// * Created by Liuziyuan on 2019/9/21.
// */
//import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
//import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
//import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
//import org.apache.rocketmq.common.message.MessageExt;
//import org.apache.rocketmq.remoting.common.RemotingHelper;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
///**
// * @Author 18011618
// * @Date 10:31 2018/7/18
// * @Function 模拟用户消息消费
// */
//@Component
//public class UserConsumer {
//    /**
//     * 消费者的组名
//     */
////    @Value("${suning.rocketmq.conumerGroup}")
//    private String consumerGroup;
//
//    /**
//     * NameServer 地址
//     */
////    @Value("${suning.rocketmq.namesrvaddr}")
//    private String namesrvAddr;
//
//    @PostConstruct
//    public void consumer() {
//        System.err.println("init defaultMQPushConsumer");
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
//        consumer.setNamesrvAddr(namesrvAddr);
//        try {
//            consumer.subscribe("user-topic", "user-tag");
//            consumer.registerMessageListener((MessageListenerConcurrently) (list, context) -> {
//                try {
//                    for (MessageExt messageExt : list) {
//
//                        System.err.println("消费消息: " + new String(messageExt.getBody()));//输出消息内容
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    return ConsumeConcurrentlyStatus.RECONSUME_LATER; //稍后再试
//                }
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS; //消费成功
//            });
//            consumer.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}
