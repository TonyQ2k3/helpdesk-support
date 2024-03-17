package com.tonyq.motionbackend.service;

import com.tonyq.motionbackend.model.Ticket;
import com.tonyq.motionbackend.repository.TicketRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepo;
    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

    public Optional<Ticket> getTicketById(String id) {
        return ticketRepo.findById(id);
    }

    public Optional<List<Ticket>> getTicketByUserEmail(String userEmail) {
        return ticketRepo.findByUserEmail(userEmail);
    }

    public Ticket newTicket(String title, String body, String priority, String userEmail) {
        Ticket ticket = new Ticket(title, body, priority, userEmail);
        ticketRepo.save(ticket);
        return ticket;
    }

    public String deleteTicket(String id) {
        ObjectId objId = new ObjectId(id);
        ticketRepo.deleteById(id);
        return "Deleted";
    }
}
