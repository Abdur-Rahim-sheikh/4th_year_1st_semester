package com.example.sharingapp;

import android.graphics.Bitmap;

/**
 * ItemController is responsible for all communication between views and Item object
 */
public class ContactController {

    private Contact contact;

    public ContactController(Contact contact){
        this.contact = contact;
    }
    public String getId(){
        return contact.getId();
    }

    public void setId() {
        contact.setId();
    }
    public void getUsername() {
        return contact.username();
    }

    public void setUsername(String username) {
        return contact.setUsername();
    }

    public void getEmail() {
        return contact.email;
    }

    public void setEmail(String email) {
        return contact.setEmail();
    }
}


