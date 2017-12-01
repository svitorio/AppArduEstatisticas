package com.example.vitorio.arduestatistica;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //SCREEN_ORIENTATION_BEHIND.[
        //SCREEN_ORIENTATION_LANDSCAPE
        findViewById(R.id.btnNovosExperimentos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ConfigurationsColums.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
