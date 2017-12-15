package com.example.bit.passman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class First extends AppCompatActivity {

    EditText etLogin;
    Button btnOk, btnExit;
    final String pass = "a";
    String enterPass;
    String LT = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        etLogin = (EditText) findViewById(R.id.etLogin);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnExit = (Button) findViewById(R.id.btnExit);


    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnOk:
                enterPass = etLogin.getText().toString();
                Intent intent = new Intent(this, List.class);

                //  Log.d(LT, "pass = " + pass + ", enterPass = " + enterPass + ";");
                //   Log.d(LT, "" + (enterPass.equals (pass)));

                if (enterPass.equals(pass)){

                    startActivity(intent);
                    break;
                } else{
                    Toast.makeText(First.this, "Access denied", Toast.LENGTH_SHORT).show();
                    break;
                }

            case R.id.btnExit:
                finish();
                break;
        }
    }

}