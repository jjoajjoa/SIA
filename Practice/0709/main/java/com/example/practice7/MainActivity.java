package com.example.test1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Animal animal;
    Dog dog;
    Cat cat;

    EditText inputName;
    EditText inputAge;
    EditText inputMobile;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.inputName);
        inputAge = findViewById(R.id.inputAge);
        inputMobile = findViewById(R.id.inputMobile);
        image = findViewById(R.id.image);

        Button btnCreateDog = findViewById(R.id.btnCreateDog);
        btnCreateDog.setOnClickListener(view -> {
            String name = inputName.getText().toString();
            String ageStr = inputAge.getText().toString();
            int age = Integer.parseInt(ageStr);
            String mobile = inputMobile.getText().toString();
            if (name.isEmpty() || ageStr.isEmpty() || mobile.isEmpty()) {
                Toast.makeText(MainActivity.this, "Plz enter the details.", Toast.LENGTH_SHORT).show();
            } else {
                createDog(name, age, mobile);
                Toast.makeText(MainActivity.this, "A dog has been made.", Toast.LENGTH_SHORT).show();
                image.setImageResource(R.drawable.dog_std);
            }
        });

        Button btnCreateCat = findViewById(R.id.btnCreateCat);
        btnCreateCat.setOnClickListener(view -> {
            String name = inputName.getText().toString();
            String ageStr = inputAge.getText().toString();
            int age = Integer.parseInt(ageStr);
            String mobile = inputMobile.getText().toString();
            if (name.isEmpty() || ageStr.isEmpty() || mobile.isEmpty()) {
                Toast.makeText(MainActivity.this, "Plz enter the details.", Toast.LENGTH_SHORT).show();
            } else {
                createCat(name, age, mobile);
                Toast.makeText(MainActivity.this, "A cat has been made.", Toast.LENGTH_SHORT).show();
                image.setImageResource(R.drawable.cat_std);
            }
        });

        ////////////
        Button btnStdUp = findViewById(R.id.btnStdUp);
        btnStdUp.setOnClickListener(view -> {
            if (animal != null) {
                animal.standUp();
            } else {
                Toast.makeText(MainActivity.this, "Create an animal first.", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSitDown = findViewById(R.id.btnSitDown);
        btnSitDown.setOnClickListener(view -> {
            if (animal != null) {
                animal.sitDown();
            } else {
                Toast.makeText(MainActivity.this, "Create an animal first.", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnRun = findViewById(R.id.btnRun);
        btnRun.setOnClickListener(view -> {
            if (animal != null) {
                animal.run();
            } else {
                Toast.makeText(MainActivity.this, "Create an animal first.", Toast.LENGTH_SHORT).show();
            }
        });

    } //onCreate

    void createDog(String name, int age, String mobile) {
        dog = new Dog(name, age, mobile, image);
        animal = dog;
    }

    void createCat(String name, int age, String mobile) {
        cat = new Cat(name, age, mobile, image);
        animal = cat;
    }

    void standUp() { dog.standUp(); }
    void sitDown() { dog.sitDown(); }
    void run() {
        dog.run();
    }

} //Main