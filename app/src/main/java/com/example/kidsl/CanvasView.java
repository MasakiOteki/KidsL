//参考サイト https://qiita.com/Higman/items/3803d893d16eb2375709

//作成者--樗木


package com.example.kidsl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.provider.DocumentsContract;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import android.graphics.Path;

import java.util.ArrayList;

public class CanvasView extends View {

    private final ArrayList<Path> pathList;
    private final Paint paint;

    public CanvasView(Context context, AttributeSet attrs){
        super(context, attrs);

        pathList = new ArrayList<Path>();

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);

    }
    //描画メソッド
    @Override
    protected void onDraw(Canvas canvas){
        for(Path path : pathList){
            canvas.drawPath(path, paint);
        }
        invalidate();
    }

    //タッチイベントメソッド
    private Path drawingPath;
    @Override
    public  boolean onTouchEvent(MotionEvent event){

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                drawingPath = new Path();
                drawingPath.moveTo(event.getX(),event.getY());
                pathList.add(drawingPath);
                break;
            case MotionEvent.ACTION_UP:
                drawingPath.moveTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                drawingPath.lineTo(event.getX(),event.getY());
                break;
        }
        return  true;

    }

    //クリアメソッド
    public void allClear(){
        pathList.clear();
    }
    //ビットマップで描画された画像を取得
    public Bitmap getBitmap(){
        Bitmap bitmap = Bitmap.createBitmap(getWidth(),getHeight(),Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        draw(canvas);
        return bitmap;
    }




}


