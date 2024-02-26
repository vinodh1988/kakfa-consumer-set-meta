package com.kafkaapps.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

import com.kafkaapps.entities.Task;

@Service
public class KafkaConsumerServices {
	
	@KafkaListener(topics = {"tasks"},groupId="task-reader-group",
			topicPartitions =@TopicPartition(topic = "tasks",partitions = {"0"}))
	public void readData(Task task,ConsumerRecord<String, Task> cr) {
		System.out.println(task);
		System.out.println("Key is "+cr.key()+ "Offset is"+cr.offset()+ "Partition is"+cr.partition());
		FileAppender.appendData("/Users/vinodh/projects/project1.txt", task.toString());
		
	}
	
	@KafkaListener(topics = {"tasks"},groupId="task-reader-group",
			topicPartitions =@TopicPartition(topic = "tasks",partitions = {"1"}))
	public void readData2(Task task,MessageHeaders headers) {
		System.out.println(headers);
		System.out.println(task);
		FileAppender.appendData("/Users/vinodh/projects/project2.txt", task.toString());
		
	}
	
	@KafkaListener(topics = {"tasks"},groupId="task-reader-group",
			topicPartitions =@TopicPartition(topic = "tasks",partitions = {"2"}))
	public void readData3(Task task) {
		System.out.println(task);
		FileAppender.appendData("/Users/vinodh/projects/project3.txt", task.toString());
		
	}

}
