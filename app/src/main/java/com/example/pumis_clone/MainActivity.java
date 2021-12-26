package com.example.pumis_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button hello;
    private EditText Name;
    private EditText password;

    public void ontap(View View)
    {
        hello=(Button)findViewById(R.id.button);
        Name = (EditText) findViewById(R.id.Enrollment);
        password = (EditText) findViewById(R.id.Password);

        if(Name.getText().toString().equals("200305124069") && password.getText().toString().equals("01052001"))
        {
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Invalid Input",Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}