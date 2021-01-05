package com.example.rsvpsservice.model;

import java.io.Serializable;
import java.util.Objects;

public class Rsvp implements Serializable {
    private int rsvp_id;
    private String guestName;
    private int totalAttending;

    public Rsvp() {

    }

    public Rsvp(String guestName, int totalAttending) {
        this.guestName = guestName;
        this.totalAttending = totalAttending;
    }

    public int getRsvp_id() {
        return rsvp_id;
    }

    public void setRsvp_id(int rsvp_id) {
        this.rsvp_id = rsvp_id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getTotalAttending() {
        return totalAttending;
    }

    public void setTotalAttending(int totalAttending) {
        this.totalAttending = totalAttending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rsvp)) return false;
        Rsvp rsvp = (Rsvp) o;
        return getRsvp_id() == rsvp.getRsvp_id() &&
                getTotalAttending() == rsvp.getTotalAttending() &&
                Objects.equals(getGuestName(), rsvp.getGuestName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRsvp_id(), getGuestName(), getTotalAttending());
    }

    @Override
    public String toString() {
        return "Rsvp{" +
                "rsvp_id=" + rsvp_id +
                ", guestName='" + guestName + '\'' +
                ", totalAttending=" + totalAttending +
                '}';
    }
}
