package com.example.myapplicationtemp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Books {

    private String bookName;
    private String faculty;
    private String degree;
    private String subjuct;
    private ArrayList <Ex> page;

    public Books(String bName, String fac, String deg, String sub, List<Ex> p) {

        this.bookName = bName;
        this.faculty = fac;
        this.degree = deg;
        this.subjuct = sub;
        this.page = new ArrayList<Ex>(p);


    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSubjuct() {
        return subjuct;
    }

    public void setSubjuct(String subjuct) {
        this.subjuct = subjuct;
    }

    public List<Ex> getPage() {
        return page;
    }

    public void setPage(ArrayList<Ex> page) {
        this.page = page;
    }


}