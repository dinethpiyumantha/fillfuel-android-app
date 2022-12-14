package edu.sliitead.fillfuelapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin, btnLoginAsStation;
    TextView txtSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_login);

        //Set components
        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtSignup = (TextView) findViewById(R.id.txtSignup);
        btnLoginAsStation = (Button) findViewById(R.id.btnLoginAsStation);

        //On Click events
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHome();
            }
        });

        btnLoginAsStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showStation();
            }
        });

        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSignup();
            }
        });
    }

    private void showHome() {
        startActivity(new Intent(this, HomeActivity.class));
    }
    private void showSignup() {
        startActivity(new Intent(this, SignupActivity.class));
    }
    private void showStation() {
        startActivity(new Intent(this, StationActivity.class));
    }
}