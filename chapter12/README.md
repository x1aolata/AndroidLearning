# 最佳的UI体验—— Material Design 实战


**浅色主题**：Theme.AppCompat.Light.NoActionBar
**深色主题**：Theme.AppCompat.NoActionBar

### Toolbar
### DrawerLayout（抽屉式布局）
```
<android.support.v4.widget.DrawerLayout>

    <XXXLayout>
	主布局
    </XXXLayout>

    <XXXLayout>
	滑动菜单
    android:layout_gravity="start"
    </XXXLayout>
</android.support.v4.widget.DrawerLayout>
```
其中子菜单中的**layout_gravity**属性必须指定

* start——表示会根据系统语言进行判断
* left——左边
* right——右边

### NavigationView

依赖：implementation 'com.android.support:design:28.0.0'

#### CircleImageView——实现图片圆形化
依赖：implementation 'de.hdodenhof:circleimageview:2.1.0'

-----


### FloatingActionButton（悬浮式按钮）
```
<android.support.design.widget.FloatingActionButton
            android:id="@+id/fab"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom|end"				//位置，可以设置为start
            android:layout_margin="16dp"
            app:backgroundTint="#000000"				//背景颜色
            app:rippleColor="#C90E0E"					//点击颜色
            android:src="@drawable/ic_done"				//图标
            app:elevation="8dp" 					//悬浮高度
            />
```
### SnackBar
```
 Snackbar.make(v, "删东西了", Snackbar.LENGTH_SHORT)
                        .setAction("别啊", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "那就不删了", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
```

### CoordinatorLayout
加强版FrameLayout  
自动调整


-----


##卡片式布局















