package com.itforhumanity.food_app.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String messageText;

    private java.sql.Timestamp timeOfSent;

    @ManyToOne
    private AppUser sender;

    @ManyToOne
    private AppUser reciever;

    private Boolean seen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Timestamp getTimeOfSent() {
        return timeOfSent;
    }

    public void setTimeOfSent(Timestamp timeOfSent) {
        this.timeOfSent = timeOfSent;
    }

    public AppUser getSender() {
        return sender;
    }

    public void setSender(AppUser sender) {
        this.sender = sender;
    }

    public AppUser getReciever() {
        return reciever;
    }

    public void setReciever(AppUser reciever) {
        this.reciever = reciever;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }
}