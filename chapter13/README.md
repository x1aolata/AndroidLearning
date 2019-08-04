# 进阶技巧

### 使用Intent传递对象
#### Serializable方式
实现接口即可
```
public class Person implements Serializable {
    public Person(String name,boolean ismarried)
    {
        this.name=name;
        this.ismarried=ismarried;
    }
    private String name;
    private boolean ismarried;
}
```
#### Parcelable
不太好写

### 调试Android程序

### 创建定时任务






