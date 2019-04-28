package com.example.dbflow;

import android.support.annotation.ColorInt;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = DBFlowDataBase.class )
public class StudentTable extends BaseModel {

    @PrimaryKey(autoincrement = true)
    long sid;

    @Column
    String name;

    @Column
    int marks;

    @Column
    int classOfStudying;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getClassOfStudying() {
        return classOfStudying;
    }

    public void setClassOfStudying(int classOfStudying) {
        this.classOfStudying = classOfStudying;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "StudentTable{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", classOfStudying=" + classOfStudying +
                '}';
    }
}
