package com.pathfinder.pathfinder.Service;

import com.pathfinder.pathfinder.Entity.Message;

import java.util.List;

public interface MessageService {
    Message saveMessage(Message message);
    Message findMessage(String messageId);
    List<Message> getAllMessages();
    List<Message> findMessagesBySender(String mail);
    List<Message> findMessagesByToUser(String mail);
    List<Message> findMessagesByToUserOrSender(String mail);
    void deleteMessage(Message message);
}
