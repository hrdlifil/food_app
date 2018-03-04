package com.itforhumanity.food_app.erors;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class RegistrationError {

    private boolean occured = false;

    private String message;

    public boolean isOccured() {
        return occured;
    }

    public void setOccured(boolean occured) {
        this.occured = occured;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
