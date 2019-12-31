package com.example.myapplicationtemp;

import android.media.Image;

import java.util.ArrayList;
import java.util.List;

public class Ex {
    private String number;
    private ArrayList<Image>  image;

    public Ex(String no, ArrayList<Image>  images) {

        this.number = no;
        this.image = new ArrayList<Image>(images);


    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(ArrayList<Image> image) {
        this.image = image;
    }

}