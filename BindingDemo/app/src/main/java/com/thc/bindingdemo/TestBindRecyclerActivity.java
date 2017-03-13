package com.thc.bindingdemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thc.bindingdemo.databinding.ActivityTestBindRecyclerBinding;

public class TestBindRecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestBindRecyclerBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_bind_recycler);
        getFragmentManager().beginTransaction().add(R.id.container,new BindingFragment(),null).commit();
    }
}
