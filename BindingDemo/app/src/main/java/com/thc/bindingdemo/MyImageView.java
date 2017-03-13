package com.thc.bindingdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2017/3/13.
 */

public class MyImageView extends ImageView {
    private String imgUrl;
    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        Glide.with(getContext()).load(imgUrl).into(this);
    }
}
