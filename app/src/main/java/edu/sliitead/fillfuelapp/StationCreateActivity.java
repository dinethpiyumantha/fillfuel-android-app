package edu.sliitead.fillfuelapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class StationCreateActivity extends AppCompatActivity {

    TextView txtCustomerSignup;
    Button btnSignupSt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_station_create);

        txtCustomerSignup = (TextView) findViewById(R.id.txtSignupCustomer);
        btnSignupSt = (Button) findViewById(R.id.btnSignupSt);

        txtCustomerSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomerSignup();
            }
        });

        btnSignupSt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLogin();
            }
        });
    }

    private void showLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    private void showCustomerSignup() {
        startActivity(new Intent(this, SignupActivity.class));
    }
}