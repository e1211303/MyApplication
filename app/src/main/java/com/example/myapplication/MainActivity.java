package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.Key;

public class MainActivity extends AppCompatActivity
    implements Button.OnClickListener   //リスナーのインターフェース（onClick）を実装することを宣言
{
    //カウント数を記憶する変数
    private int mCounts = 0;

    //Bundle型に情報を格納するときのキー
    final String Key_mCounts = "mCounts";   //重複しない文字列を使う


    //初期処理
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //既存のコールバックメソッドを必ず先に呼び出すこと
        setContentView(R.layout.activity_main); //作成したレイアウトファイルを基に画面が作られる

        //配置したView（リセットボタンとカウントアップボタン）を取得
        Button reset_button = findViewById(R.id.button_reset);
        Button count_button = findViewById(R.id.button_count_up);

        //各ボタンにMainActivity（の実体）をリスナーとしてセット
        //ボタンが押されとき、設定された参照先のオブジェクトのonCreate()が呼び出される
        reset_button.setOnClickListener(this);
        count_button.setOnClickListener(this);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState); //既存のコールバックメソッドを必ず先に呼び出すこと
        //保存しておいた mCounts の値を取り出して変数に代入
        mCounts = savedInstanceState.getInt(Key_mCounts);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState); //既存のコールバックメソッドを必ず先に呼び出すこと
        //メンバ変数 mCounts を保存しておく
        outState.putInt(Key_mCounts,mCounts);
    }

    @Override
    protected void onResume() {
        super.onResume(); //既存のコールバックメソッドを必ず先に呼び出すこと
        //表示更新
        updateCountDisplay();
    }

    //カウント表示のTextViewを取得し、内容を更新する処理を関数化した
    private void updateCountDisplay(){
        TextView count_display = findViewById(R.id.textView_count_display); //目的のTextView取得
        String new_text = String.valueOf(mCounts);  //文字列にする
        count_display.setText(new_text);    //更新
    }

    //OnClickListenerの実装部分
    @Override
    public void onClick(View v) {
        //呼び出し元のViewのIDを取得
        final int id = v.getId();

        //IDによって押されたボタンを識別し、それに応じた処理を行う
        switch (id){
            case R.id.button_reset:
                //リセットボタンが押されたときの処理
                mCounts = 0;
                updateCountDisplay();
                break;

            case R.id.button_count_up:
                ++mCounts;
                updateCountDisplay();
                break;
        }
    }
}
