package com.example.reto3jose.Service;

import com.example.reto3jose.Entities.Message;
import com.example.reto3jose.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() { return messageRepository.getAll(); }
    public Optional<Message> getMessage(int id) { return messageRepository.getMessage(id); }
    public Message save(Message message){
        if(message.getIdMessage() == null){
            return messageRepository.save(message);
        }else{
            Optional<Message> message1 = messageRepository.getMessage(message.getIdMessage());
            if(message1.isPresent()){
                return message;
            }else{
                return messageRepository.save(message);
            }
        }
    }
    public Message update(Message message){
        if(message.getIdMessage()!=null) {
            Optional<Message> q = messageRepository.getMessage(message.getIdMessage());
            if (q.isPresent()) {
                if (message.getMessageText() != null) {
                    q.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(q.get());
                return q.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    public boolean delete(int id){
        boolean d = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return d;
    }
}
