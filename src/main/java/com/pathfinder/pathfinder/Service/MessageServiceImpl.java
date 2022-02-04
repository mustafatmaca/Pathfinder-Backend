package com.pathfinder.pathfinder.Service;

import com.pathfinder.pathfinder.Entity.Message;
import com.pathfinder.pathfinder.Repository.MessageRepository;
import com.pathfinder.pathfinder.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    MessageRepository messageRepository;
    UserRepository userRepository;

    public MessageServiceImpl(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
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
    public List<Message> findMessagesBySender(String mail) {
        var foundUser = userRepository.findByMail(mail);
        return messageRepository.findBySender(foundUser);
    }

    @Override
    public List<Message> findMessagesByToUser(String mail) {
        var foundUser = userRepository.findByMail(mail);
        return messageRepository.findByToUser(foundUser);
    }

    @Override
    public void deleteMessage(Message message) {
        messageRepository.delete(message);
    }
}
