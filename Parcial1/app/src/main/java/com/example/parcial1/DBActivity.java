package com.example.parcial1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class DBActivity extends AppCompatActivity {

    private EditText txSaludo, txId, txNombre, txAge;
    private Button btSave, btBuscar, btBack;

    private DBHelper db;

    private static final int ACTIVITY_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_b);

        db = new DBHelper(this);

        txSaludo = (EditText) findViewById(R.id.txSaludo);
        txAge = (EditText) findViewById(R.id.txAge);
        txId = (EditText) findViewById(R.id.txId);
        txNombre = (EditText) findViewById(R.id.txNombre);

        btSave = (Button) findViewById(R.id.btSave);
        btBuscar = (Button) findViewById(R.id.btBuscar);
        btBack = (Button) findViewById(R.id.btBack);

        Map<String, Object> firstRec = db.findByPos(0);
        txId.setText(firstRec.get(db.FIELD_ID).toString());
        txNombre.setText(firstRec.get(db.FIELD_NAME).toString());
        txAge.setText(firstRec.get(db.FIELD_ID).toString());
        txSaludo.setText(getIntent().getStringExtra("main"));

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txNombre.getText().toString();
                int edad = txAge.getText().equals("") ? 0 : Integer.valueOf(txAge.getText().toString());
                db.save(nombre, edad);
                Toast.makeText(DBActivity.this, "Nombre: " + nombre + " Edad: " + edad, Toast.LENGTH_SHORT).show();
            }
        });

        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> result = db.find(txId.getText().toString());
                txNombre.setText(result.get(db.FIELD_NAME).toString());
                txAge.setText(result.get(db.FIELD_AGE).toString());
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("id", txId.getText().toString());

                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY_CODE && resultCode == Activity.RESULT_OK) {

            txSaludo.setText(data.getStringExtra("maininfo"));
        }
    }
}