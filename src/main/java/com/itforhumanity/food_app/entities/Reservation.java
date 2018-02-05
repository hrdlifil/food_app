package com.itforhumanity.food_app.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    private java.sql.Timestamp currentTimestampSold;

    @Column(name = "reservation_expiration")
    private java.sql.Timestamp currentTimestampExpiration;

    @OneToOne
    private Offer offer;

    @ManyToOne
    private AppUser user_reservation;

    private boolean rightToRate = false;

    private boolean reservationValid = true;

    private boolean everythingOk = false;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Timestamp getCurrentTimestampSold() {
        return currentTimestampSold;
    }

    public void setCurrentTimestampSold(Timestamp currentTimestampSold) {
        this.currentTimestampSold = currentTimestampSold;
    }

    public Timestamp getCurrentTimestampExpiration() {
        return currentTimestampExpiration;
    }

    public void setCurrentTimestampExpiration(Timestamp currentTimestampExpiration) {
        this.currentTimestampExpiration = currentTimestampExpiration;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public AppUser getUser_reservation() {
        return user_reservation;
    }

    public void setUser_reservation(AppUser user_reservation) {
        this.user_reservation = user_reservation;
    }

    public boolean isRightToRate() {
        return rightToRate;
    }

    public void setRightToRate(boolean rightToRate) {
        this.rightToRate = rightToRate;
    }

    public boolean isReservationValid() {
        return reservationValid;
    }

    public void setReservationValid(boolean reservationValid) {
        this.reservationValid = reservationValid;
    }

    public boolean isEverythingOk() {
        return everythingOk;
    }

    public void setEverythingOk(boolean everythingOk) {
        this.everythingOk = everythingOk;
    }
}