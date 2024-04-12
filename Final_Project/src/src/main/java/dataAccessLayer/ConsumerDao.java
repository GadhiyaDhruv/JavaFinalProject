package dataAccessLayer;

import java.util.List;
import transferObject.ConsumerDTO;

public interface ConsumerDao {
    List<ConsumerDTO> getAllConsumers();
    ConsumerDTO getConsumerById(int consumerId);
    void addConsumer(ConsumerDTO consumer);
    void updateConsumer(ConsumerDTO consumer);
    void deleteConsumer(int consumerId);
}
