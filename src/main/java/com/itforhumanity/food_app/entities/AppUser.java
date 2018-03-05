package com.itforhumanity.food_app.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class AppUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id_PK")
    private Long userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address_FK")
    private Address a;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "givesRating")
    private Set<Rating> ratingsGiven;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "getsRating")
    private Set<Rating> ratingsGotten;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user_offer")
    private Set<Offer> offers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sender")
    private Set<Message> messagesThatISent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reciever")
    private Set<Message> messagesSentToMe;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user_reservation")
    private Set<Reservation> reservations;

    private String login;

    private String password;

    private String name;

    private String surname;

    private String email;

    private int phone;

    private boolean seller;

    @Lob
    private byte[] photo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "User_Id_PK"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "Role_Id_PK"))
    private List<Role> roles;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Address getA() {
        return a;
    }

    public void setA(Address a) {
        this.a = a;
    }

    public Set<Rating> getRatingsGiven() {
        return ratingsGiven;
    }

    public void setRatingsGiven(Set<Rating> ratingsGiven) {
        this.ratingsGiven = ratingsGiven;
    }

    public Set<Rating> getRatingsGotten() {
        return ratingsGotten;
    }

    public void setRatingsGotten(Set<Rating> ratingsGotten) {
        this.ratingsGotten = ratingsGotten;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public Set<Message> getMessagesThatISent() {
        return messagesThatISent;
    }

    public void setMessagesThatISent(Set<Message> messagesThatISent) {
        this.messagesThatISent = messagesThatISent;
    }

    public Set<Message> getMessagesSentToMe() {
        return messagesSentToMe;
    }

    public void setMessagesSentToMe(Set<Message> messagesSentToMe) {
        this.messagesSentToMe = messagesSentToMe;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public boolean isSeller() {
        return seller;
    }

    public void setSeller(boolean seller) {
        this.seller = seller;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}