package com.pathfinder.pathfinder.Service;

import com.pathfinder.pathfinder.Entity.Message;
import com.pathfinder.pathfinder.Repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message findMessage(String messageId) {
        return messageRepository.findById(messageId).get();
    }

    @Override
    public void deleteMessage(Message message) {
        messageRepository.delete(message);
    }
}
