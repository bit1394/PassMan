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
       // TextView tv = (TextView) findViewById(R.id.textView4);

        String inRes = inCall.getStringExtra("res");
/*
        String inLog = inCall.getStringExtra("id_");

        String inPassw = inCall.getStringExtra("password");
        String inComm = inCall.getStringExtra("comment");

        TextView tv = findViewById(R.id.textView4);
        tv.setText(inLog);
*/
        resource.setText(inRes, TextView.BufferType.EDITABLE);
 /*       login.setText(inLog);
        password.setText(inPassw);
        comment.setText(inComm);
*/
     //   String in = inCall.getStringExtra("id_");

       // tv.setText(in);
    }
}