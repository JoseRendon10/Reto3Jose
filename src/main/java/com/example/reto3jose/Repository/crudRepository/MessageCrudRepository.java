package com.example.reto3jose.Repository.crudRepository;

import com.example.reto3jose.Entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
