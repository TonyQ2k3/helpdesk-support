package com.tonyq.motionbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    private String id;
    private String title;
    private String body;
    private String priority;
    private String userEmail;

    public Ticket(String title, String body, String priority, String userEmail) {
        this.title = title;
        this.body = body;
        this.priority = priority;
        this.userEmail = userEmail;
    }
}
