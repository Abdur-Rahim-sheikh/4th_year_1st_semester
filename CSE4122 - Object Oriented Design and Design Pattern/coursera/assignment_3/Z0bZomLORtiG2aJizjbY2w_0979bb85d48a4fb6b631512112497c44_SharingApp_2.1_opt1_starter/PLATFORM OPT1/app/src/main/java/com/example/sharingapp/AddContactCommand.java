package com.example.sharingapp;

import android.content.Context;

public class AddContactCommand extends Command{
    private Contact contact;
    private ContactList contactList;
    private Context context;
    public AddContactCommand(ContactList contactList,Contact contact,Context context){
        this.contact = contact;
        this.contactList = contactList;
        this.context = context;
    }
    @Override
    public void execute() {
        contactList.addContact(contact);
        setIsExecuted(contactList.saveContacts(context));
    }
}
