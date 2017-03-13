package com.thc.bindingdemo;

import android.app.Fragment;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thc.bindingdemo.databinding.CustomBindingName;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/3/12.
 */

public class BindingFragment extends Fragment {

    private CustomBindingName customBindingName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        customBindingName = DataBindingUtil.inflate(inflater, R.layout.fragment, container, false);
        initRecyclerView();
        return customBindingName.getRoot();
    }

    private void initRecyclerView() {
        customBindingName.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        customBindingName.recyclerView.setAdapter(new MyAdapter(getActivity(),initDatas()));
    }

    private List<BindingDemoBean> initDatas() {
        List<BindingDemoBean> list = new ArrayList<>();
        for(int i = 0;i<10;i++){
            list.add(new BindingDemoBean("item" + i
                    ,10
                    ,"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png"
                    ,""));
        }
        return list;
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{
        Context mContext;
        List<BindingDemoBean> mDatas;
        public MyAdapter(Context conetxt,List<BindingDemoBean> list){
            this.mContext = conetxt;
            this.mDatas = list;
        }
        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflate = LayoutInflater.from(mContext);
            ViewDataBinding binding = DataBindingUtil.inflate(inflate, R.layout.item_recyclerview, parent, false);
            return new MyHolder(binding);
        }
        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            ViewDataBinding binding = holder.getBinding();
            BindingDemoBean bindingDemoBean = mDatas.get(position);
            //执行一下executePendingBindings,及时刷新
            binding.executePendingBindings();
            binding.setVariable(com.thc.bindingdemo.BR.item,bindingDemoBean);
        }
        @Override
        public int getItemCount() {
            return mDatas.size();
        }
        class MyHolder extends RecyclerView.ViewHolder{
            private ViewDataBinding mBinding;
            public MyHolder(ViewDataBinding mBinding) {
                super(mBinding.getRoot());
                this.mBinding = mBinding;
            }
            public ViewDataBinding getBinding(){
                return mBinding;
            }
        }
    }

}
