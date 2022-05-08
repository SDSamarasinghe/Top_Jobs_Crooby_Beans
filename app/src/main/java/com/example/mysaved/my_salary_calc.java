package com.example.mysaved;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.widget.EditText;
import android.widget.Button;
public class my_salary_calc extends AppCompatActivity {
    TextView text_calc_user_name;
    FirebaseAuth fAuth;
    FirebaseUser user;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String userID;
    EditText ed1,ed2,ed3;
    Button btn1_btn,btn2_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_salary_calc);
        ed1 = findViewById(R.id.basic_sal);
        ed2 = findViewById(R.id.bonus_rate);
        ed3 = findViewById(R.id.net_sal);
        text_calc_user_name =findViewById(R.id.calc_user_name);
        btn1_btn = findViewById(R.id.btn_calc);
        btn2_btn= findViewById(R.id.btn_cl);

        btn2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed1.setText("");
                ed2.setText("");
                ed3.setText("");


            }
        });

        btn1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double salary = Double.parseDouble(ed1.getText().toString());
                double rate = Double.parseDouble(ed2.getText().toString());


               double bonus =(salary*rate)/100;
               double netsal=bonus+salary;
                ed3.setText(String.valueOf(netsal));
            }
        });

        fAuth = FirebaseAuth.getInstance();
        rootNode = FirebaseDatabase.getInstance();
        user = fAuth.getCurrentUser();

        //is user is not logged in, return to Login page
        if (fAuth.getCurrentUser() == null) {
            startActivity(new Intent(getApplicationContext(), UserloginActivity.class));
            finish();
        }

        userID = fAuth.getCurrentUser().getUid();
        FirebaseUser user = fAuth.getCurrentUser();


        reference = FirebaseDatabase.getInstance().getReference().child("user").child(userID);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //assign values to edit text fields
                text_calc_user_name.setText(snapshot.child("Name").getValue().toString());


            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }
}
