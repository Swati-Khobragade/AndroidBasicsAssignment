package com.example.employeeloginapplication.fragment;
/**
 * @author Swati.Khobragade
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.employeeloginapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link EmployeeDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmployeeDetailsFragment extends Fragment {
    int img = 0;
    private String name;
    private String desg;
    private int age = 0;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EmployeeDetailsFragment.
     */
    public static EmployeeDetailsFragment newInstance() {
        EmployeeDetailsFragment fragment = new EmployeeDetailsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        name = getArguments().getString("name");
        age = getArguments().getInt("age");
        desg = getArguments().getString("desg");
        img = getArguments().getInt("img");
        Log.d("name****", name);
        Log.d("age****", String.valueOf(age));
        Log.d("desg****", desg);
        Log.d("img****", String.valueOf(img));

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee_details, container, false);
    }

    /**
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView empName = view.findViewById(R.id.tvEmpNameValue);
        TextView empAge = view.findViewById(R.id.tvEmpAgeValue);
        TextView empDesg = view.findViewById(R.id.tvEmpDesgValue);
        ImageView empImg = view.findViewById(R.id.imageView);
        empName.setText(name);
        empAge.setText(String.valueOf(age));
        empDesg.setText(desg);
        empImg.setImageResource(img);
    }
}
