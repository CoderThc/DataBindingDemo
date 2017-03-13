package com.thc.bindingdemo;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/13.
 */

public class BindAdapter {
    /**
     * 加载网络图片
     */
    @BindingAdapter({"app:imageUrl", "app:placeholderDraw"})
    public static void setNetImg(ImageView ivNet, String imgUrl, Drawable placeHodler) {
        Glide.with(ivNet.getContext()).load(imgUrl).placeholder(placeHodler).into(ivNet);
    }

    /**
     * 给将第一个字符变成红色
     */
    @BindingAdapter("app:text")
    public static void setSpannelText(TextView textView, String text) {
        SpannableString spannableString = new SpannableString(text);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
        spannableString.setSpan(colorSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
    }

    @BindingConversion
    public static String convertTime(Date date) {
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
        return time.format(date);
    }

}
