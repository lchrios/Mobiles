package com.example.activity12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Hub extends AppCompatActivity {

    TextView txPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);

        txPost = (TextView) findViewById(R.id.txPost);

        txPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hub.this, Post.class);
                startActivity(intent);
            }
        });

    }
}