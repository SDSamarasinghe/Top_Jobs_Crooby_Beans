package com.example.topjobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Edit_profile extends AppCompatActivity {

    EditText user_name, user_contact ,user_email,user_password;
    Spinner user_district,user_gender;
    Button update;

    String ed_u_name, ed_u_contact, ed_u_email, ed_u_password, ed_u_gender, ed_u_district;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        user_name = findViewById(R.id.v_edit_name);
        user_contact = findViewById(R.id.v_edit_contact);
        user_gender = findViewById(R.id.v_edit_gender);
        user_district = findViewById(R.id.v_edit_district);
        user_email = findViewById(R.id.v_edit_email);
        user_password = findViewById(R.id.v_edit_password);

        update = findViewById(R.id.pr_update_btn);


        Intent intent = getIntent();
        ed_u_name = intent.getStringExtra("n1");
        ed_u_contact = intent.getStringExtra("n2");
        ed_u_email = intent.getStringExtra("n3");
        ed_u_password = intent.getStringExtra("n4");
        ed_u_gender = intent.getStringExtra("n5");
        ed_u_district = intent.getStringExtra("n6");


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}