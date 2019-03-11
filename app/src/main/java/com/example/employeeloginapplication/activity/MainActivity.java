package com.example.employeeloginapplication.activity;
/**
 * @author Swati.Khobragade
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.employeeloginapplication.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private String validUserName;
    private String validPassword;
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        registerListeners();
    }

    /**
     * Initialize the views
     */
    private void initViews() {
        mUsernameEditText = findViewById(R.id.editTxtUsername);
        mPasswordEditText = findViewById(R.id.editTxtPassword);
        mLoginButton = findViewById(R.id.btnLogin);
        mUsernameEditText.requestFocus();
        validUserName = "Swati";
        validPassword = "Secret";
    }

    /**
     * Register Listeners
     */
    private void registerListeners() {
        mLoginButton.setOnClickListener(this);
    }

    private void login() {
        String username = mUsernameEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();
        if (validateFields(username, password)) {
            if (username.equalsIgnoreCase(validUserName) && password.equalsIgnoreCase(validPassword)) {
                launchEmployeeActivity();
                Toast.makeText(this, "Login Successfully !!", Toast.LENGTH_SHORT).show();
            } else {
                showAlertDialog("Invalid Login Credentials!!");
            }
        }
    }

    /**
     * Overriding Method to handle Negative Button Press
     *
     * @param dialogInterface
     * @param id
     */
    @Override
    public void onNegativeButtonClicked(DialogInterface dialogInterface, int id) {
        launchResetPasswordActivity();
    }

    /**
     * Method for Lunching Employee Activity
     */
    private void launchEmployeeActivity() {
        Intent intent = new Intent(MainActivity.this, EmployeeActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    /**
     * Method for Lunching Reset Password Activity
     */
    private void launchResetPasswordActivity() {
        Intent intent = new Intent(MainActivity.this, ResetPasswordActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    /**
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String newPassword =
                        data.getStringExtra("returnMsg");
                Log.d("Return Msg::", newPassword);
                showAlert("Password Reset Successfully !");
                validPassword = newPassword;
                mPasswordEditText.setText(newPassword);
            }
        }
    }

    /**
     * Method for validating fields
     *
     * @param username
     * @param password
     * @return
     */
    private boolean validateFields(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            mUsernameEditText.requestFocus();
            mUsernameEditText.setError("Please enter Username");
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            mPasswordEditText.requestFocus();
            mPasswordEditText.setError("Please enter Password");
            return false;
        }
        return true;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                login();
                break;
        }
    }

}
