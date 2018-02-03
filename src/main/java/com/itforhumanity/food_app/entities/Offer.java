package com.itforhumanity.food_app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class Offer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    private java.sql.Timestamp expirationTimestamp;

    private java.sql.Timestamp createdTimestamp;

    @ManyToOne
    @JoinColumn(name = "Product_Id_FK")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "User_Id_FK")
    private AppUser user_offer;

    @OneToOne(cascade = CascadeType.ALL)
    private Reservation reservation;

    private String info;

    private double priceBefore;

    private double actualPrice;

    private boolean reserved = false;

    private boolean valid = true;

    private boolean sold = false;

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public Timestamp getExpirationTimestamp() {
        return expirationTimestamp;
    }

    public void setExpirationTimestamp(Timestamp expirationTimestamp) {
        this.expirationTimestamp = expirationTimestamp;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public AppUser getUser_offer() {
        return user_offer;
    }

    public void setUser_offer(AppUser user_offer) {
        this.user_offer = user_offer;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getPriceBefore() {
        return priceBefore;
    }

    public void setPriceBefore(double priceBefore) {
        this.priceBefore = priceBefore;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
}
