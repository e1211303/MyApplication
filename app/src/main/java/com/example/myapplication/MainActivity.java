package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタンにリスナを設定する処理
        setOnClickListeners();
    }

    //配置済みのボタンにリスナを設定する
    private void setOnClickListeners(){

        //配置されたButtonを取得
        Button count_button = findViewById(R.id.button_count_up);
        Button reset_button = findViewById(R.id.button_reset);

        //MainActivity自身をリスナとして設定する
        count_button.setOnClickListener(this);
        reset_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
