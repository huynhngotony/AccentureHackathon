package com.example.kevinsacer.trophy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button trophyBtn = (Button) findViewById(R.id.trophyBtn);
        Button popBtn = (Button) findViewById(R.id.popBtn);

        trophyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTrophyActivity();
            }
        });

        popBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPop();
            }
        });




    }

    public void startTrophyActivity() {
        Intent intent = new Intent(this, trophy_activity.class);

        startActivity(intent);
    }
    public void startPop() {
        Intent intent = new Intent(this, popup.class);
        startActivity(intent);
    }
}

