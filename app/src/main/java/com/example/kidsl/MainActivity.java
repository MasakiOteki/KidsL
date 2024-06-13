package com.example.kidsl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView response_view = findViewById(R.id.response_view);

        //それぞれの入力方法で認識した単語を入れとく変数。仮に「インターネット」としておく。
        String word = "インターネット";
        //wordの概要を入れておく変数。
        String extract = "";
        //chatGPTへのリクエスト結果を入れておく変数
        String request = "";

        //wordが設定されているとき、MediaWikiAPIから概要を取得。
        if(word != null){
            MediaWiki mediaWiki = new MediaWiki();
            extract=mediaWiki.fetchWikipediaExtract(word);
        }
//
//        //fetchWikipediaExtractを実行した結果、extractがnothingではなかった場合にchatGPTにリクエストを送る。
        if(!extract.equals("nothing")){
            GPTRequest gptRequest = new GPTRequest();
            request = gptRequest.gpt_request(this,word,extract);
        }else {
            //プロンプト作成中につき未記述です。
        }
//
        //レスポンスがあれば結果を表示する。
        if (request != null){
            response_view.setText(request);
        }





        //手書きボタンが押されたら手書き画面へ画面遷移する--樗木
        findViewById(R.id.canvas_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Tegaki.class);
                startActivity(intent);
            }
        });



    }
}