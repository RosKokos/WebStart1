package com.example.tester.repo;

import com.example.tester.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRep extends CrudRepository<Message, Integer>{

    List<Message> findByTag(String tag);
}
