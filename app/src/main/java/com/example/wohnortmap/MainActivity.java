package com.example.wohnortmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    public static String ACTION_VIEW = "android.content.Intent.ACTION_VIEW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText addressfield = findViewById(R.id.edit_text);
        final Button button = findViewById(R.id.button);

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String address = addressfield.getText().toString();
                    address.replace(" ", "+");
                    Intent geoIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q=" + address));
                    startActivity(geoIntent);
                } catch (Exception e) {

                }
            }
        });
    }
}