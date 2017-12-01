package com.example.vitorio.arduestatistica;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class ConfigurationsColums extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurations_colums);

        final Spinner numberogfcolums = (Spinner)findViewById(R.id.numberofcoluns);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);
        findViewById(R.id.btnConfirmar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = (String)numberogfcolums.getSelectedItem();
                Intent intent = new Intent(ConfigurationsColums.this,ConfigurationsColumsTwo.class);
                intent.putExtra("number",number);
                startActivity(intent);
                finish();
            }
        });
    }
}
