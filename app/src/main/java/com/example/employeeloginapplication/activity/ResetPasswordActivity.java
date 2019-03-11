package com.example.employeeloginapplication.activity;
/**
 * @author Swati.Khobragade
 */

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.employeeloginapplication.R;

public class ResetPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mNewPasswordEditText;
    private EditText mConfirmPasswordEditText;
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        initViews();
        registerListeners();
    }

    /**
     * Initialize the views
     */
    private void initViews() {
        mNewPasswordEditText = findViewById(R.id.editTextNewPassword);
        mConfirmPasswordEditText = findViewById(R.id.editTextConfirmPassword);
        mSubmitButton = findViewById(R.id.btnSubmit);
        mNewPasswordEditText.requestFocus();
    }

    /**
     * Register Listeners
     */
    private void registerListeners() {
        mSubmitButton.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit:
                submit();
                break;
        }
    }

    /**
     * Method for submitting new Password details
     */
    private void submit() {
        String newPassword = mNewPasswordEditText.getText().toString().trim();
        String confirmPassword = mConfirmPasswordEditText.getText().toString().trim();
        if (validateFields(newPassword, confirmPassword)) {
            Intent replyIntent = new Intent();
            replyIntent.putExtra("returnMsg", confirmPassword);
            setResult(RESULT_OK, replyIntent);
            finish();
        }
    }

    /**
     * Method for validating fields
     *
     * @param newPassword
     * @param confirmPassword
     * @return
     */
    private boolean validateFields(String newPassword, String confirmPassword) {
        if (TextUtils.isEmpty(newPassword)) {
            mNewPasswordEditText.requestFocus();
            mNewPasswordEditText.setError("Please enter New Password");
            return false;
        }
        if (TextUtils.isEmpty(confirmPassword)) {
            mConfirmPasswordEditText.requestFocus();
            mConfirmPasswordEditText.setError("Please Confirm Password");
            return false;
        }
        if (!TextUtils.equals(newPassword, confirmPassword)) {
            mConfirmPasswordEditText.requestFocus();
            mConfirmPasswordEditText.setError("Password does not match");
            return false;
        }
        return true;
    }
}
