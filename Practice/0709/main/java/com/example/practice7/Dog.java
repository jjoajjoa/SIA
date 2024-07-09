package com.example.test1;

import android.widget.ImageView;

public class Dog extends Animal {

    ImageView image;

    Dog(String name, int age, String mobile, ImageView image) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.image = image;
    }

    void standUp() {
        this.image.setImageResource(R.drawable.dog_std);
    }

    void sitDown() {
        this.image.setImageResource(R.drawable.dog_sit);
    }

    void run() {
        this.image.setImageResource(R.drawable.dog_run);
    }

}
