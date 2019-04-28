package com.example.dbflow;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    Context context;
    List<StudentTable> studentTableList;
    ClickedMe clickedMe;
    ListViewAdapter(Context context, List<StudentTable> studentTableList,ClickedMe clickedMe){
        this.context = context;
        this.studentTableList = studentTableList;
        this.clickedMe = clickedMe;
    }
    @Override
    public int getCount() {
        return studentTableList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.student_view_item,parent,false);
        TextView sid, name,marks,classOFStudy;
        name = view.findViewById(R.id.name);
        marks = view.findViewById(R.id.marks);
        classOFStudy = view.findViewById(R.id.classOFStudy);
        sid = view.findViewById(R.id.sid);


        sid.setText(""+studentTableList.get(position).getSid());
        name.setText(studentTableList.get(position).getName());
        marks.setText(""+studentTableList.get(position).getMarks());
        classOFStudy.setText(""+studentTableList.get(position).getClassOfStudying());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("data",studentTableList.get(position).toString());
                clickedMe.setdata(studentTableList.get(position));
            }
        });

        return view;
    }
}
