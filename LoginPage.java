package com.example.chetna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {
    Button bt1, bt2, bt3;
    EditText et1, et2;
    TextView LinkTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        bt1 =(Button) findViewById(R.id.forgot_password);
        bt2 =(Button) findViewById(R.id.login);
        bt3 =(Button) findViewById(R.id.signup);

        LinkTextView = (TextView)findViewById(R.id.textView);

        et1 = (EditText) findViewById(R.id.User_Name);
        et2 = (EditText) findViewById(R.id.User_Password);

        LinkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(LoginPage.this, Admin_Page.class);
                startActivity(i1);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(LoginPage.this,Home_Page.class);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this, SignPage.class));
                finish();
            }
        });
    }

}