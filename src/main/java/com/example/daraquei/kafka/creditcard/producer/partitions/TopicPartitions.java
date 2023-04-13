package com.example.daraquei.kafka.creditcard.producer.partitions;

import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.utils.Utils;

public class TopicPartitions implements Partitioner {

	@Override
	public void configure(Map<String, ?> configs) {
		
	}

	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		List<PartitionInfo> partitions= cluster.availablePartitionsForTopic(topic);
		System.out.println("Partition 123Number="+ Math.abs(Utils.murmur2(valueBytes) % partitions.size() -1));
		return Math.abs(Utils.murmur2(valueBytes) % partitions.size() -1);
	}

	@Override
	public void close() {		
	}

}
