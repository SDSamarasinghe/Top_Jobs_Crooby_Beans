package com.example.topjobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class user_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        TextView signup1=findViewById(R.id.signup1);
       signup1.setOnClickListener(onclicksignup());
    }

    private View.OnClickListener onclicksignup(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(user_login.this,user_registration.class);
                user_login.this.startActivity(intent);

            }
        };
    }
}