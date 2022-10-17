package com.reto3.reto3g24.Repository;

import com.reto3.reto3g24.Entities.Gama;
import com.reto3.reto3g24.Entities.Message;
import com.reto3.reto3g24.Repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll() { return (List<Message>) messageCrudRepository.findAll(); }

    public Optional<Message> getMessage(int id) { return messageCrudRepository.findById(id); }
    public Message save(Message c) { return messageCrudRepository.save(c); }
    public void delete(Message c) { messageCrudRepository.delete(c); }
}
