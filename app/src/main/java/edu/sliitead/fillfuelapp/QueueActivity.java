package edu.sliitead.fillfuelapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class QueueActivity extends AppCompatActivity {

    TextView txtCompanyBack;
    Button btnQueueExit;
    AlertDialog.Builder alertDialogBuilder;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_queue);

        txtCompanyBack = (TextView) findViewById(R.id.txtCompanyBack);
        btnQueueExit = (Button) findViewById(R.id.btnQueueExit);

        alertDialogBuilder = new AlertDialog.Builder(this);

        txtCompanyBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSearch();
            }
        });

        btnQueueExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogBuilder.setTitle("Exit confimation from fuel queue.")
                        .setMessage("Are you sure to exit from the queue?")
                        .setCancelable(true)
                        .setPositiveButton("Exit without fuel pump", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("Exit after fuel pump", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .show();

            }
        });

    }

    private void showSearch() {
        startActivity(new Intent(this, SearchActivity.class));
    }
}