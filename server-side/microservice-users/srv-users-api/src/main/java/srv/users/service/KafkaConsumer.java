/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.users.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

/**
 * KafkaConsumer.
 *
 * @author waldemar
 */
@Service
public class KafkaConsumer {

    @KafkaListener(groupId = "group_id", topicPartitions = {@TopicPartition(topic = "helloKafka", partitions = {"0, 1"})})
    public void consume(String message) {
        System.out.println("Consumed message (partitions '0' or '1'): " + message);
    }
}