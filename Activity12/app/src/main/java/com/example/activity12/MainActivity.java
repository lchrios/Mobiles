package com.example.activity12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Boton
    Button btnLogin;

    // Plain Text
    EditText txUser, txPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);

        txUser = (EditText) findViewById(R.id.txUser);
        txPass = (EditText) findViewById(R.id.txPass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txUser.getText().toString().equals("admin") && txPass.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Inicio de sesion exitoso.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Hub.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Credenciales incorrectas.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}