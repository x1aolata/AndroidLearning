# 服务

-----

### 在子线程中更新UI
和其他许多的GUI库一样，Android的UI线程是不安全的。则如果想更新UI就必须在主线程中进行，否则就会出现异常。


#### 异步消息处理机制

Message  
Handler


使用**AsyncTask**

### 服务

活动和服务进行通信
服务的生命周期

### 前台服务
**注意：**  需要前台服务权限
```
  <uses-permission android:name="android.permission.FOREGROUND_SERVICE"/>
```


### 最佳实践

仍需要前台服务权限
并且在**DownloadService** 文件中 **getNotification（）** 方法与之前的通知一样，需要更改。