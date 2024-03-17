package com.tonyq.motionbackend.repository;

import com.tonyq.motionbackend.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends MongoRepository<Ticket, String> {
    // The name of the methods automatically decides what they do, findByX will query database by field X
    Optional<List<Ticket>> findByUserEmail(String userEmail);
}
