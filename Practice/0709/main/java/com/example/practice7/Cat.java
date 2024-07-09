package com.example.practice7;

import android.widget.ImageView;

public class Cat extends Animal {

    ImageView image;

    Cat(String name, int age, String mobile, ImageView image) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.image = image;
    }

    void standUp() {
        this.image.setImageResource(R.drawable.cat_std);
    }

    void sitDown() {
        this.image.setImageResource(R.drawable.cat_sit);
    }

    void run() {
        this.image.setImageResource(R.drawable.cat_run);
    }

}
