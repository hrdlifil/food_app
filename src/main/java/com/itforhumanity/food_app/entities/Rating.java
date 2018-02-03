package com.itforhumanity.food_app.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Rating implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long id;

    @ManyToOne
    private AppUser givesRating;

    @ManyToOne
    private AppUser getsRating;

    private int rating;

    @Lob
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getGivesRating() {
        return givesRating;
    }

    public void setGivesRating(AppUser givesRating) {
        this.givesRating = givesRating;
    }

    public AppUser getGetsRating() {
        return getsRating;
    }

    public void setGetsRating(AppUser getsRating) {
        this.getsRating = getsRating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
