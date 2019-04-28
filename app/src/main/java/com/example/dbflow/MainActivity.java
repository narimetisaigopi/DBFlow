package com.example.dbflow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickedMe{

    EditText sid,name, marks, classofStudy;
    Button save,read,update,delete;

    ListView listView;

    ClickedMe clickedMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = findViewById(R.id.name);
        sid = findViewById(R.id.sid);
        marks = findViewById(R.id.marks);
        update = findViewById(R.id.update);

        classofStudy = findViewById(R.id.classofstudy);

        save = findViewById(R.id.save);
        read = findViewById(R.id.read);
        read = findViewById(R.id.read);
        delete = findViewById(R.id.delete);

        listView =  findViewById(R.id.listview);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StudentTable studentTable = new StudentTable();
                studentTable.setName(name.getText().toString());
                studentTable.setMarks(Integer.parseInt(marks.getText().toString()));
                studentTable.setClassOfStudying(Integer.parseInt(classofStudy.getText().toString()));

                if (studentTable.save()) {
                    Toast.makeText(MainActivity.this, "saved success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "saved failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateListView();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                StudentTable studentTable = new StudentTable();
                studentTable.setSid(Long.parseLong(sid.getText().toString())); // update operation
                studentTable.setName(name.getText().toString());
                studentTable.setMarks(Integer.parseInt(marks.getText().toString()));
                studentTable.setClassOfStudying(Integer.parseInt(classofStudy.getText().toString()));

                if (studentTable.update()) {
                    Toast.makeText(MainActivity.this, "Record of sid "+Long.parseLong(sid.getText().toString())+" updated ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "update failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentTable studentTable = new StudentTable();
                studentTable.setSid(Long.parseLong(sid.getText().toString()));

                if (studentTable.delete()) {
                    Toast.makeText(MainActivity.this, "Record of sid "+Long.parseLong(sid.getText().toString())+" deleted ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "delete failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    void populateListView(){
        List<StudentTable> studentTableList = SQLite.select().from(StudentTable.class).queryList();
        ListViewAdapter listViewAdapter = new ListViewAdapter(MainActivity.this,studentTableList,this);
        listView.setAdapter(listViewAdapter);
    }

    @Override
    public void setdata(StudentTable studentTable) {
        Log.d("data2",studentTable.toString());
        sid.setText(""+studentTable.getSid());
        name.setText(""+studentTable.getName());
        marks.setText(""+studentTable.getMarks());
        classofStudy.setText(""+studentTable.getClassOfStudying());
    }
}
