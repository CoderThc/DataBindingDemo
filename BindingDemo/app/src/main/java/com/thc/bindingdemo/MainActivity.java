package com.thc.bindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.thc.bindingdemo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * 1、初始化xxxBinding实例、Binding类名生成规则、及自定义Binding类名
 * 2、变量绑定（两种方式）
 * 3、事件绑定（两种方式）
 * 4、使用include、给include中的控件设置数据、绑定变量
 * 5、表达式+表达式链：空合并符 会取第一个非空值作为结果。
 * 6、自定义BindAdapter
 *
 */
public class MainActivity extends AppCompatActivity{

    Handler handle  = new Handler();
    private ActivityMainBinding viewDataBinding;
    private BindingDemoBean demoBean = new BindingDemoBean("thc",15,"清华","一班");
    private ArrayList<BindingDemoBean> demos = new ArrayList<BindingDemoBean>();

    //事件绑定
    public class Presenter{
        /**
         * 实现单独更新某个属性
         * 方法绑定:这种方式要求，自定义的方法要和 public void onClick(View v) {} 一样，方法名可以不同，但是参数一定要有
         */
        public void listenBind(View view){
            demoBean.setSchool("北大");
            demoBean.setClassName("二班");
        }

        /**
         * 更新所有的属性
         * lambda表达式绑定：这种就可以任意定义了
         */
        public void lambda(BindingDemoBean bean){
            demoBean.setName("很强势");
            demoBean.setClassName("三班");
            Toast.makeText(MainActivity.this,bean.toString(),Toast.LENGTH_SHORT).show();
        }

        public void finish(View v){
            MainActivity.this.finish();
        }

        public void goRecyclerView(View view){
            startActivity(new Intent(MainActivity.this,TestBindRecyclerActivity.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initBindData();
        initInclude();
        initCustom();
    }


    /**
     * 自定义View，自定义Setter
     */
    private void initCustom() {
        viewDataBinding.setMyImageUrl("http://upload.jianshu.io/users/upload_avatars/1430230/e3d88896763e.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/120/h/120");
    }

    private void initBindData() {
//        viewDataBinding.setVariable(BR.bean,demoBean);
        //设置数据
        viewDataBinding.setBean(demoBean);

        //设置事件绑定
        viewDataBinding.setPresenter(new Presenter());

        //填充集合，设置到xml
        demos.add(demoBean);
        viewDataBinding.setBeans(demos);
        //设置集合
        ArrayList<String> strs = new ArrayList<>();
        strs.add("字符串1");
        strs.add("字符串2");
        strs.add("字符串3");
        viewDataBinding.setStrings(strs);

        //设置int类型数据
        viewDataBinding.setNum(10);

        //设置HashMap数据
        HashMap<String,String> map = new HashMap<>();
        map.put("key","测试自定义BindAdapter");
        viewDataBinding.setMap(map);

        //自定义BindAdapter
        String str = "http://upload-images.jianshu.io/upload_images/2311547-3a2cba7316308f92.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/240";
        viewDataBinding.setStr(str);

        //设置时间 自定义BindConversion
        viewDataBinding.setTime(new Date());
    }

    /**
     * 初始化Include
     */
    private void initInclude() {
        viewDataBinding.includeBar.setPresenter(new Presenter());
        viewDataBinding.includeBar.setIncludeBean(demoBean);
    }


}
