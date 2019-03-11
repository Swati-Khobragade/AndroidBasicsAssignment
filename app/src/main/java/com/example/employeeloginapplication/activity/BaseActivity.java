package com.example.employeeloginapplication.activity;
/**
 * @author Swati.Khobragade
 */

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    /**
     * Method to show Alert with two buttons
     *
     * @param Message
     */
    public void showAlertDialog(String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert");
        builder.setMessage(Message);
        // add the buttons
        builder.setPositiveButton("Ok", null);
        builder.setNegativeButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                onNegativeButtonClicked(dialog, id);
            }
        });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Method to show basic Alert Dialog
     *
     * @param msg
     */
    public void showAlert(String msg) {
        final Handler handler = new Handler();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg);
        final AlertDialog dialog = builder.create();
        dialog.show();
        handler.postDelayed(new Runnable() {
            public void run() {
                dialog.dismiss();
            }
        }, 3000);
    }

    /**
     * @param dialogInterface
     * @param id
     */
    public void onPositiveButtonClicked(DialogInterface dialogInterface, int id) {
        //Override this to handle positive button press

    }

    /**
     * @param dialogInterface
     * @param id
     */
    public void onNegativeButtonClicked(DialogInterface dialogInterface, int id) {
        //Override this to handle negative button press

    }
}
