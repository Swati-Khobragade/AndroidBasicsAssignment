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

import com.example.employeeloginapplication.R;
import com.example.employeeloginapplication.adapter.EmployeeListAdapter;
import com.example.employeeloginapplication.employee.Employee;
import com.example.employeeloginapplication.employee.EmployeeDataHandler;

import java.util.ArrayList;

public class EmployeeListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView empListView;
    private EmployeeListAdapter employeeListAdapter;
    ArrayList<Employee> empData;
    View view;

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.employee_list_fragment_layout, container, false);
        initViews();
        setAdapter();
        return view;
    }

    /**
     * Initialize the Views
     */
    private void initViews() {
        empListView = view.findViewById(R.id.employeeListview);
    }

    /**
     * Set Adapter to Listview
     */
    private void setAdapter() {
        empData = EmployeeDataHandler.getEmpData();
        Log.d("Employee Data::", empData.toString());
        if (employeeListAdapter == null) {
            employeeListAdapter = new EmployeeListAdapter(getActivity(), empData);
        }
        empListView.setAdapter(employeeListAdapter);
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
        launchEmployeeDetailsFragment(empData.get(position));
    }

    /**
     * @param employee
     */
    private void launchEmployeeDetailsFragment(Employee employee) {
        EmployeeDetailsFragment empDetailsFragment = EmployeeDetailsFragment.newInstance();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrame, empDetailsFragment);
        Bundle args = new Bundle();
        args.putString("name", employee.getEmpName());
        args.putInt("age", employee.getEmpAge());
        args.putString("desg", employee.getEmpDesignation());
        args.putInt("img", employee.getEmpResId());
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
