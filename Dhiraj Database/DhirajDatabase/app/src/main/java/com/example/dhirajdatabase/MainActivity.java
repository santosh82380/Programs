package com.example.dhirajdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText id,name,age,address;
    Button insert,search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=(EditText)findViewById(R.id.txt_id);
        name=(EditText)findViewById(R.id.txt_name);
        age=(EditText)findViewById(R.id.txt_age);
        address=(EditText)findViewById(R.id.txt_address);
        insert=(Button)findViewById(R.id.btn_insert);
        insert.setOnClickListener(this);
        search=(Button)findViewById(R.id.btn_search);
        search.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.equals(insert))
        {
            String sid=id.getText().toString();
            String sname=name.getText().toString();
            String sage=age.getText().toString();
            String saddress=address.getText().toString();
            MyDatabase dat=new MyDatabase(this,MyDatabase.DATABASE_NAME, null, 1);
            SQLiteDatabase database=dat.getWritableDatabase();
            ContentValues cv= new ContentValues();
            cv.put("id", sid);
            cv.put("name", sname);
            cv.put("age",sage );
            cv.put("address", saddress);
            database.insert("Employee", null, cv);
            database.close();
            Toast.makeText(this, "Data Inserted successfully", Toast.LENGTH_LONG).show();
        }
        else if(v.equals(search))
        {
            Intent it=new Intent(this,Searchactivity.class);
            startActivity(it);
        }
    }
}