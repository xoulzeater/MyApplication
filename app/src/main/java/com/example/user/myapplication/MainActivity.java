package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getMessage(View view){
        Intent intentGetMessage = new Intent(this,Main2Activity.class);
        startActivityForResult(intentGetMessage,2);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 2){

            if(data!= null){
                String message = data.getStringExtra("MESSAGE");

                TextView textViewMessage = (TextView)findViewById(R.id.textViewMessage);
                textViewMessage.setText("Message is :"+message);

            }
        }
    }
}
