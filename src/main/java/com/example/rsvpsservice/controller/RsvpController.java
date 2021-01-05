package com.example.rsvpsservice.controller;

import com.example.rsvpsservice.dao.Rsvpdao;
import com.example.rsvpsservice.model.Rsvp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RsvpController {

    @Autowired
    Rsvpdao dao;

    public RsvpController(Rsvpdao dao) {
        this.dao = dao;
    }

    @CachePut(key = "#result.getId()")
    @RequestMapping(value = "/rsvps", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Rsvp createRsvp(@RequestBody Rsvp rsvp) {
        System.out.println("CREATING RSVP");
        return dao.addRsvp(rsvp);
    }

    @Cacheable
    @RequestMapping(value = "/rsvps/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Rsvp getRsvp(@PathVariable int id) {
        System.out.println("GETTING RSVP ID = " + id);
        return dao.getRsvp(id);
    }

    @RequestMapping(value = "/rsvps", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Rsvp> getAllRsvps() {
        System.out.println("GETTING ALL RSVPS");
        return dao.getAllRsvps();
    }

    @CacheEvict(key = "#rsvp.getId()")
    @RequestMapping(value = "/rsvps", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateRsvp(@RequestBody Rsvp rsvp) {
        System.out.println("UPDATING RSVP ID = " + rsvp.getRsvp_id());
        dao.updateRsvp(rsvp);
    }

    @CacheEvict
    @RequestMapping(value = "/rsvps/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteRsvp(@PathVariable int id) {
        System.out.println("DELETING RSVP ID = " + id   );
        dao.deleteRsvp(id);
    }
}
