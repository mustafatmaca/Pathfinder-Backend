package com.pathfinder.pathfinder.Service;

import com.pathfinder.pathfinder.Entity.Message;

public interface MessageService {
    Message saveMessage(Message message);
    Message findMessage(String messageId);
    void deleteMessage(Message message);
}
