package com.example.bit.passman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class Edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        EditText resource = findViewById(R.id.etResource);
        EditText login = findViewById(R.id.etLogin);
        EditText password = findViewById(R.id.etPassword);
        EditText comment = findViewById(R.id.etComment);

        Intent inCall = getIntent();

        String inRes = inCall.getStringExtra("res");
        String inLog = inCall.getStringExtra("log");
        String inPass = inCall.getStringExtra("pass");
        String inComm = inCall.getStringExtra("comm");

        resource.setText(inRes, TextView.BufferType.EDITABLE);
        login.setText(inLog, TextView.BufferType.EDITABLE);
        password.setText(inPass);
        comment.setText(inComm);
    }
}