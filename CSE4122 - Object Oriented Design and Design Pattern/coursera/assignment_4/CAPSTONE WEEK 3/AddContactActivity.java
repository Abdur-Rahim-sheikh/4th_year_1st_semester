package com.example.sharingapp;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Add a new contact
 */

public class AddContactActivity extends AppCompatActivity {

    private ContactList contact_list = new ContactList();
    private Context context;

    private EditText username;
    private EditText email;
    private ContactListController contact_list_controller = new ContactListController(item_list)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);

        context = getApplicationContext();
        contact_list_controller.loadContacts(context);
    }

    public void saveContact(View view) {

        String username_str = username.getText().toString();
        String email_str = email.getText().toString();

        if (username_str.equals("")) {
            username.setError("Empty field!");
            return;
        }

        if (email_str.equals("")) {
            email.setError("Empty field!");
            return;
        }

        if (!email_str.contains("@")){
            email.setError("Must be an email address!");
            return;
        }

        for (Contact c : contact_list.getContacts()) {
            if (c.getUsername().equals(username_str)) {
                username.setError("Username already taken!");
                return;
            }
        }

        Contact contact = new Contact(username_str, email_str, null);

        // Add Contact
        boolean success = contact_list_controller.addContact(contact, context);
        if (!success) {
            return;
        }

        boolean success = add_contact_command.isExecuted();
        if (!success) {
            return;
        }

        // End AddContactActivity
        finish();
    }
}
