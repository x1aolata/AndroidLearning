# 探究活动


-----
## ActivityTest
### 2.2.5 在活动中使用Menu
需要创建res/menu/XXX.xml
创建菜单重写**onCreateOptionsMenu**
响应事件重写**onOptionsItemSelected**
### 2.2.6 销毁一个活动
**finish()**
### 2.3.1 使用隐式Intent
### 2.3.5 返回数据给上一个活动



-----


## ActivityLifeCycleTest
### 2.4 活动的生命周期
#### 四种状态：
1. 运行状态
2. 暂停状态
3. 停止状态
4. 销毁状态
#### 活动的生存期
Activity类的七个回调方法，覆盖了活动生命周期的每一个环节。

1. onCreate()————————初始化操作，活动第一次被创建时调用

2. onStart()—————————启动操作，活动由不可见变为可见时调用

3. onResume()————————交互操作，活动准备与用户交互时调用

4. onPause()—————————暂停操作，系统准备启动或恢复另一个活动时调用

5. onStop()——————————停止操作，活动完全不可见的时候调用

6. onDestroy()————————回收操作，活动被销毁之前调用

7. onRestart()————————重启操作，活动由停止变为运行状态之前调用

以上方法除了onRestart()方法，其他都是对应的，从而又可以将活动分为三种生存周期

#### 完整生存期：
　　活动onCreate()方法和onDestroy()方法之间所经历的，就是完整生存周期。一般情况下，一个活动会在onCreate()方法中完成各种初始化操作，而在onDestroy()方法中完成释放内存的操作。

#### 可见生存期：
　　活动在onStart()方法和onStop()方法之间所经历的，就是可见生存周期。在可见生存期内，活动对于用户总是可见的，即便有可能无法和用户进行交互。可以通过这两种方法，合理的管理那些对用户可见的资源。

#### 前台生存期：
　　活动在onResume()方法和onPause()方法之间所经历的，就是前台生存周期。在前台生存期内，活动总是处于运行状态的，此时的活动是可以和用户进行交互的，和用户接触最多的也就是这个状态下的活动了。
  
#### 将活动设置为对话框
```
 <activity
            android:name=".DialogActivity"
            android:theme="@style/Theme.AppCompat.Dialog"></activity>
```

### 2.4.5 活动被回收保存数据
重写**protected void onSaveInstanceState(Bundle outState)**




