package com.example.employeeloginapplication.adapter;
/*
  @author Swati.Khobragade
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.employeeloginapplication.R;
import com.example.employeeloginapplication.employee.Employee;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private ArrayList<Employee> empList;
    private int[] empImgArray;
    private Context context;

    public CustomAdapter() {
    }

    /**
     * @param cont
     * @param employeeArrayList
     * @param empImg
     */
    public CustomAdapter(Context cont, ArrayList<Employee> employeeArrayList, int[] empImg) {
        context = cont;
        empList = employeeArrayList;
        empImgArray = empImg;
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return empImgArray.length;
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return position;
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;
        view = inflater.inflate(R.layout.custom_employee_list, parent, false);
        TextView empName, empDesg, empAge;
        ImageView imageView;
        empName = view.findViewById(R.id.tvEmpName);
        empDesg = view.findViewById(R.id.tvEmpDesignation);
        empAge = view.findViewById(R.id.tvEmpAge);
        imageView = view.findViewById(R.id.imgEmp);
        empName.setText(empList.get(position).getEmpName());
        empDesg.setText(empList.get(position).getEmpDesignation());
        empAge.setText(String.valueOf(empList.get(position).getEmpAge()));
        imageView.setImageResource(empImgArray[position]);
        return (view);
    }
}