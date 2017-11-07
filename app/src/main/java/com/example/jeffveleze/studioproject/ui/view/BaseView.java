package com.example.jeffveleze.studioproject.ui.view;

/**
 * Created by jeffveleze on 11/4/17.
 */
public interface BaseView {

    void createAlertDialog();

    void showAlertDialog(String message);

    void createProgressDialog();

    void showProgressDialog();

    void hideProgressDialog();


}
