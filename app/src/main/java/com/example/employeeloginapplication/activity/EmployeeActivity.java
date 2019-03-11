package com.example.employeeloginapplication.activity;
/**
 * @author Swati.Khobragade
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.employeeloginapplication.R;
import com.example.employeeloginapplication.fragment.EmployeeListFragment;

public class EmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        loadEmployeeListFragment();
    }

    /**
     * Method to load Employee List Fragment
     */
    public void loadEmployeeListFragment() {
        EmployeeListFragment employeeListFragment = EmployeeListFragment.newInstance();
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.mainFrame, employeeListFragment);
        transaction.commit();
    }

    /**
     * Method to logout from application
     */
    private void logoutAction() {
        startActivity(new Intent(EmployeeActivity.this, MainActivity.class));
        finish();
    }

    /**
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.actionLogout:
                logoutAction();
                break;
        }
        return true;
    }

}
