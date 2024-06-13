//作成者--樗木


package com.example.kidsl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class Tegaki extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tegaki);



        final CanvasView cv =(CanvasView) findViewById(R.id.canvas_view);
        final TextView textView = findViewById(R.id.kouho_view);
        final Button search_button = findViewById(R.id.search_button);
        final Button clear_button = findViewById(R.id.clear_button);


        //クリアボタンが押されたときの処理
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cv.allClear();
            }
        });

        //サーチボタンが押されたときの処理
        search_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Tegaki.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}

