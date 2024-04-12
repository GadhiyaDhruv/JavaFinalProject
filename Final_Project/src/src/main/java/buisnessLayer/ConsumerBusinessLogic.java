package buisnessLayer;

import java.util.ArrayList;
import java.util.List;

import transferObject.ConsumerDTO;

public class ConsumerBusinessLogic {

    private List<ConsumerDTO> consumers;

    public ConsumerBusinessLogic() {
        consumers = new ArrayList<>();
    }

    public ConsumerDTO getConsumerById(int userId) {
        for (ConsumerDTO consumer : consumers) {
            if (consumer.getUserId() == userId) {
                return consumer;
            }
        }
        return null;
    }

    public List<ConsumerDTO> getAllConsumers() {
        return consumers;
    }

    public void addConsumer(ConsumerDTO consumer) {
        consumers.add(consumer);
    }

    public void updateConsumer(ConsumerDTO updatedConsumer) {
        for (int i = 0; i < consumers.size(); i++) {
            ConsumerDTO consumer = consumers.get(i);
            if (consumer.getUserId() == updatedConsumer.getUserId()) {
                consumers.set(i, updatedConsumer);
                return;
            }
        }
    }

    public void deleteConsumer(int userId) {
        consumers.removeIf(consumer -> consumer.getUserId() == userId);
    }
}
