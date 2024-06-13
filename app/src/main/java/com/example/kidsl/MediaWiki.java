package com.example.kidsl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kidsl.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MediaWiki extends AppCompatActivity {

    public String fetchWikipediaExtract(String word) {
        //レスポンス入れる用
        String[] displayString = {""};


        //リクエストURLを設定
        String url = "https://ja.wikipedia.org/w/api.php?action=query&prop=extracts&exintro&explaintext&redirects=1&titles=" + word + "&format=json";

        //OkHttpClientのインスタンス生成
        OkHttpClient client = new OkHttpClient();

        //リクエスト構築
        Request request = new Request.Builder().url(url).build();

        //非同期でリクエストを送信
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                //リクエスト失敗の処理
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                //リクエスト成功の処理
                if (response.isSuccessful()) {
                    //レスポンスボディをString型に変換
                    String responseData = response.body().string();
                    //帰ってきたJSONをパースする
                    try {
                        JSONObject json = new JSONObject(responseData);
                        JSONObject query = json.getJSONObject("query");
                        JSONObject pages = query.getJSONObject("pages");
                        String extract = "";

                        //ページIDを取得してその概要をとる。(この辺サンプル参考にしたからあんまわかってない)
                        for (Iterator<String> it = pages.keys(); it.hasNext(); ) {
                            String key = it.next();
                            JSONObject page = pages.getJSONObject(key);


                            //レスポンスのタイトルと、実際に調べたワードが一致しているか
                            if (page.getString("title").equals(word)) {
                                displayString[0] = page.getString("extract");
                            } else {
                                displayString[0] = "nothing";
                            }

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }


        });

        return displayString[0];

    }

}
