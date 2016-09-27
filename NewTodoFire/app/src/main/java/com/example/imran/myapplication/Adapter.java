package com.example.imran.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by imran on 9/26/2016.
 */

public class Adapter extends BaseAdapter{
    private List<Modules> modulesList ;
    private Context context;

    public Adapter(List<Modules> modulesList, Context context) {
        this.modulesList = modulesList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return modulesList.size();
    }

    @Override
    public Object getItem(int position) {
        return modulesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return modulesList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.inflatelist,null);

        TextView nametext = (TextView) view.findViewById(R.id.nameTextview);
        TextView agetext = (TextView) view.findViewById(R.id.ageTextview);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBox2);
        Modules modules = modulesList.get(position);

        nametext.setText("Name: "+modules.getName());
        agetext.setText("Age: "+String.valueOf(modules.getAge()));

        if (checkBox.isChecked()){
            checkBox.setChecked(true);
        }else {
            checkBox.setChecked(false);
        }




        return view;
    }
}
