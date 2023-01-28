package com.example.chetna;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SignPage extends AppCompatActivity {
    EditText date_birth,fname,lname,email,pass,conpass;
    Spinner gender;
    Button reg;
    DatePickerDialog picker;

    DatabaseReference studentInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);
        //Names,Emails and Password
        fname=(EditText)findViewById(R.id.firstname);
        lname =(EditText)findViewById(R.id.lastname);
        email = (EditText)findViewById(R.id.editTextTextEmailAddress);
        pass = (EditText)findViewById(R.id.editTextTextPassword);
        conpass = (EditText)findViewById(R.id.editTextTextPassword1);
        reg = (Button)findViewById(R.id.button);
        gender = (Spinner)findViewById(R.id.spinner);
        date_birth = (EditText)findViewById(R.id.dob);

        //Date of Birth
        date_birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar myCalender = Calendar.getInstance();
                int day = myCalender.get(Calendar.DAY_OF_MONTH);
                int month = myCalender.get(Calendar.MONTH);
                int year = myCalender.get(Calendar.YEAR);

                //Data Picker Dialog
                picker = new DatePickerDialog(SignPage.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        date_birth.setText(i2 + "/" + (i1 + 1) + "/" + i);
                    }
                }, year, month, day);
                picker.show();
            }
        });
        //Student Information
        studentInfo = FirebaseDatabase.getInstance().getReference().child("Students");

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstnm=fname.getText().toString();
                String lastnm=lname.getText().toString();
                String bd = date_birth.getText().toString();
                String emailadd =email.getText().toString();
                String gen = gender.getSelectedItem().toString();
                String password = pass.getText().toString();
                String confirmpassword = conpass.getText().toString();

                //Toast messages


                Students students = new Students(firstnm,lastnm,bd, gen, emailadd,password,confirmpassword);
                studentInfo.push().setValue(students);
                Toast.makeText(SignPage.this,"Data Registered Successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }
}