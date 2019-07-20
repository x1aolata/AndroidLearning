# 广播


-----
## BroadcastTest
监听网络变化


```
// 网络状态权限
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
// 允许开机自启动
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED"/>
```


发送自定义广播
有序:sendOrderedBroadcast(intent,null);

截断此条广播  abortBroadcast()

本地广播无法通过静态注册接收



-----

## BroadcastBestPractice——实现强制下线功能

