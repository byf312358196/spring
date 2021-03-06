package com.byf.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boss {
    private Car car;

    //构造器要使用的组件，都是从容器中获取
    public Boss(@Autowired Car car){
        this.car = car;
    }

    //@Autowired
    //标注在方法：Spring容器创建当前对象，就会调用方法，完成赋值；
    // 方法使用的参数，自定义类型的值从ioc容器中获取
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
