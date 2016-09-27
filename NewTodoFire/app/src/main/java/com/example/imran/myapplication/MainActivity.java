package com.example.imran.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Modules> modulesArrayList = new ArrayList<>();
    private Modules module;
    private Adapter adapter;
    private ListView listView;
    private Context context;
    private CheckBox checkBoxcheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.listitems);
        adapter = new Adapter(modulesArrayList, this);
        listView.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Add Values");

                View view1 = getLayoutInflater().inflate(R.layout.inflate, null);
                final EditText editname = (EditText) view1.findViewById(R.id.name);
                final EditText editage = (EditText) view1.findViewById(R.id.age);
                checkBoxcheck = (CheckBox) view1.findViewById(R.id.checkBox);
                builder.setPositiveButton("Add values", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String names = editname.getText().toString();
                        String ages = editage.getText().toString();
                        boolean isread = checkBoxcheck.isChecked();

                        modulesArrayList.add(new Modules(0, names, Integer.valueOf(ages), isread));
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setView(view1);
                builder.create().show();
                adapter.notifyDataSetChanged();
            }
        });
        final int id =
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CheckBox checkBoxdelete = (CheckBox) findViewById(R.id.checkBox2);
                if (checkBoxdelete.isChecked()) {
int pos = modulesArrayList.get(id).getId();
                    modulesArrayList.remove(pos);
                    adapter.notifyDataSetChanged();
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
