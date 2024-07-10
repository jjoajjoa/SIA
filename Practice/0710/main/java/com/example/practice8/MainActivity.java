package com.example.practice8;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 변수들
    EditText inputName;
    EditText inputAge;
    TextView outputText;
    ImageView imageInfo;
    TextView outputName;
    TextView outputAge;
    LinearLayout container;
    // 동물객체
    Dog dog;
    ArrayList<Dog> dogs = new ArrayList<Dog>();
    int selected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    } //onCreate()

    void init() {
        inputName = findViewById(R.id.inputName);
        inputAge = findViewById(R.id.inputAge);
        outputText = findViewById(R.id.outputText);
        imageInfo = findViewById(R.id.imageInfo);
        outputName = findViewById(R.id.outputName);
        outputAge = findViewById(R.id.outputAge);
        container = findViewById(R.id.container);

        Button btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(v -> {
            createDog();
        });

    } //init()

    void createDog() {
        // 강아지 입력값 받기
        String name = inputName.getText().toString();
        String ageStr = inputAge.getText().toString();
        if (name.isEmpty() || ageStr.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter the details.", Toast.LENGTH_SHORT).show();
            return;
        }
        int age = Integer.parseInt(ageStr);
        // 강아지 객체 생성
        dog = new Dog(name, age, R.drawable.dog);
        dogs.add(dog);
        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
        outputText.setText("총 " + dogs.size() + " 마리");
        // 입력창 초기화
        inputName.setText("");
        inputAge.setText("");
        // 리스트에 이미지 띄우기
        ImageView imageView1 = new ImageView(getApplicationContext());
        imageView1.setImageResource(R.drawable.dog);
        container.addView(imageView1);
        // 리스트에 이미지 클릭해서 정보 띄우기
        clickMiniImage();
    } //createAnimal()

    //////////////////////////////////////////////////////////////////

    void clickMiniImage() {
        // 기존 강아지 목록 초기화
        container.removeAllViews();
        // 각 강아지 객체에 대한 이미지뷰 및 텍스트뷰를 추가
        for (int i = 0; i < dogs.size(); i++) {
            Dog dog = dogs.get(i);
            // 강아지 이미지를 위한 ImageView 생성
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(dog.resld);
            // 강아지 이름을 위한 TextView 생성
            TextView textView = new TextView(getApplicationContext());
            textView.setText(dog.name);
            // 강아지 정보를 담을 LinearLayout 생성
            LinearLayout dogLayout = new LinearLayout(getApplicationContext());
            dogLayout.setOrientation(LinearLayout.VERTICAL);
            dogLayout.addView(imageView);
            dogLayout.addView(textView);
            // 강아지 객체의 인덱스를 태그로 설정하여 클릭 이벤트에서 활용
            dogLayout.setTag(i);
            // 클릭 이벤트 설정
            dogLayout.setOnClickListener(v -> {
                selected = (int) v.getTag();
                showDogDetails(selected);
            });
            // container에 강아지 레이아웃 추가
            container.addView(dogLayout);
        }
    } // updateDogList()

    void showDogDetails(int index) {
        if (index < 0 || index >= dogs.size()) return;
        Dog dog = dogs.get(index);
        imageInfo.setVisibility(View.VISIBLE);
        imageInfo.setImageResource(dog.resld);
        outputName.setText(dog.name);
        outputAge.setText(String.valueOf(dog.age));
    } // showDogDetails()

    //////////////////////////////////////////////////////////////////

    // 입력 완료 후 키보드 내리기
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View focusView = getCurrentFocus();
        if (focusView != null) {
            Rect rect = new Rect();
            focusView.getGlobalVisibleRect(rect);
            int x = (int) ev.getX(), y = (int) ev.getY();
            if (!rect.contains(x, y)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (imm != null)
                    imm.hideSoftInputFromWindow(focusView.getWindowToken(), 0);
                focusView.clearFocus();
            }
        }
        return super.dispatchTouchEvent(ev);
    }

} //Main