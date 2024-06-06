//作成者--樗木


package com.example.kidsl;

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

        Button bt = (Button) findViewById(R.id.clear_button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cv.allClear();
            }
        });

    }
}

