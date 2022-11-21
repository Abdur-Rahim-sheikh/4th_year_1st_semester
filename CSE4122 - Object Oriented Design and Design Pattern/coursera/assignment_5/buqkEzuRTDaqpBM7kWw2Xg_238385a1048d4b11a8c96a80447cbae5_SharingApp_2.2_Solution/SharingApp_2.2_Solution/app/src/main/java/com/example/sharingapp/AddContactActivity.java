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
    private ContactListController contact_list_controller = new ContactListController(contact_list);

    private Context context;

    private EditText username;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);

        context = getApplicationContext();
        contact_list_controller.loadContacts(context);
    }

    private boolean validateInput(EditText input,String type){
        String name = input.getText().toString();
        boolean status=name.equals("");
        if(status==false){
            input.setError("Empty field!");
            return false;
        }
        else if(type.equalsIgnoreCase("email") && (!name.contains("@"))){
            input.setError("Must be an email address!");
            return false;
        }
        return true;
    }
    public void saveContact(View view) {

        String username_str = username.getText().toString();
        String email_str = email.getText().toString();

        if (!validateInput(username,"username")
                || !validateInput(email,"email")){
            return;
        }

        if (!contact_list_controller.isUsernameAvailable(username_str)){
            username.setError("Username already taken!");
            return;
        }

        Contact contact = new Contact(username_str, email_str, null);

        // Add contact
        boolean success = contact_list_controller.addContact(contact, context);
        if (!success) {
            return;
        }

        // End AddContactActivity
        finish();
    }
}
