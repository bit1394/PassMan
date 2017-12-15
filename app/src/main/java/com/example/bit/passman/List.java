package com.example.bit.passman;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class List extends AppCompatActivity {
    DBHelper dbHelper;
    ListView lvList;
    SimpleCursorAdapter ad;
    Intent intent;
   // final SQLiteDatabase db1 = ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lvList =(ListView)findViewById(R.id.lvList);

        dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor c = db.query(DBHelper.TABLE_BASE, null, null, null, null, null, null);
        //startManagingCursor(c);

        final String[] from = new String[]{DBHelper.KEY_RESOURCE};
        int[] to = new int[]{R.id.tvRes};

        ad = new SimpleCursorAdapter(this, R.layout.item, c, from, to);
        lvList.setAdapter(ad);
        intent = new Intent(this, Edit.class);

        //ToDo : вынести в отдельную функцию
        //
        lvList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                SQLiteDatabase db1 = dbHelper.getReadableDatabase();
                Cursor cursor = db1.query(DBHelper.TABLE_BASE, null, "" + l,null, null,null,null);

                String res = "";
                if (cursor != null){
                    res = cursor.getString( );
                }
                intent.putExtra("res", res);
                startActivity(intent);


                return false;
            }


        });
        //ToDo: end


    }

    public void onClick(View v){

        Intent outCall = new Intent(this, Add.class);

        switch (v.getId()){
            case R.id.btnAdd:
                startActivity(outCall);
                break;
            case R.id.btnDelete:
                break;
            case R.id.btnExit:
                finish();
                break;
        }
    }

}