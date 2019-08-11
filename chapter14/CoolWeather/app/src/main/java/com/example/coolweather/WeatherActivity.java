package com.example.coolweather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.coolweather.gson.Forecast;
import com.example.coolweather.gson.Weather;
import com.example.coolweather.util.HttpUtil;
import com.example.coolweather.util.Utility;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {

    private ScrollView weatherLayout;

    private TextView titleCity;

    private TextView titleUpdateTime;

    private TextView degreeText;

    private TextView weatherInfoText;

    private LinearLayout forecastLayout;

    private TextView aqiText;

    private TextView pm25Text;

    private TextView comfortText;

    private TextView carWashText;

    private TextView sportText;
    private ImageView bingPicImg;

    //修改
    AutoCompleteTextView sp_province;
    TextView tv_sl; //  tv_show;
    String db_name = "weather";
    String db_path = "data/data/cn.hbu.cs.myapplication/database/";

    HttpURLConnection httpConn = null;
    InputStream din = null;
    Button find = null;
    EditText value = null;
    TextView tv_show = null;
    //结束


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_weather);
        // 初始化各控件

        weatherLayout = (ScrollView) findViewById(R.id.weather_layout);
        titleCity = (TextView) findViewById(R.id.title_city);
        titleUpdateTime = (TextView) findViewById(R.id.title_update_time);
        degreeText = (TextView) findViewById(R.id.degree_text);
        weatherInfoText = (TextView) findViewById(R.id.weather_info_text);
        forecastLayout = (LinearLayout) findViewById(R.id.forecast_layout);
        aqiText = (TextView) findViewById(R.id.aqi_text);
        pm25Text = (TextView) findViewById(R.id.pm25_text);
        comfortText = (TextView) findViewById(R.id.comfort_text);
        carWashText = (TextView) findViewById(R.id.car_wash_text);
        sportText = (TextView) findViewById(R.id.sport_text);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString = prefs.getString("weather", null);


        bingPicImg = findViewById(R.id.bing_pic_img);

        if (weatherString != null) {
            // 有缓存时直接解析天气数据
            Weather weather = Utility.handleWeatherResponse(weatherString);
            showWeatherInfo(weather);
        } else {
            // 无缓存时去服务器查询天气
            String weatherId = getIntent().getStringExtra("weather_id");
            String weathername = getIntent().getStringExtra("name");
            Log.d("x1ao", weathername);
//            weatherLayout.setVisibility(View.INVISIBLE);
//            requestWeather(weatherId);


            GetJson gd = new GetJson(weathername);//调用线程类创建的对象
            gd.start();//运行线程对象



            String bingPic = prefs.getString("bing_pic", null);
            if (bingPic != null) {
                Glide.with(this).load(bingPic).into(bingPicImg);
            } else {
                loadBingPic();
            }
        }


    }




    /**
     * 根据天气id请求城市天气信息。
     * key需要更换
     */
    public void requestWeather(final String weatherId) {
//        String weatherUrl = "https://free-api.heweather.net/s6/weather?location=" + weatherId + "&key=9b08e96491cf48a5bb2c8276f8d42040";
        String weatherUrl = "https://free-api.heweather.net/s6/weathernow?location=" + weatherId + "&key=9f728383907d4ae1a20ed05802719b54";
        Log.d("x1ao", weatherId);
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                Log.d("adsd", responseText);
                final Weather weather = Utility.handleWeatherResponse(responseText);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (weather != null && "ok".equals(weather.status)) {
                            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                            editor.putString("weather", responseText);
                            editor.apply();
                            showWeatherInfo(weather);
                        } else {
                            Toast.makeText(WeatherActivity.this, "获取天气信息失败", Toast.LENGTH_SHORT).show();
                            Log.d("adsd", "sss");
                        }

                    }
                });
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WeatherActivity.this, "获取天气信息失败", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }

    /**
     * 处理并展示Weather实体类中的数据。
     */
    private void showWeatherInfo(Weather weather) {
        String cityName = weather.basic.cityName;
        String updateTime = weather.basic.update.updateTime.split(" ")[1];
        String degree = weather.now.temperature + "℃";
        String weatherInfo = weather.now.more.info;
        titleCity.setText(cityName);
        titleUpdateTime.setText(updateTime);
        degreeText.setText(degree);
        weatherInfoText.setText(weatherInfo);
        forecastLayout.removeAllViews();
        for (Forecast forecast : weather.forecastList) {
            View view = LayoutInflater.from(this).inflate(R.layout.forecast_item, forecastLayout, false);
            TextView dateText = (TextView) view.findViewById(R.id.date_text);
            TextView infoText = (TextView) view.findViewById(R.id.info_text);
            TextView maxText = (TextView) view.findViewById(R.id.max_text);
            TextView minText = (TextView) view.findViewById(R.id.min_text);
            dateText.setText(forecast.date);
            infoText.setText(forecast.more.info);
            maxText.setText(forecast.temperature.max);
            minText.setText(forecast.temperature.min);
            forecastLayout.addView(view);
        }
        if (weather.aqi != null) {
            aqiText.setText(weather.aqi.city.aqi);
            pm25Text.setText(weather.aqi.city.pm25);
        }
        String comfort = "舒适度：" + weather.suggestion.comfort.info;
        String carWash = "洗车指数：" + weather.suggestion.carWash.info;
        String sport = "运行建议：" + weather.suggestion.sport.info;
        comfortText.setText(comfort);
        carWashText.setText(carWash);
        sportText.setText(sport);
        weatherLayout.setVisibility(View.VISIBLE);


    }


    //修改

    private void copydb() {
        File db_file = new File(db_path + db_name);
        if (!db_file.exists()) {
            //如果第一次运行，文件不存在，那么就建立database目录,并从raw目录下复制db_weather.db
            Log.i("weather", "数据库创建好了");
            File db_dir = new File(db_path);
            if (!db_dir.exists()) {
                db_dir.mkdir();
            }
            InputStream is = getResources().openRawResource(R.raw.weather);
            //获取输入流，就是随程序打包，放到raw目录下的db_weater.db文件
            try {
                OutputStream os = new FileOutputStream(db_path + db_name);
                byte[] buff = new byte[1024];
                int length = 0;
                while ((length = is.read(buff)) > 0) {
                    os.write(buff, 0, length);
                }
                os.flush();
                os.close();
                is.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 666:
                    showData((String) msg.obj);
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private void showData(String jData) {
        try {
            JSONObject jobj = new JSONObject(jData);
            JSONObject weather = jobj.getJSONObject("data");
            StringBuffer wbf = new StringBuffer();
            titleCity.setText(weather.getString("city"));
            degreeText.setText(weather.getString("wendu") + " °C");
//            weatherInfoText.setText(weather.getString("fs"));

            JSONArray jary = weather.getJSONArray("forecast");
            for (int i = 0; i < jary.length(); i++) {
                JSONObject pobj = (JSONObject) jary.opt(i);
                View view = LayoutInflater.from(this).inflate(R.layout.forecast_item, forecastLayout, false);
                TextView dateText = (TextView) view.findViewById(R.id.date_text);
                TextView infoText = (TextView) view.findViewById(R.id.info_text);
                TextView maxText = (TextView) view.findViewById(R.id.max_text);
                TextView minText = (TextView) view.findViewById(R.id.min_text);
                dateText.setText(pobj.getString("date"));
                infoText.setText(pobj.getString("type"));
                maxText.setText(pobj.getString("high"));
                minText.setText(pobj.getString("low"));

                forecastLayout.addView(view);
                if (i == 0) {
                    weatherInfoText.setText(pobj.getString("fengxiang") + "   " + pobj.getString("type"));
                }
            }

            comfortText.setText(weather.getString("ganmao"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    class GetJson extends Thread {

        private String urlstr = "http://wthrcdn.etouch.cn/weather_mini?city=";
        private String name;

        public GetJson(String cityname) {
            try {
                urlstr = urlstr + URLEncoder.encode(cityname, "UTF-8");
                name = cityname;
                loadBingPic();
            } catch (Exception ee) {

            }
        }

        @Override
        public void run() {
            try {
                URL url = new URL(urlstr);
                httpConn = (HttpURLConnection) url.openConnection();
                httpConn.setRequestMethod("GET");
                din = httpConn.getInputStream();

                InputStreamReader in = new InputStreamReader(din);
                BufferedReader buffer = new BufferedReader(in);
                StringBuffer sbf = new StringBuffer();
                String line = null;

                while ((line = buffer.readLine()) != null) {
                    sbf.append(line);
                }
                sbf.append(name);
                Message msg = new Message();
                msg.obj = sbf.toString();
                msg.what = 666;

                handler.sendMessage(msg);
                Looper.prepare(); //在线程中调用Toast，要使用此方法。这里纯粹演示用:)
                Toast.makeText(WeatherActivity.this, "获取数据成功", Toast.LENGTH_LONG).show();
                Looper.loop(); //在线程中调用Toast，要使用此方法
            } catch (Exception ee) {
                Looper.prepare(); //在线程中调用Toast，要使用此方法
                Toast.makeText(WeatherActivity.this, "获取数据失败，网络连接失败或输入有误", Toast.LENGTH_LONG).show();
                Looper.loop(); //在线程中调用Toast，要使用此方法
                ee.printStackTrace();
            } finally {
                try {
                    httpConn.disconnect();
                    din.close();
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        }
    }
    //结束
    /**
     * 加载必应每日一图
     */
    private void loadBingPic() {
        String requestBingPic = "http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkHttpRequest(requestBingPic, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String bingPic = response.body().string();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                editor.putString("bing_pic", bingPic);
                editor.apply();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(WeatherActivity.this).load(bingPic).into(bingPicImg);
                    }
                });
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
        });
    }


}
