# UI开发


-----
## UIWidgetTest


### TextView
文字对齐方式： 
```
android:gravity="center"
```
### Button
### EditView
最大行数
```
bandroid:maxLines="1"
```
### ImageView
### ProgressBar
控件的可见属性
```
progressBar.setVisibility(View.INVISIBLE);
```
样式
```
style="?android:attr/progressBarStyleHorizontal"
```
### AlertDialog
```
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Warning");
                dialog.setMessage("nihao");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();

```
### ProgressDialog
This class was deprecated in API level 26.
```
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Hello");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
               
//              progressDialog.dismiss();

```


## UILayoutTest


-----

### 布局
1. 线性布局（LinearLayout）：按照垂直或者水平方向布局的组件
3. 帧布局（FrameLayout）：组件从屏幕左上方布局组件
3. 表格布局（TableLayout）：按照行列方式布局组件
4. 绝对布局（AbsoluteLayout）：按照绝对坐标来布局组件
5. 相对布局（RelativeLayout）：相对其它组件的布局方式
6. 约束布局 （ConstraintLayout）：按照约束布局组件
7. 百分比布局





-----

## UICustomViews





