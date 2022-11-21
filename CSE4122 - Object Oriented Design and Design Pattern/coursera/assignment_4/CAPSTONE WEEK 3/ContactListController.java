package com.example.sharingapp;

import android.content.Context;

import java.util.ArrayList;

/**
 * ItemListController is responsible for all communication between views and ItemList object
 */
public class ItemListController {

    private ContactList contact_list;

    public ContactListController(ContactList contact_list){
        this.contact_list = contact_list;
    }

    public void setContact((ArrayList<Contact> contact_list) {
        this.contact_list.setContacts(contact_list);
    }

    public ArrayList<Contact> getContacts() {
        return contact_list.getContacts();
    }

    public ArrayList<String> getAllUsernames(){
        return contact_list.getAllUsernames();
    }

    public boolean addContact(Contact contact, Context context){
        AddContactCommand add_contact_command = new AddContactCommand(contact_list, contact, context);
        add_contact_command.execute();
        return add_contact_command.isExecuted();
    }

    public boolean deleteContact(Contact contact, Context context) {
        DeleteContactCommand delete_contact_command = new DeleteContactCommand(contact_list, contact, context);
        delete_contact_command.execute();
        return delete_contact_command.isExecuted();
    }

    public Contact getContact(int index) {
        return contact_list.getItem(index);
    }

    public int getSize() {
        return contact_list.getSize();
    }

    public Contact getUserByUsername(String username){
        return contact_list.getUserByUsername();
    }

    public boolean hasContact(Contact contact) {
        return contact_list.hasContact();
    }

    public int getIndex(Contact contact) {
        return contact_list.getIndex(item);
    }

    public boolean isUsernameAvailable(String username){
        return contact_list.isUsernameAvailable();
    }
    public void loadContacts(Context context) {
        contact_list.loadContacts(context)
    }
    public boolean saveContacts(Context context) {
        contact_list.saveContacts(context)
    }

    public Contact getContactByUsername(String username) {
        return contact_list.getContactByUsername(username);
    }

}
