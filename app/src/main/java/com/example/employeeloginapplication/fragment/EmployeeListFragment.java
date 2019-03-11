package com.example.employeeloginapplication.fragment;
/**
 * @author Swati.Khobragade
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.employeeloginapplication.R;
import com.example.employeeloginapplication.adapter.CustomAdapter;
import com.example.employeeloginapplication.employee.Employee;
import com.example.employeeloginapplication.employee.EmployeeDataHandler;

import java.util.ArrayList;

public class EmployeeListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView empListView;
    int[] empImageArray = {R.drawable.img1, R.drawable.img7, R.drawable.img8, R.drawable.img4, R.drawable.img5, R.drawable.img2, R.drawable.img3, R.drawable.img8};

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ArrayList<Employee> empData = EmployeeDataHandler.getEmpData();
        Log.d("Employee Data::", empData.toString());
        View view = inflater.inflate(R.layout.employee_list_fragment_layout, container, false);
        empListView = view.findViewById(R.id.employeeListview);
        empListView.setAdapter(new CustomAdapter(getActivity(), empData, empImageArray));
        return view;
    }

    /**
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        empListView.setOnItemClickListener(this);
    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("Position", String.valueOf(position));
        TextView name = view.findViewById(R.id.tvEmpName);
        TextView desg = view.findViewById(R.id.tvEmpDesignation);
        TextView age = view.findViewById(R.id.tvEmpAge);
        String empName = name.getText().toString().trim();
        String empDesg = desg.getText().toString().trim();
        String empAge = age.getText().toString().trim();
        int empImg = empImageArray[position];

        Log.v("name", empName);
        Log.v("desg", empDesg);
        Log.v("age", empAge);
        Log.v("img", String.valueOf(empImg));
        launchEmployeeDetailsFragment(empName, empDesg, empAge, empImg);
    }

    /**
     * Method to launch Employee Details Fragment
     *
     * @param empName
     * @param empDesg
     * @param empAge
     * @param empImg
     */
    private void launchEmployeeDetailsFragment(String empName, String empDesg, String empAge, int empImg) {
        EmployeeDetailsFragment empDetailsFragment = EmployeeDetailsFragment.newInstance();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrame, empDetailsFragment);
        Bundle args = new Bundle();
        args.putString("name", empName);
        args.putString("age", empAge);
        args.putString("desg", empDesg);
        args.putInt("img", empImg);
        empDetailsFragment.setArguments(args);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /**
     * @return
     */
    public static EmployeeListFragment newInstance() {
        Bundle args = new Bundle();
        EmployeeListFragment fragment = new EmployeeListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
