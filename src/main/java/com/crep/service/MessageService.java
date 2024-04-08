package com.crep.service;

import com.crep.entity.Message;
import java.util.List;

public interface MessageService {
    Message getMessageById(Integer messageId);
    List<Message> getAllMessages();
    boolean createMessage(Message message);
    boolean updateMessage(Message message);
    boolean deleteMessage(Integer messageId);
}