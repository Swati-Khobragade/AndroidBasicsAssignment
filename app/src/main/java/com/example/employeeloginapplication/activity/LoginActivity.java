package com.example.employeeloginapplication.activity;
/**
 * @author Swati.Khobragade
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.employeeloginapplication.R;
import com.example.employeeloginapplication.constants.IConstants;

public class LoginActivity extends BaseActivity implements View.OnClickListener, IConstants {
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private String validUserName;
    private String validPassword;

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

    /**
     * Method to Login into the Application
     */
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
        Intent intent = new Intent(LoginActivity.this, EmployeeActivity.class);
        startActivityForResult(intent, RESET_PASSWORD_REQUEST);
    }

    /**
     * Method for Lunching Reset Password Activity
     */
    private void launchResetPasswordActivity() {
        Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
        startActivityForResult(intent, RESET_PASSWORD_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESET_PASSWORD_REQUEST) {
            if (resultCode == RESULT_OK) {
                resetPassword(data);
            }
        }
    }

    /**
     * Method to reset Password
     *
     * @param data
     */
    private void resetPassword(Intent data) {
        String newPassword =
                data.getStringExtra(RETURN_MSG);
        Log.d("Return Msg::", newPassword);
        showAlert("Password Reset Successfully !");
        validPassword = newPassword;
        mPasswordEditText.setText(newPassword);
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
            setValidationMessage(mUsernameEditText, "Please enter Username");
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            setValidationMessage(mPasswordEditText, "Please enter Password");
            return false;
        }
        return true;
    }

    /**
     * Method to set Focus & Error Message to Empty Edittext
     * @param editText
     * @param message
     */
    private void setValidationMessage(EditText editText, String message) {
        editText.requestFocus();
        editText.setError(message);
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
