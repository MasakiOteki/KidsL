//参考サイト https://cysec.ise.ritsumei.ac.jp/2022/11/03/android-studio-%E3%81%A7-python-%E3%82%92%E4%BD%BF%E3%81%86/
//Pythonのコードは関数化しておく。使いたい関数があるpyファイルを指定し、その中の特定の関数を呼び出す。
package com.example.kidsl;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class GPTRequest {

    public String gpt_request (Context context, String word, String extract){

        // Python環境の初期化
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(context));
        }
        //Pythonのインスタンス生成
        Python py = Python.getInstance();
        //request_for_GPT.pyのモジュール取得。testの部分は使いたいファイルの.py以前を書く
        PyObject module = py.getModule("request_for_GPT");
        //関数を使う(aiueo関数の戻り値を変数aにいれる)
        String response = module.callAttr("gpt",word,extract).toString();

        return response;
    }
}
