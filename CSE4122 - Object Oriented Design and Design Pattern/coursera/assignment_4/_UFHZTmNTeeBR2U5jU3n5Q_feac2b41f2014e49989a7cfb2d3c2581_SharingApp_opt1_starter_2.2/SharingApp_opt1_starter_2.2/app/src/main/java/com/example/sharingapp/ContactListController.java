package com.example.sharingapp;

import android.content.Context;

import java.util.ArrayList;

public class ContactListController {
    private ContactList contactList;

    public ContactListController(ContactList contactList) {
        this.contactList = contactList;
    }

    public void setContacts(ArrayList<Contact> contact_list) {

        contactList.setContacts(contact_list);
    }

    public ArrayList<Contact> getContacts() {
        return contactList.getContacts();
    }

    public boolean addContact(Contact contact, Context context) {
        AddContactCommand add_contact_command = new AddContactCommand(contactList, contact, context);
        add_contact_command.execute();
        return add_contact_command.isExecuted();
    }

    public boolean deleteContact(Contact Contact, Context context) {
        DeleteContactCommand delete_Contact_command = new DeleteContactCommand(contactList, Contact, context);
        delete_Contact_command.execute();
        return delete_Contact_command.isExecuted();
    }

    public boolean editContact(Contact contact, Contact updated_contact, Context context){
        EditContactCommand edit_contact_command = new EditContactCommand(contactList, contact, updated_contact, context);
        edit_contact_command.execute();
        return edit_contact_command.isExecuted();
    }

    public void loadContacts(Context context) {
        contactList.loadContacts(context);
    }

    public boolean hasContact(Contact contact) {
        return contactList.hasContact(contact);
    }

    public int getIndex(Contact contact) {
        return contactList.getIndex(contact);
    }

    public ArrayList<String> getAllUsernames() {
        return contactList.getAllUsernames();
    }

    public void addObserver(Observer observer) {
        contactList.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        contactList.removeObserver(observer);
    }

    public Contact getContactByUsername(String username) {
        return contactList.getContactByUsername(username);
    }

    public Contact getContact(int index) {
        return contactList.getContact(index);
    }

    public boolean isUsernameAvailable(String username) {
        return contactList.isUsernameAvailable(username);
    }

}
