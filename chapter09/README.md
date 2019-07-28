# 使用网络技术

-----

### WebView

### 使用HTTP协议访问网络
ScrollView  以滚动的形式查看屏幕外的内容
OkHttp

依赖：implementation 'com.squareup.okhttp3:okhttp:4.0.1'

### 解析XML数据
1.Pull 
2.SAX
按照书上代码来一直没成功
这是因为新的保护机制对于仅使用安全通信的应用，Android 6.0 Marshmallow（API 级别 23）引入了两种机制来解决回退到明文通信的问题：
(1) 在生产/安装库中，禁止明文通信，
(2) 在开发/QA 期间，在遇到任何非 TLS/SSL 通信时，予以记录或者触发崩溃

解决：
如果一定要使用明文通信的话，则可以打开AndroidManifest.xml 文件，在 application 元素中添加：
```
android:usesCleartextTraffic=”true” 
```

### 解析JSON数据
1. JSONObject：
getString()获取value值时，而返回的JSON里面并不存在这个value，会报错
optString()使用这个方法在获取不存在的value时不会直接报异常而是返回一个空字符串

2. 谷歌GSON
依赖：implementation 'com.google.code.gson:gson:2.8.5'
简单




### 回调？？？看不懂



