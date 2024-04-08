package com.crep.service.impl;

import com.crep.entity.Message;
import com.crep.mapper.MessageMapper;
import com.crep.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageMapper messageMapper;

    @Autowired
    public MessageServiceImpl(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @Override
    public Message getMessageById(Integer messageId) {
        return messageMapper.selectByPrimaryKey(messageId);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageMapper.selectAllMessages();
    }

    @Override
    @Transactional
    public boolean createMessage(Message message) {
        return messageMapper.insert(message) > 0;
    }

    @Override
    @Transactional
    public boolean updateMessage(Message message) {
        return messageMapper.updateByPrimaryKeySelective(message) > 0;
    }

    @Override
    @Transactional
    public boolean deleteMessage(Integer messageId) {
        return messageMapper.deleteByPrimaryKey(messageId) > 0;
    }
}