package com.reto3.reto3g24.Repository.crudRepository;

import com.reto3.reto3g24.Entities.Gama;
import com.reto3.reto3g24.Entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
