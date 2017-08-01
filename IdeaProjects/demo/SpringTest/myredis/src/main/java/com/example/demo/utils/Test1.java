package com.example.demo.utils;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;

/**
 * Created by boxfish on 17/7/7.
 */
public class Test1 {
    public static void main(String[] args) {
//        unserializable();

        int i = NumberUtils.toInt("B");
        System.out.println("i="+i);
        int difficulty = NumberUtils.toInt(Lists.newArrayList("3").toString(), 5);
        System.out.println("difficult="+difficulty);
    }

    public static void unserializable(){
        try {
            // 对user序列化
            String userStr = FormatUtils.toJson(new User("xiaomimg",12, Lists.newArrayList("huahua","lulu")));
            System.out.println("userStr=" + userStr);

            String userStr2 = FormatUtils.toJsonNoException(new User("xiaomimg",12, Lists.newArrayList("huahua","lulu")));
            System.out.println("userStr2="+userStr2);

            String userStr3 = FormatUtils.toXml(new User("xiaomimg",12, Lists.newArrayList("huahua","lulu")));
            System.out.println("userStr3="+userStr3);

            // 对userStr反序列化
            User user = FormatUtils.fromJson(userStr, User.class);
            System.out.println("user=" + user);

            User user1 = FormatUtils.fromXml(userStr3,User.class);
            System.out.println("user1="+user1);

        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
