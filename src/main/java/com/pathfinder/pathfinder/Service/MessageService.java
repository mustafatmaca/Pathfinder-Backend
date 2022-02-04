package com.pathfinder.pathfinder.Service;

import com.pathfinder.pathfinder.Entity.Message;

import java.util.List;

public interface MessageService {
    Message saveMessage(Message message);
    Message findMessage(String messageId);
    List<Message> findMessagesBySender(String mail);
    List<Message> findMessagesByToUser(String mail);
    void deleteMessage(Message message);
}
