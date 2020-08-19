package com.example.clase1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // reference to GUI elements
    TextView hey;
    EditText input;
    Button b2;

    private static final int ACTIVITY2_CODE = 0;

    // our code (if it's activity) must comply with the activity lifecycle
    // this guys is useful for setup!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // link between logic and the UI
        // R -- class done by the dev tools
        // index of resources
        setContentView(R.layout.activity_main);

        // this is tricky! it might fail!
        hey = findViewById(R.id.textView);
        input = findViewById(R.id.editTextTextPersonName);
        b2 = findViewById(R.id.button2);

        hey.setText("HEY GUYS! ");

        Log.i("INFO", "INFO EXAMPLE");
        Log.d("DEBUG", "DEBUG EXAMPLE");
        Log.d("ERROR","ERROR EXAMPLE");
        Log.wtf("WTF","WHAT A TERRIBLE FAILURE!");

        // 2. if you have a single case logic - use an anonymous class
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        MainActivity.this,
                        input.getText().toString(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    // ways to detect interaction with widgets
    // 1. link through xml
    // 2. setup a listener

    // 1. link through xml
    // declare a method that has the following signature:
    public void interaction1(View v){

        // context - any activity is a context object
        // context is an object that has a reference to the OS
        // Toast is not made by OUR software. but by the OS
        // on multiple Toasts will create a Queue
        Toast.makeText(this, "BUTTON PRESSED",Toast.LENGTH_SHORT).show();

        // to start a new activity we are going to create an intent
        // we don't command
        // we ask nicely

        Intent intentito = new Intent(this, MainActivity2.class);
        intentito.putExtra("nombre", "Chris");
        intentito.putExtra("apellido", input.getText().toString());

        // easy way to start a new activity
        // doesn't expect a return
        //startActivity(intentito);

        startActivityForResult(intentito, ACTIVITY2_CODE);
    }


    // this guy listens to ALL returns from activities started with startActivityForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ACTIVITY2_CODE && resultCode == Activity.RESULT_OK){

            String name = data.getStringExtra("name");
            String grade = data.getStringExtra("grade");
            Toast.makeText(this,name + ": " + grade, Toast.LENGTH_SHORT).show();
        }
    }
}