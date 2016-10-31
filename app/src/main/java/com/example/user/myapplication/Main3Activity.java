package com.example.user.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    }

    public void setContact(View view) {
        Intent intent = new Intent(this, Main4Activity.class);
        startActivityForResult(intent, 2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 2) {

            if (data.getExtras() != null) {
                TextView contactName = (TextView) findViewById(R.id.contactName);
                TextView contactNumber = (TextView) findViewById(R.id.phoneNum);

                Bundle bundles = data.getExtras();

                contactNumber.setText(bundles.getString("CONTACTNUMBER"));
                contactName.setText(bundles.getString("CONTACTNAME"));


            }

        }
    }


    public void callMe(View view) {
        TextView contactNumber = (TextView) findViewById(R.id.phoneNum);

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + contactNumber.getText().toString()));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            startActivityForResult(intent,123);
            return;
        }


    }


}
