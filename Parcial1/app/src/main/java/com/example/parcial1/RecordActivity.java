package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Map;

public class RecordActivity extends AppCompatActivity {

    DBHelper db;
    TextView txFirst, txOldest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        db = new DBHelper(this);

        txFirst = (TextView) findViewById(R.id.txFirst);
        txOldest = (TextView) findViewById(R.id.txOld);

        Map<String, Object> alpha = db.findFirstAlphabetical(), oldest = db.findOldestCat();

        txFirst.setText("Nombre: "+ alpha.get(db.FIELD_NAME).toString() + "\nEdad: "+ alpha.get(db.FIELD_AGE).toString());
        txOldest.setText("Nombre: "+ oldest.get(db.FIELD_NAME).toString() + "\nEdad: "+ oldest.get(db.FIELD_AGE).toString());

    }
}