package com.example.sharingapp;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

// Add a new contact
public class AddContactActivity extends AppCompatActivity {

    private ContactList contact_list = new ContactList();
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
        contact_list.loadContacts(context);
    }