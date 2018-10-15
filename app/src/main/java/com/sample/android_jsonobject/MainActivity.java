package com.sample.android_jsonobject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        try{
            // JSONObjectの宣言
            JSONObject json = new JSONObject();

            // データの追加
            json.put("int",30)
            .put("string","文字列")
            .put("bool",true);

            // 文字列に変換してログ出力
            String strObj = json.toString();
            Log.d("sample","JSONObject:"+strObj);

            // toStringの展開
            JSONObject a = new JSONObject(strObj);
            Log.d("sample","toStringでの展開:"+a.toString());

            // 中に含まれるデータの取得
            int i = json.getInt("int");
            Log.d("sample","intの取得:"+i);

            // JSONObjectへJSONObjectの追加と
            // 中に含まれているJSONObjectからのデータの取得
//            JSONObject item = new JSONObject();
//            item.put("a",1).put("b",2);
//            json.put("item",item);
//            JSONObject itemObj = json.getJSONObject("item");
//            int ii = itemObj.getInt("a");
//            Log.d("sample","JSONの取得:"+ii);

            // データの削除
//            json.remove("string");
//            strObj = json.toString();
//            Log.d("sample","stringの削除:"+strObj);


            // JSONArrayの宣言
            JSONArray jArray = new JSONArray();
            jArray.put(100)
                    .put("strong")
                    .put(false);
            String strArr = jArray.toString();
            Log.d("sample","JSONArray:"+strArr);

            // 要素の取得には要素番号を指定する
//            int j = jArray.getInt(0);
//            Log.d("sample","要素[0]の取得:"+j);


            // JSONArrayをJSONObjectに追加
            json.put("arr",jArray);
            strObj = json.toString();
            Log.d("sample","Arrayの追加:"+strObj);

            // 独自のクラスも追加可能
            // 取得の時はキャストが必要
//            JSONObject jsonTest = new JSONObject();
//            jsonTest.put("tc",new TestClass(200));
//            TestClass tc = (TestClass) jsonTest.get("tc");
//            Log.d("sample","独自のクラス:"+tc.n);

        }catch(JSONException e){
            e.printStackTrace();
        }
    }

    public class TestClass{
        int n;

        TestClass(int _n){
            n = _n;
        }
    }
}
