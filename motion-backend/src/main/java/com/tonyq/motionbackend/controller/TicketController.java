package com.tonyq.motionbackend.controller;

import com.tonyq.motionbackend.model.Ticket;
import com.tonyq.motionbackend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return new ResponseEntity<List<Ticket>>(ticketService.getAllTickets(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Optional<Ticket>> getTicketById(@PathVariable String id) {
        return new ResponseEntity<>(ticketService.getTicketById(id), HttpStatus.OK);
    }

    @GetMapping("/email/{userEmail}")
    @CrossOrigin
    public ResponseEntity<Optional<List<Ticket>>> getTicketByEmail(@PathVariable String userEmail) {
        return new ResponseEntity<>(ticketService.getTicketByUserEmail(userEmail), HttpStatus.OK);
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Ticket> newTicket(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(ticketService.newTicket(payload.get("title"), payload.get("body"), payload.get("priority"), payload.get("userEmail")), HttpStatus.CREATED);
    }

    @DeleteMapping
    @CrossOrigin
    public ResponseEntity<String> deleteTicket(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(ticketService.deleteTicket(payload.get("id")), HttpStatus.OK);
    }
}
