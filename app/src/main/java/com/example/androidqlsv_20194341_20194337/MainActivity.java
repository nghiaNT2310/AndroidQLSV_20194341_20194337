package com.example.androidqlsv_20194341_20194337;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    List<ItemModel> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items=new ArrayList<>();

        String path = getFilesDir() + "/mydb";
        try {
            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        createTable();

        insertTable();


        ItemAdapter adapter=new ItemAdapter(items);
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter) ;

    }

    public void insertTable() {
        String[] columns = {"id", "name", "date","email"};
        Cursor cs = db.query("tblAMIGO", columns,
                null, null, null, null ,null);



        cs.moveToPosition(-1);
        while (cs.moveToNext()) {
            String id = cs.getString(0);
            String name = cs.getString(1);
            String date = cs.getString(2);
            String email=cs.getString(3);
            items.add(new ItemModel(id,name,date,email));
        }


    }

    public void createTable() {
        db.beginTransaction();
        try {
            db.execSQL("create table tblAMIGO(" +
                    "id text PRIMARY KEY, " +
                    "name text," +
                    "date text," +
                    "email text)");

            db.execSQL("insert into tblAMIGO(id,name, date,email) values('1','AAA', '555-1111','nghia@gmail.com')");
            db.execSQL("insert into tblAMIGO(id,name, date,email) values('2','AAA', '555-1111','nghia@gmail.com')");
            db.execSQL("insert into tblAMIGO(id,name, date,email) values('3','AAA', '555-1111','nghia@gmail.com')");
            db.execSQL("insert into tblAMIGO(id,name, date,email) values('4','AAA', '555-1111','nghia@gmail.com')");
            db.execSQL("insert into tblAMIGO(id,name, date,email) values('5','AAA', '555-1111','nghia@gmail.com')");

            db.setTransactionSuccessful();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }
}