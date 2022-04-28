package com.example.topjobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.topjobs.Database.DBHandler;

public class MainActivity extends AppCompatActivity {

    TextView user_name, user_contact, user_gender, user_district,user_email,user_dob,user_password;
    Button edit, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_name = findViewById(R.id.v_edit_name);
        user_contact = findViewById(R.id.v_edit_contact);
        user_gender = findViewById(R.id.v_edit_gender);
        user_district = findViewById(R.id.v_edit_destrict);
        user_email = findViewById(R.id.v_edit_email);
        user_dob = findViewById(R.id.v_edit_dob);
        user_password = findViewById(R.id.v_edit_Password);
        edit = findViewById(R.id.pr_edit_btn);
        delete = findViewById(R.id.pr_delete_btn);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),Edit_profile.class);
                startActivity(i);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                dbHandler.deleteInfo(user_name.getText().toString());

                Toast.makeText(MainActivity.this, "User deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void openSecond(View view){
        Intent intent = new Intent(this, Edit_profile.class);

        String u_name = user_name.getText().toString();
        String u_contact = user_contact.getText().toString();
        String u_gender = user_gender.getText().toString();
        String u_district = user_district.getText().toString();
        String u_email = user_email.getText().toString();
        String u_dob = user_dob.getText().toString();
        String u_password = user_password.getText().toString();

        intent.putExtra("n1",u_name);
        intent.putExtra("n2",u_contact);
        intent.putExtra("n3",u_gender);
        intent.putExtra("n4",u_district);
        intent.putExtra("n5",u_email);
        intent.putExtra("n6",u_dob);
        intent.putExtra("n7",u_password);

        startActivity(intent);



    }
}