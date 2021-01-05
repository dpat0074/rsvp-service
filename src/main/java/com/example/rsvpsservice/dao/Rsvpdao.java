package com.example.rsvpsservice.dao;

import com.example.rsvpsservice.model.Rsvp;

import java.util.List;

public interface Rsvpdao {
    public Rsvp addRsvp(Rsvp rsvp);

    public Rsvp getRsvp(int id);

    public List<Rsvp> getAllRsvps();

    public void updateRsvp(Rsvp rsvp);

    public void deleteRsvp(int id);
}
