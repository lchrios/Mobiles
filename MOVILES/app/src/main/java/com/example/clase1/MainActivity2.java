package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText name,
             grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // retrieve the Intent used to open me up!
        Intent intentote = getIntent();
        String nombre = intentote.getStringExtra("nombre");
        String apellido = intentote.getStringExtra("apellido");


        Toast.makeText(this, nombre + " " + apellido, Toast.LENGTH_SHORT).show();

        name = findViewById(R.id.editTextName);
        grade = findViewById(R.id.editTextGrade);
    }

    public void returnToActivivty1(View v) {

        Intent intent = new Intent();
        intent.putExtra("name", name.getText().toString());
        intent.putExtra("grade", grade.getText().toString());

        // how to actually set the information to be sent back
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}