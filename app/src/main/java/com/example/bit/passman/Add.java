package com.example.bit.passman;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Add extends AppCompatActivity {
    DBHelper dbHelper;

    EditText etResource, etLogin, etPassword, etComment;
    Button btnOk, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        dbHelper = new DBHelper(this);

        etResource = (EditText)findViewById(R.id.etResource);
        etLogin = (EditText)findViewById(R.id.etLogin);
        etPassword = (EditText)findViewById(R.id.etPassword);
        etComment = (EditText)findViewById(R.id.etComment);

        btnCancel = (Button)findViewById(R.id.btnCancel);
        btnOk = (Button)findViewById(R.id.btnOk);

    }

    public void onClickAdd(View v){

        String resource = etResource.getText().toString();
        String login = etLogin.getText().toString();
        String password = etPassword.getText().toString();
        String comment = etComment.getText().toString();


        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        switch (v.getId()){
            case R.id.btnOk:
                cv.put(DBHelper.KEY_RESOURCE, resource);
                cv.put(DBHelper.KEY_LOGIN, login);
                cv.put(DBHelper.KEY_PASSWORD, password);
                cv.put(DBHelper.KEY_COMMENT, comment);

                db.insert(DBHelper.TABLE_BASE, null, cv);
                finish();
                break;
            case R.id.btnCancel:
                finish();
                break;
        }
    }
}