package com.example.topjobs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.topjobs.Database.DBHandler;

public class Create_Job extends AppCompatActivity {

    EditText edt_com_name, edt_com_title, edt_com_salary, edt_com_description, edt_com_email, edt_com_phone;
    Button btn_job_cr;
    Spinner spinner;

    DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_job);

        edt_com_name = findViewById(R.id.Ed_creComName);
        edt_com_title = findViewById(R.id.Ed_creTitle);
        edt_com_salary = findViewById(R.id.Ed_creSalary);
        edt_com_description = findViewById(R.id.Ed_creDesc);
        edt_com_email = findViewById(R.id.Ed_creEmail);
        edt_com_phone = findViewById(R.id.Ed_crePhone);
        spinner = findViewById(R.id.et_dis);
        btn_job_cr = findViewById(R.id.btn_job_create);

        dbHandler = new DBHandler(this);

        String[] spinnerList = new String[]{"dis1", "dis2", "dis3", "dis4", "dis5", "dis6", "dis7", "dis8", "dis9", "dis10"};

        //Initialize ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this
        , android.R.layout.simple_spinner_item,spinnerList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                //If select district
                if (position == 0){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        }
    }
