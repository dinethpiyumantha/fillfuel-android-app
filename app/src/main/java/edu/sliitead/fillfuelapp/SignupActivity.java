package edu.sliitead.fillfuelapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    TextView txtLogin, txtStationSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_signup);

        //Set components
        txtLogin = (TextView) findViewById(R.id.txtLogin);
        txtStationSignup = (TextView) findViewById(R.id.txtSignupStation);

        //On click events
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLogin();
            }
        });

        txtStationSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showStationRegistration();
            }
        });
    }

    private void showStationRegistration() {
        startActivity(new Intent(this, StationCreateActivity.class));
    }

    private void showLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}