package com.thc.bindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by thc on 2017/3/13.
 */

public class BindingDemoBean extends BaseObservable {
    private String name;

    private int age;
    private String school;
    private String className;

    public BindingDemoBean(String name, int age, String school, String className) {
        this.name = name;
        this.age = age;
        this.school = school;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //更新所有的属性
        notifyChange();
    }

    @Bindable
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
        //更新单个属性
        notifyPropertyChanged(com.thc.bindingdemo.BR.school);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BindingDemoBean{" +
                "className='" + className + '\'' +
                ", school='" + school + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
