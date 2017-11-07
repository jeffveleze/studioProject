package com.example.jeffveleze.studioproject.ui.view;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jeffveleze on 11/4/17.
 */
public class BaseActivity extends AppCompatActivity implements BaseView {

    private AlertDialog.Builder alertDialog;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void createAlertDialog() {
        if (alertDialog != null) {
            alertDialog = null;
        }

        alertDialog = new AlertDialog.Builder(BaseActivity.this);
        alertDialog.setCancelable(false);
    }

    @Override
    public void createProgressDialog() {
        if (progressDialog != null) {
            progressDialog = null;
        }

        progressDialog = new ProgressDialog(BaseActivity.this);
        progressDialog.setCancelable(false);
    }

    @Override
    public void showProgressDialog() {
        progressDialog.setMessage("Espere por favor");
        progressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void showAlertDialog(String message) {
        alertDialog.setTitle("Señor usuario");
        alertDialog.setMessage(message);
        alertDialog.setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alertDialog.show();
    }
}
