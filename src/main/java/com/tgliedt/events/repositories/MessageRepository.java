package com.tgliedt.events.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tgliedt.events.models.Event;
import com.tgliedt.events.models.Message;



@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
	// Get all messages
	List<Message> findAll();
	
	// Get messages by event
	List<Message> findByEvent(Event event);
}