package com.example.parcial1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton btDB, btRec;
    EditText txMain;

    private static final int ACTIVITY_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btDB = (ImageButton) findViewById(R.id.btnSmudge);
        btRec = (ImageButton) findViewById(R.id.btSadcat);

        txMain = (EditText) findViewById(R.id.txMain);

        btDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DBActivity.class);
                intent.putExtra("main", txMain.getText().toString());

                startActivityForResult(intent, ACTIVITY_CODE);
            }
        });

        btRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecordActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY_CODE && resultCode == Activity.RESULT_OK) {

            String id = data.getStringExtra("id");
            Toast.makeText(MainActivity.this, "ID: " + id, Toast.LENGTH_SHORT);
        }
    }
}