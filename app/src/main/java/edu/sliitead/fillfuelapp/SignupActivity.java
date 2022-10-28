package edu.sliitead.fillfuelapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import edu.sliitead.fillfuelapp.utils.Constants;

public class SignupActivity extends AppCompatActivity {

    TextView txtLogin, txtStationSignup;
    AutoCompleteTextView txtVehicleList, txtFuelList;
    ArrayAdapter<String> vehicleAdapter;
    EditText etdName, edtNic, edtPassword, etdPhone;
    Spinner spnVehicleList;
    Button btnSignupSt;


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
        btnSignupSt = (Button) findViewById(R.id.btnSignupUsr);

        vehicleAdapter = new ArrayAdapter<String>(this, R.layout.string_adapter_item, Constants.VEHICLELIST);


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

        btnSignupSt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLogin();
            }
        });
    }

    private void showStationRegistration() {
        startActivity(new Intent(this, StationCreateActivity.class));
    }

    private void showLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    private void createUser() {

    }
}