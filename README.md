# AbsAdapter

## 介绍
AbsAdapter 是一个积木化的Adapter </br>

* 使用AbsAdapter，不同样式的Item将可以自由组合
* 使用AbsAdapter，每个Item样式都将被独立出来
* 使用AbsAdapter，将来需要增加或减少样式将变得很简单
* 使用AbsAdapter，Adapter的代码将变得很简洁
* 最关键的是，每一个item样式可以被ListView 或 RecyclerView 共用，而不需要修改任何逻辑

----
- [用例](#用例)
- [使用](#使用)
- [RecyclerView点击事件](#点击事件)

----
* 如果你觉得我的代码对你有帮助，请麻烦您在右上角给我一个`star`.
* 如过你对我的代码有任何疑问或者发现任何bug，麻烦您在[issues](https://github.com/AriaLyy/AbsAdapter/issues)告诉我

## lib
compile 'com.jakewharton:butterknife:6.1.0' </br>
compile 'com.arialyy.absadapter:AbsAdapter:1.1.0'</br>

为了防止gradle编译失败，你还需要在app 的 build.gradle 文件的`android{}`块中添加以下代码
```
android{
    ...
    packagingOptions {
        exclude 'META-INF/services/javax.annotation.processing.Processor'
    }
}
```

## 用例

* TestAdapter_1
```java
public class RvAdapter_1 extends AbsRvDAdapter<AbsDEntity> {
    public RvAdapter_1(Context context, List<AbsDEntity> data, FragmentManager fm) {
        super(context, data);
        getManager().addDelegate(new BannerDelegate(context, this, fm));
        getManager().addDelegate(new RvGameDetailDelegate(context, this));
        getManager().addDelegate(new RvGameNotifyDelegate(context, this));
    }
}
```

* TestAdapter_2
```java
public class RvAdapter_2 extends AbsRvDAdapter<AbsDEntity> {
    public RvAdapter_2(Context context, List<AbsDEntity> data, FragmentManager fm) {
        super(context, data);
        getManager().addDelegate(new BannerDelegate(context, this, fm));
        getManager().addDelegate(new RvGameDetailDelegate(context, this));
        getManager().addDelegate(new RvGameNotifyDelegate(context, this));
        getManager().addDelegate(new TextDelegate(context, this));
        getManager().addDelegate(new ImgDelegate(context, this));
    }
}
```

* TestAdapter_3
```java
public class RvAdapter_3 extends AbsRvDAdapter<AbsDEntity> {
    public RvAdapter_3(Context context, List<AbsDEntity> data) {
        super(context, data);
        getManager().addDelegate(new RvGameDetailDelegate(context, this));
        getManager().addDelegate(new RvGameNotifyDelegate(context, this));
    }
}
```
![test.png](https://github.com/AriaLyy/AbsAdapter/blob/master/img/img.png)

> 如上图及代码所示，在Adapter 里面 item样式 可以像积木一样被自由组合并且可以随意增加或减少

## 使用
1、 创建一个实体，并继承AsbDEntity，然后通过`@AbsType`注解，让实体和Delegate绑定。</br>
ps：实体和Delegate是通过编译时的注解绑定的，使用AbsType注解，不会影响你列表的性能。
```java
@AbsType(type = Constance.ADAPTER_TYPE.TYPE_GAME_DETAIL, delegate = GameDetailDelegate.class)
public class GameDetailEntity extends AbsDEntity{
    String imgUrl;
    String title;
    String detail;
}
```

2、 创建一个Item样式，每一个Item样式都有独立的 Holder，因此，你还需要创建相应的Holder
```java
/**
 *  创建
 */
public class TextDelegate extends AbsDelegation<TextEntity, TextDelegate.LvTextHolder> {

    public TextDelegate(Context context, AbsIAdapter adapter, int itemType) {
        super(context, adapter, itemType);
    }

    @Override
    public LvTextHolder createHolder(View convertView) {
        return new LvTextHolder(convertView);
    }

    /**
     * 绑定你的数据
     */
    @Override
    public void bindData(int position, TextDelegate.LvTextHolder helper, TextEntity item) {
        helper.mText.setText(item.getText());
    }

    /**
     * 设置布局id
     */
    @Override
    public int setLayoutId() {
        return R.layout.item_text;
    }

    /**
     * 创建Delegate对应的Holder
     */
    public class LvTextHolder extends AbsHolder {
        @InjectView(R.id.text)
        TextView mText;

        public LvTextHolder(View itemView) {
            super(itemView);
        }
    }
}
```
现在，你已经拥有了一个模块化的Item

3、 创建ListView Adapter 或者 RecyclerView Adapter

注意 ：</br>
* 如果你的列表是ListView，你需要继承`AbsLvDAdapter` </br>
* 如果你的列表是RecyclerView，你需要继承`AbsRvDAdapter` </br>
* `AbsLvDAdapter` 或者 `AbsRvDAdapter` 可以共用一个Item样式

```java
/**
 * RecyclverView  的Adapter
 */
public class RvAdapter extends AbsRvDAdapter<AbsDEntity> {
    public RvAdapter(Context context, List<AbsDEntity> data) {
        super(context, data);
        //在Adapter 中注册你需要的 Item 样式
        getManager().addDelegate(new TextDelegate(context, this));
    }
}
```

```java
/**
 * ListerView  的Adapter
 */
public class LvAdapter extends AbsLvDAdapter<AbsDEntity> {
    public LvAdapter(Context context, List<AbsDEntity> data) {
        super(context, data);
        //在Adapter 中注册你需要的 Item 样式， 1 为你 在对应的实体通过重载“getAbsType”设置的参数
        getManager().addDelegate(new TextDelegate(context, this));
    }
}
```

## 点击事件
对于RecyclerView 的 item点击监听。</br>
现在，你可以使用以下方法来设置Item点击事件，避免Adapter恶心的事件传递:</br>

* Item点击事件

```
RvItemClickSupport.addTo(recyclerView).setOnItemClickListener(new RvItemClickSupport.OnItemClickListener() {
     @Override
     public void onItemClicked(RecyclerView recyclerView, int position, View v) {
          //处理你的事件
 });
```

* Item长按事件

```
RvItemClickSupport.addTo(recyclerView).setOnItemLongClickListener(new RvItemClickSupport.OnItemLongClickListener() {
    @Override
    public boolean onItemLongClicked(RecyclerView recyclerView, int position, View v) {
        //处理你的事件
        return false;
    }
});
```

* Item 触摸事件

```
RvItemClickSupport.addTo(mList).setOnItemTouchListener(new RvItemClickSupport.OnItemTouchListener() {
    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e, int position, View v) {
         //处理你的事件
    }
});
```

## License

    Copyright 2016 AriaLyy (AbsAdapter)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
