package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {

    //カウント数を記憶
    private int m_count = 0;

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

    //カウント数表示を更新する
    private void updateCountDisplay(){
        TextView count_display = findViewById(R.id.textView_count_display);
        String new_text = String.valueOf(m_count);
        count_display.setText(new_text);
    }

    @Override
    public void onClick(View v) {
        //このメソッドを呼出したViewのIDを取得
        final int id = v.getId();

        //IDに応じた処理を行う
        switch (id){
            //カウントアップボタンの場合
            case R.id.button_count_up:
                ++m_count;
                updateCountDisplay();
                break;

            //リセットボタンの場合
            case R.id.button_reset:
                m_count = 0;
                updateCountDisplay();
                break;
        }
    }
}
