package com.example.ex06;

import static java.lang.System.exit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText eT;
    TextView tV;
    Button count;
    Button reset;
    Button exit;
    String name;
    int counter = 0;
    String countStr = String.valueOf(counter);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eT = findViewById(R.id.eT);
        tV = findViewById(R.id.tV);
        count = findViewById(R.id.count);
        reset = findViewById(R.id.reset);
        exit = findViewById(R.id.exit);

        SharedPreferences data = getSharedPreferences("DATA", MODE_PRIVATE);

        name = data.getString("name", null);
        counter = data.getInt("counter", 0);

        countStr = String.valueOf(counter);

        eT.setText(name);
        tV.setText(countStr);
    }

    public void onCount(View view) {
        counter++;
        countStr = String.valueOf(counter);
        tV.setText(countStr);
    }

    public void onReset(View view) {
        eT.setText("");
        counter = 0;
        countStr = String.valueOf(counter);
        tV.setText(countStr);
    }

    public void onExit(View view) {
        SharedPreferences data = getSharedPreferences("DATA", MODE_PRIVATE);
        SharedPreferences.Editor edit = data.edit();
        String str = eT.getText().toString();
        edit.putString("name", str);
        edit.putInt("counter", counter);
        edit.commit();
        exit(0);
    }
}