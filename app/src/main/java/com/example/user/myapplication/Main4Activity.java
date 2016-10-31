package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void sendPhone(View view){
        EditText contactName = (EditText)findViewById(R.id.contactName);
        EditText contactNumber = (EditText)findViewById(R.id.contactNumber);



        Intent intent = new Intent();
        intent.putExtra("CONTACTNAME",contactName.getText().toString());
        intent.putExtra("CONTACTNUMBER",contactNumber.getText().toString());
        setResult(2,intent);
        finish();


    }

}
