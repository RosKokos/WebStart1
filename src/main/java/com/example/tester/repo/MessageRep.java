package com.example.tester.repo;

import com.example.tester.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MessageRep extends CrudRepository<Message, Integer>{

    List<Message> findByTag(String tag);
}
